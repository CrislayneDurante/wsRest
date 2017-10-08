package br.com.webservice.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicamentos")
public class MedicamentosEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer codigo;

	@Column(name="nome")	
	private String  nome;
	
	@Column(name="alias")	
	private String  alias;
	
	@Column(name="dosagem")
	private Float dosagem;
	
	@Column(name="unidadeDosagem")	
	private String  unidadeDosagem;
	
	@Column(name="frequencia")	
	private String  frequencia;
	
	@Column(name="qtdVezesPorDia")
	private Integer qtdVezesPorDia;
	
	@Column(name="dataInicial")
	private Date dataInicial;
	
	@Column(name="dataFinal")
	private Date dataFinal;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Float getDosagem() {
		return dosagem;
	}

	public void setDosagem(Float dosagem) {
		this.dosagem = dosagem;
	}

	public String getUnidadeDosagem() {
		return unidadeDosagem;
	}

	public void setUnidadeDosagem(String unidadeDosagem) {
		this.unidadeDosagem = unidadeDosagem;
	}

	public String getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
	}

	public Integer getQtdVezesPorDia() {
		return qtdVezesPorDia;
	}

	public void setQtdVezesPorDia(Integer qtdVezesPorDia) {
		this.qtdVezesPorDia = qtdVezesPorDia;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	
	
}//Fim da classe
