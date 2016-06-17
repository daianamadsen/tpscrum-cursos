package core;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

class GenericDAO {
    
    protected Session sesion;
    protected Transaction tx;
    
    protected void beginTransaction() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }
    
    protected void endTransaction() {
        sesion.close();
    }
    
    protected void rollbackTransaction(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }
    
}