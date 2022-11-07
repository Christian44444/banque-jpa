package fr.diginamic;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	@Column(name = "NUMERO", length = 5, nullable = true)
	private Integer numero;
	
	@Column(name = "RUE", length = 255, nullable = false)
	private String rue;
	
	@Column(name = "CODE_POSTAL", length = 6, nullable = false)
	private Integer codePostal;
	
	@Column(name = "VILLE", length = 100, nullable = false)
	private String ville;

	/**
	 * Constructeur par défaut
	 */
	public Adresse() {
		super();
	}

	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}

	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * @return the codePostal
	 */
	public Integer getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
}
