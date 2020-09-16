package dao;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import models.Value;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.SQLUpdate;
import utils.HibernateSessionFactoryUtil;
import org.hibernate.query.Query;

import javax.ejb.ApplicationException;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Entity;
import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;

public class ValueDao {

    public void save(Value value) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(value);
        tx1.commit();
        session.close();
    }

    // Exception in thread "main" javax.persistence.TransactionRequiredException: Executing an update/delete query
    @Transactional
    public static void createTable() {
//         String queryText = "create table if not exists value (v float, id serial not null constraint value_pk primary key)";
        // создать, если не существует, и очистить от старых данных.
        String queryText = "create table if not exists value (v float, id serial not null constraint value_pk primary key); delete from value;";
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(queryText);
        query.executeUpdate();
        session.close();
    }


}
