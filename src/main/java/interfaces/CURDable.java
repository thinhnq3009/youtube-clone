package interfaces;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import exception.DaoException;

public interface CURDable<E> {
	public void insert(E entity) throws DaoException;
	
	public void update(E entity) throws DaoException;
	
	public E delete(long id) throws DaoException, EntityNotFoundException; 
	
	public E findById(long id);
	
	public List<E> getAll();
	
}
