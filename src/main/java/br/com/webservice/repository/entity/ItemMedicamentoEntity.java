package br.com.webservice.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itemmedicamento")
public class ItemMedicamentoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer codigo;

	@Column(name="ismedicamentotomado")	
	private Boolean  ismedicamentotomado;
	
	@Column(name="datahora")	
	private Date  datahora;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Boolean getIsmedicamentotomado() {
		return ismedicamentotomado;
	}

	public void setIsmedicamentotomado(Boolean ismedicamentotomado) {
		this.ismedicamentotomado = ismedicamentotomado;
	}

	public Date getDatahora() {
		return datahora;
	}

	public void setDatahora(Date datahora) {
		this.datahora = datahora;
	}
	
	
}//Fim da classe
