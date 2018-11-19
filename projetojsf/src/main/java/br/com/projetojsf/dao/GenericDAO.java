package br.com.projetojsf.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

public class GenericDAO<T> implements InterfaceDAO<T>, Serializable {

	private static final long SERIAL_VERSION = 1L;
	private Class<T> classe;
	private Session session;
	
	
	public GenericDAO(Class<T> classe, Session session) {
		super();
		this.classe = classe;
		this.session = session;
	}
	

	@Override
	public void salvar(T entidade) {
		session.save(entidade);
		
	}

	@Override
	public void atualizar(T entidade) {
		session.update(entidade);
		
	}

	@Override
	public void excluir(T entidae) {
		session.delete(entidae);
		
	}

	@Override
	public void merge(T entidade) {
		session.merge(entidade);
		
	}

	@Override
	public T getEntidade(Serializable id) {
		T entidade = (T)session.get(classe, id);
		return entidade;
	}

	@Override
	public T getEntidadePorCriterio(DetachedCriteria criteria) {
		T entidade =  (T)criteria.getExecutableCriteria(session);
		return entidade;
	}

	@Override
	public List<T> getEntidades() {
		List<T> entidades = (List<T>) session.createCriteria(classe).list();
		return entidades;
	}

	@Override
	public List<T> getListaEntidadePorCriterio(DetachedCriteria criteria) {
		return criteria.getExecutableCriteria(session).list();
	}

}
