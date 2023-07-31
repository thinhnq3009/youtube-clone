package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entity.Comment;
import exception.DaoException;
import interfaces.CURDable;
import utils.JpaUtils;

public class CommentDao implements CURDable<Comment> {

	@Override
	public void insert(Comment e) throws DaoException {
		EntityManager em = JpaUtils.getEntityManager();

		EntityTransaction tran = em.getTransaction();

		try {

			tran.begin();

			em.persist(e);

			tran.commit();

		} catch (Exception ex) {
			tran.rollback();

			ex.printStackTrace();

			throw new DaoException("Lỗi tạo comment mới");
		} finally {
			em.close();
		}

	}

	@Override
	public void update(Comment e) throws DaoException {
		EntityManager em = JpaUtils.getEntityManager();

		EntityTransaction tran = em.getTransaction();

		try {

			tran.begin();

			em.merge(e);

			tran.commit();

		} catch (Exception ex) {
			tran.rollback();

			ex.printStackTrace();

			throw new DaoException("Lỗi cập nhật comment ");
		} finally {
			em.close();
		}

	}

	@Override
	public Comment delete(long id) throws DaoException, EntityNotFoundException {
		EntityManager em = JpaUtils.getEntityManager();

		EntityTransaction tran = em.getTransaction();

		Comment comment = null;

		try {

			tran.begin();

			comment = em.find(Comment.class, id);

			if (comment == null) {
				throw new EntityNotFoundException("Không tìm thấy comment cần xoá");
			} else {
				em.remove(comment);
				tran.commit();
			}

		} catch (Exception ex) {
			tran.rollback();

			ex.printStackTrace();

			throw new DaoException("Không thể xoá comment");
		} finally {
			em.close();
		}

		return comment;
	}

	@Override
	public Comment findById(long id) {
		EntityManager em = JpaUtils.getEntityManager();
		return em.find(Comment.class, id);
	}

	@Override
	public List<Comment> getAll() {
		EntityManager em = JpaUtils.getEntityManager();

		String jpql = "SELECT c FROM Comment c";

		TypedQuery<Comment> query = em.createQuery(jpql, Comment.class);

		return query.getResultList();
	}

}
