package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entity.Subscription;
import entity.Video;
import exception.DaoException;
import interfaces.CURDable;
import utils.JpaUtils;

public class SubscriptionDao implements CURDable<Subscription> {

	@Override
	public void insert(Subscription e) throws DaoException {

		EntityManager entityManager = JpaUtils.getEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {

			entityTransaction.begin();

			entityManager.persist(e);

			entityTransaction.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			entityTransaction.rollback();
			throw new DaoException("Tạo lượt đăng ký thất bại");
		} finally {
			entityManager.close();
		}

	}

	@Override
	public void update(Subscription e) throws DaoException {

		EntityManager entityManager = JpaUtils.getEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {

			entityTransaction.begin();

			entityManager.merge(e);

			entityTransaction.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			entityTransaction.rollback();
			throw new DaoException("Cập nhật lượt đăng ký thất bại");
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Subscription delete(long id) throws DaoException, EntityNotFoundException {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		Subscription subscription = null;
		try {

			tran.begin();

			subscription = em.find(Subscription.class, id);

			if (subscription != null) {
				em.remove(subscription);
			} else {
				throw new EntityNotFoundException("No videos found with id = " + id);
			}

			tran.commit();

		} catch (Exception e2) {
			tran.rollback();
			e2.printStackTrace();
			throw new DaoException("Xoá lượt đăng ký không thành công");
		} finally {
			em.close();
		}
		return subscription;
	}

	@Override
	public Subscription findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subscription> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param sub
	 * @return true nếu đăng ký, false nếu huỷ đăng ký
	 * @throws DaoException lỗi truy vấn
	 */
	public boolean toggleSubscribe(Subscription sub) throws DaoException {

		try {

			insert(sub);
			return true;

		} catch (DaoException e) {
			EntityManager em = JpaUtils.getEntityManager();

			String jpql = "SELECT s FROM Subscription s WHERE "
					+ "s.channel.id = :channel AND s.subscriber.id = :subscriber";

			TypedQuery<Subscription> query = em.createQuery(jpql, Subscription.class);

			query.setParameter("channel", sub.getChannel().getId());
			query.setParameter("subscriber", sub.getSubscriber().getId());

			
			
			if (!query.getResultList().isEmpty()) {
				delete(query.getSingleResult().getId());
				System.out.println("Đã huỷ đăng ký");
				return false;
			} else {
				throw e;
			}

		}

	}

}
