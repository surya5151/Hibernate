package com.xworkz.mobile.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.Query;
import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.singlesessionfactory.*;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.*;

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

			MobileEntity mobileEntity = new MobileEntity("Sony2", 25000.0, "500GB", "cream", 20, true, "Andriod");

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

			MobileEntity mobileEntity = session.get(MobileEntity.class, 11);

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

	@Override
	public void getAllMobileEntites() {
		System.out.println("Invoked getAllMobileEntites()");
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();

			String hqlQuery = "from MobileEntity";
			org.hibernate.query.Query query = session.createQuery(hqlQuery);
			List listOfMobileEntity = query.list();
			System.out.println(listOfMobileEntity);

		} catch (HibernateException e) {
			System.out.println("inside catch block....");
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}

	}

	@Override
	public void getMobileBrandById() {
		System.out.println("Invoked getMobileBrandById()");
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();

			String hqlQuery = "select mobileBrand from MobileEntity where mobileID=1";

			org.hibernate.query.Query query = session.createQuery(hqlQuery);

			List listOfMobileEntity = query.list();

			System.out.println(listOfMobileEntity);

		} catch (HibernateException e) {
			System.out.println("inside catch block....");
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}

	}

	@Override
	public void getMobileColorByID() {
		System.out.println("Invoked getMobileColorByID()");
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();

			String hqlQuery = "select mobile.mobileColor from MobileEntity as mobile where mobileID=1";

			org.hibernate.query.Query query = session.createQuery(hqlQuery);

			Object object = query.uniqueResult();
			System.out.println("without casting: " + object);

			String mobileBrand = (String) object;
			System.out.println("with casting: " + mobileBrand);

		} catch (HibernateException e) {
			System.out.println("inside catch block....");
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}

	}

	@Override
	public void getMobileEntityByID() {
		System.out.println("Invoked getMobileEntityByID()");
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();

			String hqlQuery = " from MobileEntity where mobileID=1";

			org.hibernate.query.Query query = session.createQuery(hqlQuery);

			Object object = query.uniqueResult();
			System.out.println("without casting: " + object);

			MobileEntity mobileBrand = (MobileEntity) object;
			System.out.println("with casting: " + mobileBrand);

		} catch (HibernateException e) {
			System.out.println("inside catch block....");
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}

	}

	@Override
	public void updateMobilePriceByID() {
		System.out.println("Invoked updateMobilePriceByID()");
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			String hqlQuery = "update MobileEntity set mobilePrice='37000'  where mobileID=1";

			org.hibernate.query.Query query = session.createQuery(hqlQuery);

			int noOfRowsAffected = query.executeUpdate();
			session.getTransaction().commit();
			System.out.println("noOfRowsAffected: " + noOfRowsAffected);

		} catch (HibernateException e) {
			System.out.println("inside catch block....");
			
			session.getTransaction().rollback();
			System.out.println("Transaction is rollBack");
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}

	}

	@Override
	public void deleteMobileEntityByID() {
		System.out.println("invoked deleteMobileEntityByID");
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			String hqlQuery = "delete from MobileEntity where mobileID=10";

			org.hibernate.query.Query query = session.createQuery(hqlQuery);

			int noOfRowsAffected = query.executeUpdate();
			session.getTransaction().commit();
			System.out.println("noOfRowsAffected: " + noOfRowsAffected);

		} catch (HibernateException e) {
			System.out.println("inside catch block....");
			
			session.getTransaction().rollback();
			System.out.println("Transaction is rollBack");
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		
	}

}
