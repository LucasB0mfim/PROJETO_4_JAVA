package br.com.lbomfim.dao.generic;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.lbomfim.exception.AtualizacaoException;
import br.com.lbomfim.exception.BuscaException;
import br.com.lbomfim.exception.CadastroException;
import br.com.lbomfim.exception.ConsultaException;
import br.com.lbomfim.exception.ExclusaoException;

/**
 * @author Lucas Bomfim
 * @param <T>
 */

public class GenericDAO<T, E> implements IGenericDAO<T, E> {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
	private EntityManager entityManager;
	private Class<T> persistenteClass;
	
	public GenericDAO(Class<T> persistenteClass) {
		this.persistenteClass = persistenteClass;
	}

	// MÉTODOS DA CLASSE
	private void abrir_conexao() {
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	}

	private void fechar_conexao() {
		if (entityManager != null && entityManager.isOpen()) {
			entityManager.getTransaction().commit();
			entityManager.close();
		}
	}

	private void capturar_erro_conexao() {
		if (entityManager != null && entityManager.getTransaction().isActive()) {
			entityManager.getTransaction().rollback();
		}
	}

	private String pegar_sql_selecionado() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT obj FROM ");
		sb.append(this.persistenteClass.getSimpleName());
		sb.append(" obj");
		return sb.toString();
	}

	// MÉTODOS DO IGenericDAO
	@Override
	public T cadastrar(T entity) throws CadastroException {
	    try {
	        abrir_conexao();
	        entityManager.persist(entity);
	    } catch (Exception e) {
	        capturar_erro_conexao();
	        throw new CadastroException("Erro ao cadastrar: " + e.getMessage());
	    } finally {
	        fechar_conexao();
	    }
	    return entity;
	}


	@Override
	public T atualizar(T entity) throws AtualizacaoException {
		try {
			abrir_conexao();
			entity = entityManager.merge(entity);
		} catch (Exception e) {
			capturar_erro_conexao();
			throw new AtualizacaoException("Erro ao atualizar: " + e.getMessage());
		} finally {
			fechar_conexao();
		}
		return entity;
	}

	@Override
	public Collection<T> buscarTodos() throws BuscaException {
		try {
			abrir_conexao();
			List<T> lista = entityManager.createQuery(pegar_sql_selecionado(), this.persistenteClass).getResultList();
			return lista;
		} catch (Exception e) {
			capturar_erro_conexao();
			throw new BuscaException("Erro ao buscar: " + e.getMessage());
		} finally {
			fechar_conexao();
		}
	}

	@Override
	public T excluir(T entity) throws ExclusaoException {
		try {
			abrir_conexao();
			entity = entityManager.merge(entity);
			entityManager.remove(entity);
		} catch (Exception e) {
			capturar_erro_conexao();
			throw new ExclusaoException("Erro ao excluir: " + e.getMessage());
		} finally {
			fechar_conexao();
		}
		return entity;
	}

	@Override
	public T consultar(E valor) throws ConsultaException {
		T entity = null;
		try {
			abrir_conexao();
			entity = entityManager.find(this.persistenteClass, valor);
		} catch (Exception e) {
			capturar_erro_conexao();
			throw new ConsultaException("Erro ao consultar: " + e.getMessage());
		} finally {
			fechar_conexao();
		}
		return entity;
	}
}