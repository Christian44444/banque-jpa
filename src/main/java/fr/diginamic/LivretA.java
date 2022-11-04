package fr.diginamic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRET_A")
public class LivretA extends Compte{
	@Column(name = "TAUX", nullable = false) 
	private Double taux;

	/**
	 * Constructeur sans paramètre
	 */
	public LivretA() {
		super();
	}

	@Override
	public String toString() {
		return " Type: livretA taux=" + taux;
	}

	/**
	 * @return the taux
	 */
	public Double getTaux() {
		return taux;
	}

	/**
	 * @param taux the taux to set
	 */
	public void setTaux(Double taux) {
		this.taux = taux;
	}
	
}
