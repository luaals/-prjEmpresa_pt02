package com.luanaalves.prjEmpresa.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_funcionarios")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long funcodigo;

	@NotNull
	@NotBlank
	private String funnome;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate funnascimento;

	@NotNull
	@NotBlank
	private String funsalario;

	public Funcionario() {

	}

	public Funcionario(Long funcodigo, String funnome, LocalDate funnascimento, String funsalario) {
		super();
		this.funcodigo = funcodigo;
		this.funnome = funnome;
		this.funnascimento = funnascimento;
		this.funsalario = funsalario;

	}

	public Long getFuncodigo() {
		return funcodigo;
	}

	public void setFuncodigo(Long funcodigo) {
		this.funcodigo = funcodigo;
	}

	public String getFunnome() {
		return funnome;
	}

	public void setFunnome(String funnome) {
		this.funnome = funnome;
	}

	public LocalDate getFunnascimento() {
		return funnascimento;
	}

	public void setFunnascimento(LocalDate funnascimento) {
		this.funnascimento = funnascimento;
	}

	public String getFunsalario() {
		return funsalario;
	}

	public void setFunsalario(String funsalario) {
		this.funsalario = funsalario;
	}

	@ManyToOne
	private Departamento departamento;

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
}
