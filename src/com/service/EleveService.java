package com.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.IDao;
import com.hibernate.HibernateUtil;
import com.models.Eleve;

public class EleveService implements IDao<Eleve> {
	public static Logger logger = Logger.getLogger(EleveService.class);
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction t = session.beginTransaction();

	@Override
	public void addOne(Eleve obj) {
		try {
			session.save(obj);
			t.commit();
			session.close();
			logger.info("L'eleve est ajoute avec succe");
		} catch (Exception ex) {
			t.rollback();
			logger.info("L'eleve n'a pas etait ajoute");
		}
	}

	@Override
	public void updateOne(Eleve obj) {
		try {

			session.update(obj);
			t.commit();
			session.close();
			logger.info("L'eleve est modifier avec succe");
		} catch (Exception ex) {
			t.rollback();
			logger.info("L'eleve n'a pas etait modifie");
		}
	}

	@Override
	public List<Eleve> getAll() {
		try {

			List<Eleve> eleves = session.createQuery("from Eleve").list();
			t.commit();
			session.close();
			logger.info("La liste des eleves est recupere avec succe");
			return eleves;
		} catch (Exception ex) {
			t.rollback();
			logger.info("La liste des eleves n'a pas etait recupere");
			return null;
		}
	}

	@Override
	public Eleve getOneById(int id) {
		try {
			Eleve eleve = session.load(Eleve.class, Integer.valueOf(id));
			t.commit();
			session.close();
			logger.info("L'eleve est recupere avec succe");
			return eleve;
		} catch (Exception ex) {
			t.rollback();
			logger.info("L'eleve n'a pas etait recupere");
			return null;
		}
	}

	@Override
	public void deleteOne(int id) {
		try {
			Eleve eleve = session.load(Eleve.class, Integer.valueOf(id));
			if (eleve != null) {
				session.remove(eleve);
			}
			t.commit();
			session.close();
			logger.info("L'eleve est supprimer avec succe");
		} catch (Exception ex) {
			t.rollback();
			logger.info("L'eleve n'a pas etait supprime");
		}
	}

}
