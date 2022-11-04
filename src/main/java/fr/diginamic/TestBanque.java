package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Classe de lancement de l'application
 * @author cmich
 *
 */
public class TestBanque {

	public static void main(String[] args) {
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("banque");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction trans = eM.getTransaction();
		
		
	}

}
