package fr.diginamic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe abstraite des opérations d'un compte
 * Classes filles : Virement, 
 * @author cmich
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "OPERATION")
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 11, nullable = false)
	private Integer id;
	
	@Column(name = "DATE", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name = "MONTANT", nullable = false)
	private Double montant;

	@Column(name = "MOTIF", length = (255), nullable = true)
	private String motif;
	
	@ManyToOne
	@JoinColumn(name = "ID_COMPTE")
	private Compte compte;

	/**
	 * Constructeur par défaut
	 */
	public Operation() {
		super();
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", date=" + date + ", montant=" + montant + ", motif=" + motif + "]";
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the montant
	 */
	public Double getMontant() {
		return montant;
	}

	/**
	 * @param montant the montant to set
	 */
	public void setMontant(Double montant) {
		this.montant = montant;
	}

	/**
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/**
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/**
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/**
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
	
}
