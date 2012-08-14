package br.unesp.ibb.lbbc.persistence;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import br.unesp.ibb.lbbc.model.NewProject;

public class Entidade {

	protected BasicService bs;

	public Entidade() {
		try {
			bs = BasicService.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected EntityTransaction getTransaction() {
		return bs.getEntityManager().getTransaction();
	}

	@SuppressWarnings("unchecked")
	public List findAll(Class objectClass) {
		try {

			Query query = bs.getEntityManager().createQuery(
					"select u from " + objectClass.getName() + " u");

			return query.getResultList();

		} finally {
			bs.getEntityManager().close();
		}
	}

	
	/**
	 * Search by Project Name
	 * @param name
	 * @return
	 */
	public Object findProjectByName(String name) {
		try {
			return bs.getEntityManager().createNamedQuery("findProjectByName")
					.setParameter("nameProject",name).getSingleResult();
		} finally {
			bs.getEntityManager().close();
		}

	}
	
	
	/**
	 * Search by Gene name
	 * @param name
	 * @return
	 */

	public Object findGeneByName(String name) {
		try {
			return bs.getEntityManager().createNamedQuery("findGeneByName")
					.setParameter("nameGene",name).getSingleResult();
		} finally {
			bs.getEntityManager().close();
		}

	}
	
	public Object findGeneBySynonym(String name) {
		try {
			return bs.getEntityManager().createNamedQuery("findGeneBySynonym")
					.setParameter("synonymGene",name).getSingleResult();
		} finally {
			bs.getEntityManager().close();
		}

	}
	
	// BUSCA POR PESSOA
	public Object findPessoaByNome(String name) {
		try {
			return bs.getEntityManager().createNamedQuery("FindPessoaByName")
					.setParameter("nomePessoa", name).getSingleResult();
		} finally {
			bs.getEntityManager().close();
		}

	}

	// BUSCA POR IMOVEL
	public Object findImovelByNome(String name) {
		return null;
	}

	public <T> T inserirObjeto(T obj) {
		try {
			getTransaction().begin();
			bs.getEntityManager().persist(obj);
			//JOptionPane.showMessageDialog(null, "1-transaction active is "+getTransaction().isActive());
			getTransaction().commit();
			//JOptionPane.showMessageDialog(null, "2-transaction active is "+getTransaction().isActive());
			
			return obj;
		} catch (Exception e) {
			getTransaction().rollback();
			return null;
		}

	}

	// BUSCA PESSOA POR LETRAS SEMELHANTES
	public List findPessoaByFirstLetter(String name) {
		try {

			Query query = bs.getEntityManager().createNamedQuery("FindPessoaByFirstLetter");
			query.setParameter("nomePessoa", "%"+name+"%");
			return query.getResultList();

		} finally {
			bs.getEntityManager().close();
		}

	}

	@SuppressWarnings("unchecked")
	public void removeObject(Class classePersistente, Object chave) {
		getTransaction().begin();
		Object ps = bs.getEntityManager().find(classePersistente, chave);
		bs.getEntityManager().remove(ps);
		getTransaction().commit();

	}

	public void update(Object obj) throws Exception {

		try {
			getTransaction().begin();
			bs.getEntityManager().merge(obj);
			getTransaction().commit();
		} catch (Exception e) {
			getTransaction().rollback();
			throw e;
		}

	}

	public void close() {
		bs.getEntityManager().close();
	}
}
