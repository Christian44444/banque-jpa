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
}
