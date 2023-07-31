package dao;

import java.util.List;

import javax.el.MethodNotFoundException;
import javax.persistence.EntityNotFoundException;

import exception.DaoException;
import interfaces.CURDable;
import jakarta.mail.MethodNotSupportedException;

public abstract class AbstractDao<E> implements CURDable<E> {

	@Override
	public void insert(E entity) throws DaoException {
		throw new MethodNotFoundException();
	}

	@Override
	public void update(E entity) throws DaoException {
		throw new MethodNotFoundException();
	}

	@Override
	public E delete(long id) throws DaoException, EntityNotFoundException {
		throw new MethodNotFoundException();
	}

	@Override
	public E findById(long id) {
		throw new MethodNotFoundException();
	}

	@Override
	public List<E> getAll() {
		throw new MethodNotFoundException();
	}

}
