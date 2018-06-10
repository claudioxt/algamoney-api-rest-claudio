package com.algaworks.algamoney.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "lancamento")
public class Lancamento {

	private Long codigo;

	private String descricao;

	private LocalDate dataVencimento;

	private LocalDate dataPagamento;

	private BigDecimal valor;

	private String observacao;

	private TipoLancamento tipo;

	private Categoria categoria;

	private Pessoa pessoa;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}

	@NotNull
	public String getDescricao() {
		return descricao;
	}

	@NotNull
	@Column(name = "data_vencimento")
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	@Column(name = "data_pagamento")
	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	@NotNull
	public BigDecimal getValor() {
		return valor;
	}

	public String getObservacao() {
		return observacao;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	public TipoLancamento getTipo() {
		return tipo;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_categoria")
	public Categoria getCategoria() {
		return categoria;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_pessoa")
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public void setTipo(TipoLancamento tipo) {
		this.tipo = tipo;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
