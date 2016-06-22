package core;

import entidades.Tema;
import java.util.List;
import org.hibernate.HibernateException;

public class TemaDAO extends GenericDAO {
    
    //Create
    public int create(Tema tema) {
        int id = -1;
        try {
            beginTransaction();
            id = (int)sesion.save(tema);
            tx.commit();
            endTransaction();
        } catch(HibernateException he) {
            rollbackTransaction(he);
            throw he;
        }
        return id;
    }
    
    //Read
    public Tema read(int id) {
        Tema tema = null;
        try { 
            beginTransaction();
            tema = (Tema)sesion.get(Tema.class, id);
            endTransaction();
        } catch(HibernateException he) {
            throw he;
        }
        return tema; 
    }
    
    //Read
    public List<Tema> read() { 
        List<Tema> temas = null;
        try {
            beginTransaction();
            temas = sesion.createQuery("from Tema").list(); 
            endTransaction();
        } catch(HibernateException he) {
            throw he;
        }
        return temas; 
    }
    
    //Update
    public void update(Tema tema) {
        try {
            beginTransaction();
            sesion.update(tema);
            tx.commit();
            endTransaction();
        } catch(HibernateException he) {
            rollbackTransaction(he);
            throw he;
        }
    }
    
    //Delete
    public void delete(Tema tema) {
        try {
            beginTransaction();
            sesion.delete(tema);
            tx.commit();
            endTransaction();
        } catch(HibernateException he) {
            rollbackTransaction(he);
            throw he;
        }
    }
    
}