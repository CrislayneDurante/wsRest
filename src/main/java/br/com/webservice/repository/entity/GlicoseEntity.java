package br.com.webservice.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itemglicose")
public class GlicoseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer codigo;

	@Column(name="taxaGlicose")	
	private Integer  taxaGlicose;
	
	@Column(name="dataHora")	
	private Date  dataHora;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getTaxaGlicose() {
		return taxaGlicose;
	}

	public void setTaxaGlicose(Integer taxaGlicose) {
		this.taxaGlicose = taxaGlicose;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	
	

		
}//Fim da classe
