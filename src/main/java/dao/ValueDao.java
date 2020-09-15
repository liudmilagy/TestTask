package dao;

import models.Value;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

public class ValueDao {

    public void save(Value value) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(value);
        tx1.commit();
        session.close();
    }
}
