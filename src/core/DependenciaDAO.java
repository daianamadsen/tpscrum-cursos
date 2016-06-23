package core;

import java.util.List;

import org.hibernate.HibernateException;

import entidades.Dependencia;

public class DependenciaDAO extends GenericDAO{
	
	//create
	public int create(Dependencia dependencia){
		 int id = -1;
	     try {
	    	 beginTransaction();
	         id = (int)sesion.save(dependencia);
	         tx.commit();
	         endTransaction();
	     } catch(HibernateException he) {
	         rollbackTransaction(he);
	         throw he;
	     }
	     return id;
	}
	
	//read
	public Dependencia read(int id) {
        Dependencia dependencia = null;
        try { 
            beginTransaction();
            dependencia = (Dependencia)sesion.get(Dependencia.class, id);
            endTransaction();
        } catch(HibernateException he) {
            throw he;
        }
        System.out.println("tema : " + dependencia.getTema().getId() + " correlativo: " + dependencia.getCorrelativo().getId());
        return dependencia; 
    }
	
	//Read
    public List<Dependencia> read() { 
        List<Dependencia> dependencias = null;
        try {
            beginTransaction();
            dependencias = sesion.createQuery("from Dependencia").list(); 
            endTransaction();
        } catch(HibernateException he) {
            throw he;
        }
        for (Dependencia d: dependencias){
        	System.out.println("tema : " + d.getTema().getId() + " correlativo: " + d.getCorrelativo().getId());
        }
        return dependencias; 
    }
    
  //Update
    public void update(Dependencia dependencia) {
        try {
            beginTransaction();
            sesion.update(dependencia);
            tx.commit();
            endTransaction();
        } catch(HibernateException he) {
            rollbackTransaction(he);
            throw he;
        }
    }
    
    //Delete
    public void delete(Dependencia dependencia) {
        try {
            beginTransaction();
            sesion.delete(dependencia);
            tx.commit();
            endTransaction();
        } catch(HibernateException he) {
            rollbackTransaction(he);
            throw he;
        }
    }
    
	
	
	
	
}


