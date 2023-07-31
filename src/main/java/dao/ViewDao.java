package dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

public class ViewDao implements CURDable<View> {

	@Override
	public void insert(View e) throws DaoException {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();

		try {

			tran.begin();

			em.persist(e);

			tran.commit();

		} catch (Exception e2) {
			tran.rollback();
			e2.printStackTrace();
			throw new DaoException("Error insert new view");
		} finally {
			em.close();
		}

	}

	@Override
	public void update(View e) throws DaoException {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();

		try {

			tran.begin();

			em.persist(e);

			tran.commit();

		} catch (Exception e2) {
			tran.rollback();
			e2.printStackTrace();
			throw new DaoException("Error update view");
		} finally {
			em.close();
		}

	}

	@Override
	public View delete(long id) throws DaoException, EntityNotFoundException {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		View view = null;
		try {

			tran.begin();

			view = em.find(View.class, id);

			if (view != null) {
				em.remove(view);
			} else {
				throw new EntityNotFoundException("No view found with id = " + id);
			}

			tran.commit();

		} catch (Exception e2) {
			tran.rollback();
			e2.printStackTrace();
			throw new DaoException("Error delete view");
		} finally {
			em.close();
		}
		return view;
	}

	@Override
	public View findById(long id) {
		EntityManager em = JpaUtils.getEntityManager();
		return em.find(View.class, id);
	}

	@Override
	public List<View> getAll() {
		EntityManager em = JpaUtils.getEntityManager();

		String jpql = "SELECT v FROM View v";

		TypedQuery<View> query = em.createQuery(jpql, View.class);

		return query.getResultList();
	}

	public void watch(Video video, User user) throws DaoException {

		View view = new View();
		view.setTime(new Timestamp(new Date().getTime()));
		view.setVideo(video);
		view.setUser(user);

		insert(view);

	}

	public long getViewCountAgo(int date) {

		Date now = DateHelper.now();
		Date pass = DateHelper.getDate(date);

		EntityManager em = JpaUtils.getEntityManager();

		String jpql = "SELECT v FROM View v WHERE v.time BETWEEN :pass AND :now";

		TypedQuery<View> query = em.createQuery(jpql, View.class);

		query.setParameter("now", now);
		query.setParameter("pass", pass);

		return query.getResultList().size();
	}

}
