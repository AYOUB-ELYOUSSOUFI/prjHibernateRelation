package com.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.IDao;
import com.hibernate.HibernateUtil;
import com.models.Moniteur;
import com.models.Voiture;

public class VoitureService implements IDao<Voiture>{
	public static Logger logger = Logger.getLogger(MoniteurService.class);
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction t = session.beginTransaction();
	
	@Override
	public void addOne(Voiture obj) {
		try {
			session.save(obj);
			t.commit();
			session.close();
			logger.info("La voiture est ajoute avec succe");
		} catch (Exception ex) {
			t.rollback();
			logger.info("La voiture n'a pas etait ajoute");
		}
		
	}

	@Override
	public void updateOne(Voiture obj) {
		try {
			session.update(obj);
			t.commit();
			session.close();
			logger.info("La voiture est modifier avec succe");
		} catch (Exception ex) {
			t.rollback();
			logger.info("La voiture n'a pas etait modifie");
		}
		
	}

	@Override
	public List<Voiture> getAll() {
		try {

			List<Voiture> voitures = session.createQuery("from Eleve").list();
			t.commit();
			session.close();
			logger.info("La liste des voitures est recupere avec succe");
			return voitures;
		} catch (Exception ex) {
			t.rollback();
			logger.info("La liste des voitures n'a pas etait recupere");
			return null;
		}
	}

	@Override
	public Voiture getOneById(int id) {
		try {
			Voiture voiture = session.load(Voiture.class, Integer.valueOf(id));
			t.commit();
			session.close();
			logger.info("La voiture est recupere avec succe");
			return voiture;
		} catch (Exception ex) {
			t.rollback();
			logger.info("La voiture n'a pas etait recupere");
			return null;
		}
	}

	@Override
	public void deleteOne(int id) {
		try {
			Voiture voiture = session.load(Voiture.class, Integer.valueOf(id));
			if (voiture != null) {
				session.remove(voiture);
			}
			t.commit();
			session.close();
			logger.info("La voiture est supprimer avec succe");
		} catch (Exception ex) {
			t.rollback();
			logger.info("La voiture n'a pas etait supprime");
		}
		
	}

}
