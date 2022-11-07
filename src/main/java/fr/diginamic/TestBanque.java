package fr.diginamic;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jvnet.staxex.util.DummyLocation;

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
		
		trans.begin();
		// 1 compte associé à 2 client
		// Adresse et banque puis 1er client
		Adresse adr1 = new Adresse();
		adr1.setNumero(11);
		adr1.setRue("rue du Daguenet");
		adr1.setCodePostal(49100);
		adr1.setVille("Angers");
		// eM.persist(adr1); ne pas persister l'adresse car il n'y a qu'une table
		
		Banque ban1 = new Banque();
		ban1.setNom("Crédit Mutuel");
		eM.persist(ban1);
		
		Client cli1 = new Client();
		cli1.setNom("MICHAUD");
		cli1.setPrenom("Christian");
		cli1.setDateNaissance(new Date(70,06,20));
		cli1.setAdresse(adr1);
		cli1.setBanque(ban1);
		eM.persist(cli1);
		
		// 2ième client
//		Adresse adr1 = new Adresse();
//		adr1.setNumero(11);
//		adr1.setRue("rue du Daguenet");
//		adr1.setCodePostal(49100);
//		adr1.setVille("Angers");
		// eM.persist(adr1); ne pas persister l'adresse car il n'y a qu'une table
		
//		Banque ban1 = new Banque();
//		ban1.setNom("Crédit Mutuel");
//		eM.persist(ban1);
		
		Client cli2 = new Client();
		cli2.setNom("MICHAUD");
		cli2.setPrenom("Emmanuelle");
		cli2.setDateNaissance(new Date(70,11,25));
		cli2.setAdresse(adr1);
		cli2.setBanque(ban1);
		eM.persist(cli2);
		
		// Inserrer le compte associé à ces 2 clients
		Compte cpt1 = new Compte();
		cpt1.setNumCpt("FR76 0000 0000 0000 001");
		cpt1.setSolde(10000.01);
		eM.persist(cpt1);
		cli1.getComptes().add(cpt1);
		cli2.getComptes().add(cpt1);
		
		trans.commit();
		
		// Inserrer un client avec plusieurs comptes
		trans.begin();
		// Adresse et banque puis 1er client
		Adresse adr2 = new Adresse();
		adr2.setNumero(28);
		adr2.setRue("rue des eucalyptus");
		adr2.setCodePostal(44300);
		adr2.setVille("Nantes");
		// eM.persist(adr1); ne pas persister l'adresse car il n'y a qu'une table
		
		Banque ban2 = new Banque();
		ban2.setNom("LA POSTE");
		eM.persist(ban2);
		
		Client cli3 = new Client();
		cli3.setNom("MICHAUD");
		cli3.setPrenom("Lucas");
		cli3.setDateNaissance(new Date(97,03,29));
		cli3.setAdresse(adr2);
		cli3.setBanque(ban2);
		eM.persist(cli3);
		
		LivretA cpt2 = new LivretA();
		cpt2.setNumCpt("FR76 0000 0000 0000 002");
		cpt2.setSolde(100000.54);
		cpt2.setTaux(5.4);
		eM.persist(cpt2);
		cli3.getComptes().add(cpt2);
		
		AssuranceVie cpt3 = new AssuranceVie();
		cpt3.setNumCpt("FR76 0000 0000 0000 003");
		cpt3.setSolde(100000.45);
		cpt3.setTaux(4.5);
		eM.persist(cpt3);
		cli3.getComptes().add(cpt3);
		
		trans.commit();
		
		// Inserrer des opérations de type virement sur un compte
		trans.begin();
		
		Virement ope1 = new Virement();
		ope1.setDate(new Date(122,10,7));
		ope1.setCompte(cpt1);
		ope1.setMontant(-100.0);
		ope1.setMotif("Aide au loyer");
		ope1.setBeneficiaire("MICHAUD Victor");
		cpt1.setSolde(cpt1.getSolde() + ope1.getMontant());
		eM.persist(ope1);
		Virement ope2 = new Virement();
		ope2.setDate(new Date(122,10,7));
		ope2.setCompte(cpt1);
		ope2.setMontant(-200.0);
		ope2.setMotif("Courses de la semaine");
		ope2.setBeneficiaire("Carrefour");
		cpt1.setSolde(cpt1.getSolde() + ope2.getMontant());
		eM.persist(ope2);
		
		// Inserrer des opérations de type opération sur un compte
		Operation ope3 = new Operation();
		ope3.setDate(new Date(122,10,6));
		ope3.setCompte(cpt2);
		ope3.setMontant(300.0);
		ope3.setMotif("Approvisionnement Livret A");
		cpt2.setSolde(cpt2.getSolde() + ope3.getMontant());
		eM.persist(ope3);
		
		Operation ope4 = new Operation();
		ope4.setDate(new Date(122,10,5));
		ope4.setCompte(cpt3);
		ope4.setMontant(400.0);
		ope4.setMotif("Approvisionnement Assurance vie");
		cpt3.setSolde(cpt3.getSolde() + ope4.getMontant());
		eM.persist(ope4);
		
		trans.commit();
	}

}
