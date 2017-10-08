package br.com.webservice.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itemPressaoArterial")
public class ItemPressaoArterialEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer codigo;
	
	@Column(name="dataHora")
	private Date dataHora;

	@Column(name="pressaoAltaMedia")	
	private Float  pressaoAltaMedia;
	
	@Column(name="pressaoBaixaMedia")	
	private Float  pressaoBaixaMedia;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Float getPressaoAltaMedia() {
		return pressaoAltaMedia;
	}

	public void setPressaoAltaMedia(Float pressaoAltaMedia) {
		this.pressaoAltaMedia = pressaoAltaMedia;
	}

	public Float getPressaoBaixaMedia() {
		return pressaoBaixaMedia;
	}

	public void setPressaoBaixaMedia(Float pressaoBaixaMedia) {
		this.pressaoBaixaMedia = pressaoBaixaMedia;
	}

	
}//Fim da classe
