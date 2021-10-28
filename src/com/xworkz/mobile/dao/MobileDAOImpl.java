package com.xworkz.mobile.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.xworkz.mobile.entity.MobileEntity;

public class MobileDAOImpl implements MobileDAO {

	@Override
	public void saveMobileEntity() {
		System.out.println("Invoked saveMobileEntity()");
		org.hibernate.Transaction transaction = null;
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			configuration.addAnnotatedClass(MobileEntity.class);

			sessionFactory = configuration.buildSessionFactory();

			session = sessionFactory.openSession();
			MobileEntity mobileEntity = new MobileEntity(13, "Nokia", 25000.0, "500GB", "cream", 20, true, "Andriod");

			transaction = session.beginTransaction();

			session.save(mobileEntity);

			transaction.commit();

			System.out.println("Done");

		} catch (HibernateException e) {
			System.out.println("inside catch block !!!!!");
			transaction.rollback();
			System.out.println("transaction rolled back");

		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
			if (sessionFactory != null) {
				sessionFactory.close();
				System.out.println("sessionFactory is closed");
			} else {
				System.out.println("sessionFactory is not closed");
			}
		}

	}

	@Override
	public void getMobileEntity() {
		System.out.println("Invoked getMobileEntity()");
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			configuration.addAnnotatedClass(MobileEntity.class);

			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();

			MobileEntity mobileEntity = session.get(MobileEntity.class, 1);

			System.out.println("Read is Done " + mobileEntity);

		} catch (HibernateException e) {
			System.out.println("inside catch block !!!!!");

		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
			if (sessionFactory != null) {
				sessionFactory.close();
				System.out.println("sessionFactory is closed");
			} else {
				System.out.println("sessionFactory is not closed");
			}
		}
	}

}
