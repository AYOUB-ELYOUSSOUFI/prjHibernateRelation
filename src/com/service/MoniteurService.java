package com.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.IDao;
import com.hibernate.HibernateUtil;
import com.models.Eleve;
import com.models.Moniteur;

public class MoniteurService implements IDao<Moniteur>{
	public static Logger logger = Logger.getLogger(MoniteurService.class);
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction t = session.beginTransaction();
	
	@Override
	public void addOne(Moniteur obj) {
		try {
			session.save(obj);
			t.commit();
			session.close();
			logger.info("Le moniteur est ajoute avec succe");
		} catch (Exception ex) {
			t.rollback();
			logger.info("Le moniteur n'a pas etait ajoute");
		}
	}

	@Override
	public void updateOne(Moniteur obj) {
		try {
			session.update(obj);
			t.commit();
			session.close();
			logger.info("Le moniteur est modifier avec succe");
		} catch (Exception ex) {
			t.rollback();
			logger.info("Le moniteur n'a pas etait modifie");
		}
		
	}

	@Override
	public List<Moniteur> getAll() {
		try {

			List<Moniteur> moniteurs = session.createQuery("from Eleve").list();
			t.commit();
			session.close();
			logger.info("La liste des moniteurs est recupere avec succe");
			return moniteurs;
		} catch (Exception ex) {
			t.rollback();
			logger.info("La liste des moniteurs n'a pas etait recupere");
			return null;
		}
	}

	@Override
	public Moniteur getOneById(int id) {
		try {
			Moniteur moniteur = session.load(Moniteur.class, Integer.valueOf(id));
			t.commit();
			session.close();
			logger.info("Le moniteur est recupere avec succe");
			return moniteur;
		} catch (Exception ex) {
			t.rollback();
			logger.info("Le moniteur n'a pas etait recupere");
			return null;
		}
	}

	@Override
	public void deleteOne(int id) {
		try {
			Moniteur moniteur = session.load(Moniteur.class, Integer.valueOf(id));
			if (moniteur != null) {
				session.remove(moniteur);
			}
			t.commit();
			session.close();
			logger.info("Le moniteur est supprimer avec succe");
		} catch (Exception ex) {
			t.rollback();
			logger.info("Le moniteur n'a pas etait supprime");
		}
		
	}

}
