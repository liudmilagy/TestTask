package dao;

import models.Value;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import org.hibernate.query.Query;


public class ValueDao {

    public void save(Value value) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(value);
        tx1.commit();
        session.close();
    }

    public Value findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Value.class, id);
    }
    // Exception in thread "main" javax.persistence.TransactionRequiredException: Executing an update/delete query
//@org.springframework.transaction.annotation.Transactional
    public static void createTable() {
//         String queryText = "create table if not exists value (v float, id serial not null constraint value_pk primary key)";
        // создать, если не существует, и очистить от старых данных.
        String queryText = "create table if not exists value (v float, id serial not null constraint value_pk primary key); delete from value;";
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction txn = session.beginTransaction();
        Query query = session.createSQLQuery(queryText);
        query.executeUpdate();
        txn.commit();
        session.close();
    }


}
