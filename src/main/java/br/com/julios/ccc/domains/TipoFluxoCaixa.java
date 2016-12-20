package br.com.julios.ccc.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_FLUXO_CAIXA")
public class TipoFluxoCaixa {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private long id;

}
