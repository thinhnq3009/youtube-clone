package dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entity.User;
import entity.Video;
import entity.View;
import exception.DaoException;
import handler.DateHelper;
import interfaces.CURDable;
import utils.JpaUtils;

public class VideoDao implements CURDable<Video> {

	@Override
	public void insert(Video e) throws DaoException {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();

		try {

			tran.begin();

			em.persist(e);

			tran.commit();

		} catch (Exception e2) {
			tran.rollback();
			e2.printStackTrace();
			throw new DaoException("Error insert new video");
		} finally {
			em.close();
		}

	}

	@Override
	public void update(Video e) throws DaoException {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();

		try {

			tran.begin();

			em.merge(e);

			tran.commit();

		} catch (Exception e2) {
			tran.rollback();
			e2.printStackTrace();
			throw new DaoException("Error update new video");
		} finally {
			em.close();
		}

	}

	@Override
	public Video delete(long id) throws DaoException, EntityNotFoundException {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		Video video = null;
		try {

			tran.begin();

			video = em.find(Video.class, id);

			if (video != null) {
				em.remove(video);
			} else {
				throw new EntityNotFoundException("No videos found with id = " + id);
			}

			tran.commit();

		} catch (Exception e2) {
			tran.rollback();
			e2.printStackTrace();
			throw new DaoException("Error insert new video");
		} finally {
			em.close();
		}
		return video;
	}

	@Override
	public Video findById(long id) {
		EntityManager em = JpaUtils.getEntityManager();
		return em.find(Video.class, id);
	}

	@Override
	public List<Video> getAll() {
		EntityManager em = JpaUtils.getEntityManager();

		String jpql = "SELECT v FROM Video v";

		TypedQuery<Video> query = em.createQuery(jpql, Video.class);

		return query.getResultList();

	}

	public Video findByCode(String code) {
		EntityManager em = JpaUtils.getEntityManager();

		String jpql = "SELECT v FROM Video v WHERE v.code = :code";

		TypedQuery<Video> query = em.createQuery(jpql, Video.class);

		query.setParameter("code", code);

		return query.getResultList().isEmpty() ? null : query.getSingleResult();
	}

	public List<Video> getVideoByUser(User users) {
		EntityManager em = JpaUtils.getEntityManager();

		String jpql = "SELECT v FROM Video v WHERE v.user.id = :id";

		TypedQuery<Video> query = em.createQuery(jpql, Video.class);

		query.setParameter("code", users.getId());

		return query.getResultList();
	}

	public List<Video> findByKeyWord(String key) {

		if (!key.startsWith("%")) {
			key = "%" + key;
		}

		if (!key.endsWith("%")) {
			key = key + "%";
		}

		EntityManager em = JpaUtils.getEntityManager();

		String jpql = "SELECT v FROM Video v WHERE v.title LIKE :key";

		TypedQuery<Video> query = em.createQuery(jpql, Video.class);

		query.setParameter("key", key);

		return query.getResultList();
	}

	public List<Video> findByKeyWord(List<String> keys) {

		List<Video> result = new ArrayList<>();

		for (String key : keys) {
			List<Video> videos = findByKeyWord(key);
			result.addAll(videos);
		}

		return result.stream().distinct().toList();
	}

	public List<Video> getTrendingVideo() {
		List<Video> videos = null;
		EntityManager em = JpaUtils.getEntityManager();

		String jpql = "SELECT v.video FROM View v WHERE v.time >= :time";

		TypedQuery<Video> query = em.createQuery(jpql, Video.class);

		query.setParameter("time", DateHelper.getDate(-7));

		List<Video> result = query.getResultList();

		Map<Video, Integer> map = new HashMap<>();

		for (Video video : result) {
			map.put(video, map.getOrDefault(video, 0) + 1);
		}

		videos = new ArrayList<Video>(map.keySet());

		Collections.sort(videos, (v2, v1) -> map.get(v1) - map.get(v2));

		return videos;
	}

	public long getVideoCountAgo(int date) {

		EntityManager em = JpaUtils.getEntityManager();

		String jpql = "SELECT v FROM Video v WHERE v.datePost BETWEEN :pass AND :now";
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);

		query.setParameter("now", DateHelper.now());
		query.setParameter("pass", DateHelper.getDate(date));

		return query.getResultList().size();

	}
}
