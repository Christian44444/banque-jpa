package fr.diginamic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Classe Compte abstraite: LivretA ou AssuranceVie 
 * 
 * @author cmich
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "COMPTE")
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 11, nullable = false)
	private Integer id;
	
	@Column(name = "NUMERO_COMPTE", length = 27, nullable = false)
	private String numCpt;
	
	@Column(name = "SOLDE", nullable = false)
	private Double solde;

	@ManyToMany
	@JoinTable(name = "COMPTE_CLIENT", 
	   joinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID" ),
	   inverseJoinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID"))
	private List<Client> clients = new ArrayList<Client>();
	
	@OneToMany(mappedBy = "compte")
	private List<Operation> operations = new ArrayList<Operation>();

	
	/**
	 * Constructeur par défaut
	 */
	public Compte() {
		super();
	}

	@Override
	public String toString() {
		return "Compte: numCpt=" + numCpt + ", solde=" + solde;
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
	 * @return the numCpt
	 */
	public String getNumCpt() {
		return numCpt;
	}

	/**
	 * @param numCpt the numCpt to set
	 */
	public void setNumCpt(String numCpt) {
		this.numCpt = numCpt;
	}

	/**
	 * @return the solde
	 */
	public Double getSolde() {
		return solde;
	}

	/**
	 * @param solde the solde to set
	 */
	public void setSolde(Double solde) {
		this.solde = solde;
	} 

	
	/**
	 * @return the clients
	 */
	public List<Client> getClients() {
		return clients;
	}

	/**
	 * @return the operations
	 */
	public List<Operation> getOperations() {
		return operations;
	}
	
	
}
