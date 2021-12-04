package com.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.IDao;
import com.hibernate.HibernateUtil;
import com.models.Lecon;
import com.models.Voiture;

public class LeconService implements IDao<Lecon>{
	public static Logger logger = Logger.getLogger(MoniteurService.class);
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction t = session.beginTransaction();
	
	@Override
	public void addOne(Lecon obj) {
		try {
			session.save(obj);
			t.commit();
			session.close();
			logger.info("Le lecon est ajoute avec succe");
		} catch (Exception ex) {
			t.rollback();
			logger.info("Le lecon n'a pas etait ajoute");
		}
	}

	@Override
	public void updateOne(Lecon obj) {
		try {
			session.update(obj);
			t.commit();
			session.close();
			logger.info("Le lecon est modifier avec succe");
		} catch (Exception ex) {
			t.rollback();
			logger.info("Le lecon n'a pas etait modifie");
		}
		
	}

	@Override
	public List<Lecon> getAll() {
		try {

			List<Lecon> lecons = session.createQuery("from Eleve").list();
			t.commit();
			session.close();
			logger.info("La liste des lecons est recupere avec succe");
			return lecons;
		} catch (Exception ex) {
			t.rollback();
			logger.info("La liste des lecons n'a pas etait recupere");
			return null;
		}
	}

	@Override
	public Lecon getOneById(int id) {
		try {
			Lecon lecon = session.load(Lecon.class, Integer.valueOf(id));
			t.commit();
			session.close();
			logger.info("Le lecon est recupere avec succe");
			return lecon;
		} catch (Exception ex) {
			t.rollback();
			logger.info("Le lecon n'a pas etait recupere");
			return null;
		}
	}

	@Override
	public void deleteOne(int id) {
		try {
			Lecon lecon = session.load(Lecon.class, Integer.valueOf(id));
			if (lecon != null) {
				session.remove(lecon);
			}
			t.commit();
			session.close();
			logger.info("Le lecon est supprimer avec succe");
		} catch (Exception ex) {
			t.rollback();
			logger.info("Le lecon n'a pas etait supprime");
		}
	}

}
