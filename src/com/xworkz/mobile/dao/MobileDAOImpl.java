package com.xworkz.mobile.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.singlesessionfactory.*; 

public class MobileDAOImpl implements MobileDAO {

	@Override
	public void saveMobileEntity() {
		System.out.println("Invoked saveMobileEntity()");
		org.hibernate.Transaction transaction = null;
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();

			MobileEntity mobileEntity = new MobileEntity(6, "Nokia", 25000.0, "500GB", "cream", 20, true, "Andriod");

			transaction = session.beginTransaction();

			session.save(mobileEntity);

			transaction.commit();

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
		}
	}

	@Override
	public void getMobileEntity() {
		System.out.println("Invoked getMobileEntity()");
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();

			MobileEntity mobileEntity = session.get(MobileEntity.class, 6);
			
			System.out.println("Read is Done " + mobileEntity);

			SessionFactoryProvider.closeSessionFactory();
			
		} catch (HibernateException e) {
			System.out.println("inside catch block !!!!!");

		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}

		}
	}

	@Override
	public void updateMobileEntity() {
		System.out.println("Invoked updateMobileEntity()");
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;

		try {

			sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(MobileEntity.class)
					.buildSessionFactory();

			session = sessionFactory.openSession();

			MobileEntity mobileEntity = session.get(MobileEntity.class, 5);
			System.out.println("Mobile Entity " + mobileEntity);

			mobileEntity.setMobileBrand("oppo2");
			mobileEntity.setMobileColor("white");
			mobileEntity.setFingerPrintSupport(false);
			mobileEntity.setMobilePrice(15000);

			session.update(mobileEntity);

			transaction = session.beginTransaction();
			transaction.commit();

			System.out.println("update the row ");

		} catch (HibernateException e) {
			System.out.println("inside catch block !!!!!");
			transaction.rollback();
			System.out.println("Transaction is roll back");

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
	public void deletMobileEntity() {
		System.out.println("Invoked deletMobileEntity()");
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;

		try {
			// step-1 bootstap the framework(configure in xml file code)
			Configuration configuration = new Configuration();

			// step-2 to load the hibernate.cfg.xml and parse the hibernate.cfg.xml
			configuration.configure("hibernate.cfg.xml");

			// step-3 read the metadata from annotation(mapping to db)
			configuration.addAnnotatedClass(MobileEntity.class);

			// step-4 to create sessionfactory(its checking configure,mapping)
			sessionFactory = configuration.buildSessionFactory();

			// step-5 sessionfactrory create session, this session is java object and it
			// perform the db operation
			session = sessionFactory.openSession();

			MobileEntity mobileEntity = session.get(MobileEntity.class, 6);
			System.out.println("Mobile Entity " + mobileEntity);

			session.delete(mobileEntity);

			transaction = session.beginTransaction();
			transaction.commit();

			System.out.println("Delete one row ");

		} catch (HibernateException e) {
			System.out.println("inside catch block !!!!!");
			transaction.rollback();
			System.out.println("Transaction is roll back");

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
