package br.com.webservice.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="glicose")
public class ItemGlicoseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer codigo;

	@Column(name="taxaGlicoseMedia")	
	private Integer  taxaGlicoseMedia;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getTaxaGlicoseMedia() {
		return taxaGlicoseMedia;
	}

	public void setTaxaGlicoseMedia(Integer taxaGlicoseMedia) {
		this.taxaGlicoseMedia = taxaGlicoseMedia;
	}

		
}//Fim da classe
