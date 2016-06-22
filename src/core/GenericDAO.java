package core;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ui.Message;

class GenericDAO {
    
    protected Session sesion;
    protected Transaction tx;
    
    protected void beginTransaction() {
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            tx = sesion.beginTransaction();
        } catch (Exception e) {
            Message.showError("Error","Error de conexión a la base de datos");
            System.exit(0);
        }
    }
    
    protected void endTransaction() {
        sesion.close();
    }
    
    protected void rollbackTransaction(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }
    
}