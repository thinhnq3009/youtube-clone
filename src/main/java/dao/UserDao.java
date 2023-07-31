package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.mindrot.jbcrypt.BCrypt;

import entity.User;
import entity.Video;
import exception.DaoException;
import handler.DateHelper;
import interfaces.CURDable;
import utils.JpaUtils;

public class UserDao implements CURDable<User> {

	@Override
	public void insert(User user) throws DaoException {

//		Thực hiện encrypt password trước khi thêm vào database
		user.hashPassword();

		EntityManager entityManager = JpaUtils.getEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {

			entityTransaction.begin();

			entityManager.persist(user);

			entityTransaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
			throw new DaoException("Tài khoảng này đã được sử dụng");
		} finally {
			entityManager.close();
		}

	}

	@Override
	public void update(User user) throws DaoException {
		EntityManager entityManager = JpaUtils.getEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();

			entityManager.merge(user);

			entityTransaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
			throw new DaoException("Cập nhật user không thành công");
		} finally {
			entityManager.close();
		}

	}

	@Override
	public User delete(long id) throws DaoException {

		EntityManager entityManager = JpaUtils.getEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		User user;

		try {
			entityTransaction.begin();

			user = entityManager.find(User.class, id);

			if (user != null) {
				entityManager.remove(user);
			} else {
				throw new EntityNotFoundException("No users found with id = " + id);
			}

			entityTransaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
			throw new DaoException("Error delete user.");
		} finally {
			entityManager.close();
		}

		return user;
	}

	@Override
	public User findById(long id) {
		EntityManager em = JpaUtils.getEntityManager();

		return em.find(User.class, id);
	}

	@Override
	public List<User> getAll() {

		EntityManager em = JpaUtils.getEntityManager();

		String jpql = "SELECT u FROM User u";

		TypedQuery<User> query = em.createQuery(jpql, User.class);

		return query.getResultList();
	}

	public User checkLogin(String username, String password) throws DaoException {
		EntityManager em = JpaUtils.getEntityManager();

		String jpql = "SELECT u FROM User u WHERE u.username = :username";

		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("username", username);
		try {

			// NoResultException
			User user = query.getSingleResult();

			String passwordHashed = user.getPassword();

			if (BCrypt.checkpw(password, passwordHashed)) {

				if (user.getIsActive()) {
					return user;
				} else {
					throw new DaoException("This account been blocked by admin!");
				}

			} else {
				throw new DaoException("Pasword is incorrect");
			}

		} catch (NoResultException e) {
			throw new DaoException("Username is incorrect");
		}
	}

	public User findByUsername(String username) {

		if (username == null)
			return null;

		EntityManager em = JpaUtils.getEntityManager();

		String jpql = "SELECT u FROM User u WHERE u.username = :username";

		TypedQuery<User> query = em.createQuery(jpql, User.class);

		query.setParameter("username", username);

		return query.getResultList().isEmpty() ? null : query.getSingleResult();

	}

	public User findByAcceptToken(String token) {

		if (token == null)
			return null;

		EntityManager em = JpaUtils.getEntityManager();

		String jpql = "SELECT u FROM User u WHERE u.acceptToken = :token";

		TypedQuery<User> query = em.createQuery(jpql, User.class);

		query.setParameter("token", token);

		return query.getResultList().isEmpty() ? null : query.getSingleResult();

	}

	public User findByResetPasswordToken(String token) {

		if (token == null)
			return null;

		EntityManager em = JpaUtils.getEntityManager();

		String jpql = "SELECT u FROM User u WHERE u.resetPasswordToken = :token";

		TypedQuery<User> query = em.createQuery(jpql, User.class);

		query.setParameter("token", token);

		return query.getResultList().isEmpty() ? null : query.getSingleResult();
	}

	public User findByChannelId(String id) {

		if (id == null)
			return null;

		EntityManager em = JpaUtils.getEntityManager();

		String jpql = "SELECT u FROM User u WHERE u.channelId = :id";

		TypedQuery<User> query = em.createQuery(jpql, User.class);

		query.setParameter("id", id);

		return query.getResultList().isEmpty() ? null : query.getSingleResult();
	}

	public long getUserCountAgo(int date) {

		EntityManager em = JpaUtils.getEntityManager();

		String jpql = "SELECT u FROM User u WHERE u.dateJoin BETWEEN :pass AND :now";
		TypedQuery<User> query = em.createQuery(jpql, User.class);

		query.setParameter("now", DateHelper.now());
		query.setParameter("pass", DateHelper.getDate(date));

		return query.getResultList().size();

	}
}
