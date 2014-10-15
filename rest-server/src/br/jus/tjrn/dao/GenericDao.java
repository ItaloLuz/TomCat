package br.jus.tjrn.dao;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import br.jus.tjrn.util.PropertiesUtils;

public abstract class GenericDao<T> {
	
	protected DataSource dataSource = DataSource.GUIA_CARDAPIO;

	private HashMap<DataSource, EntityManagerFactory>  entityManagerFactorys = new HashMap<DataSource, EntityManagerFactory>();
	
    private HashMap<DataSource, EntityManager>  entityManagers = new HashMap<DataSource, EntityManager>();
    
    private HashMap<DataSource, Session>  sessions = new HashMap<DataSource, Session>();
    
	public EntityManager getEntityManager() {
		Map<String, String> persistenceMap = null;
		try {
			String pathProperties = dataSource.getPersistenceProperties();
			//persistenceMap = PropertiesUtils.getDados(pathProperties);			
		} catch (Exception e) {
			close();
			e.printStackTrace();
		}
		
		if (entityManagerFactorys.get(dataSource) == null) {
			entityManagerFactorys.put(
					dataSource, 
					Persistence.createEntityManagerFactory( 
				    		dataSource.getPersistenceUnit() //, persistenceMap 
				    	)
				);
	    }
		if (entityManagers.get(dataSource) == null) {
		    entityManagers.put(dataSource, entityManagerFactorys.get(dataSource).createEntityManager());
	    }
		if (sessions.get(dataSource) == null) {
			sessions.put(dataSource, entityManagers.get(dataSource).unwrap(org.hibernate.Session.class));
		}
	 
	    return entityManagers.get(dataSource);
	}

    public BigInteger getNextValue(String schema, String table) {
        String tabela = (schema != null ? schema + "." : "") + table;
        
        String sql = String.format("select nextval('%s')", tabela);
        
        SQLQuery query = getSession().createSQLQuery(sql);
        
        return (BigInteger) query.uniqueResult();
    }
    
    public BigInteger getNextValue(String table) {
        return getNextValue(null, table);
    }
	
	public Session getSession() {
		if( sessions.get(dataSource) == null ) {
			getEntityManager();
		}
		
		return sessions.get(dataSource);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public T findById(final Long id) {
        return getEntityManager().find( getTypeClasse() , id);
    }
 
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return getEntityManager().createQuery("FROM " + getTypeClasse().getName())
                .getResultList();
    }
 
    public void persist(T t) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(t);
            getEntityManager().getTransaction().commit();
        } catch (Exception ex) {
        	close();
            ex.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }
    }
 
    public void merge(T t) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(t);
            getEntityManager().getTransaction().commit();
        } catch (Exception ex) {
        	close();
            ex.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }
    }
 
//    public void remove(T t) {
//        try {
//            getEntityManager().getTransaction().begin();
//            t = getEntityManager().find(T.class, t.getId());
//            getEntityManager().remove(t);
//            getEntityManager().getTransaction().commit();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            getEntityManager().getTransaction().rollback();
//        }
//    }
// 
//    public void removeById(final Long id) {
//        try {
//            T t = getById(id);
//            remove(t);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
    
    public void close() {
    	if( entityManagers.get(dataSource).isOpen() )	entityManagers.get(dataSource).close();
    	if( entityManagerFactorys.get(dataSource).isOpen() )	entityManagerFactorys.get(dataSource).close();
    	if( sessions.get(dataSource).isOpen() )	sessions.get(dataSource).close();
    }
    
    public abstract Class<T> getTypeClasse();
	
}
