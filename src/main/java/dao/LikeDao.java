package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import entity.Liked;
import entity.User;
import entity.Video;
import exception.DaoException;
import jakarta.mail.MethodNotSupportedException;
import utils.JpaUtils;

public class LikeDao extends AbstractDao<Liked> {

	@Override
	public void insert(Liked entity) throws DaoException {
		EntityManager em = JpaUtils.getEntityManager();

		EntityTransaction tran = em.getTransaction();

		try {

			tran.begin();

			em.persist(entity);

			tran.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
			throw new DaoException("Lỗi thêm mới LIKE");
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Liked entity) throws DaoException {
		EntityManager em = JpaUtils.getEntityManager();

		EntityTransaction tran = em.getTransaction();

		try {

			tran.begin();

			em.merge(entity);

			tran.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
			throw new DaoException("Lỗi update LIKE");
		} finally {
			em.close();
		}

	}

	@Override
	public Liked delete(long id) throws DaoException, EntityNotFoundException {
		EntityManager em = JpaUtils.getEntityManager();

		EntityTransaction tran = em.getTransaction();

		Liked like = null;

		try {

			tran.begin();

			like = em.find(Liked.class, id);

			if (like != null) {
				em.remove(like);
				tran.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
			throw new DaoException("Lỗi delete LIKE");
		} finally {
			em.close();
		}

		return like;
	}

	public Liked findLike(long userId, long videoId) {

		EntityManager em = JpaUtils.getEntityManager();

		String jpql = "SELECT l FROM Liked l WHERE l.user.id = :userId AND l.video.id = :videoId";

		TypedQuery<Liked> query = em.createQuery(jpql, Liked.class);

		query.setParameter("userId", userId);
		query.setParameter("videoId", videoId);

		return query.getResultList().isEmpty() ? null : query.getSingleResult();
	}

	/**
	 * 
	 * <p>
	 * Step 1: Thực hiện kiểm tra có like hay dislike video này chưa.
	 * <p>
	 * Step 2: Nếu đã từng like hay dislike thực hiện bước tiếp theo, ngược lại thực
	 * hiện insert
	 * <p>
	 * Step 3: Kiểm tra xem có trùng với isLike không. Nếu có thì thực hiện delete
	 * Like, ngược lại thì update
	 * <p>
	 * Step 4: Kết thúc
	 * 
	 * @param user    người thực hiện like
	 * @param videoId video được like
	 * @param isLike  <code>true</code> là thực hiện like. <code>false</code> là
	 *                dislike
	 * @return <code>null</code> Nếu dùng để gỡ like hoặc dislike. Trả về đối tượng
	 *         của <code>Like</code> nếu thực hiện like hoặc dislike
	 * @throws DaoException
	 */
	public Liked handelLike(User user, Video video, boolean isLike) throws DaoException {

		Liked like = findLike(user.getId(), video.getId());

		if (like == null) {
			like = new Liked(user, video);
			like.setIsLike(isLike);
			insert(like);
		} else {
			if (isLike == like.getIsLike()) {
				delete(like.getId());
				like = null;
			} else {
				like.setIsLike(isLike);
				update(like);
			}
		}

		return like;
	}

}
