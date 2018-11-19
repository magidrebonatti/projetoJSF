package br.com.projetojsf.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface InterfaceDAO<T> {

	void salvar(T entidade);
	void atualizar(T entidade);
	void excluir(T entidae);
	void merge(T entidade);
	T getEntidade(Serializable id);
	T getEntidadePorCriterio(DetachedCriteria criteria);
	List<T> getEntidades();
	List<T> getListaEntidadePorCriterio(DetachedCriteria criteria);	
	
}
