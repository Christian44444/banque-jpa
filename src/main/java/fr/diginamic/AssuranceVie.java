package fr.diginamic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ASSURANCE_VIE")
public class AssuranceVie extends Compte{
	
	@Column(name = "DATE_FIN", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	@Column(name = "TAUX", nullable = false) 
	private Double taux;

	/**
	 * Constructeur sans paramètre
	 */
	public AssuranceVie() {
		super();
	}

	@Override
	public String toString() {
		return " Type: livretA taux=" + taux;
	}

	/**
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
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
