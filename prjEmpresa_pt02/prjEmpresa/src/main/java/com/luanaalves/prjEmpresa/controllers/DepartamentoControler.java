package com.luanaalves.prjEmpresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luanaalves.prjEmpresa.entities.Departamento;
import com.luanaalves.prjEmpresa.services.DepartamentoService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Departamento", description = "CENTRAL DE DEPARTAMENTO")
@RestController
@RequestMapping("/departamento") 
	public class DepartamentoControler {

	private final DepartamentoService departamentoService;

	@Autowired
	public DepartamentoControler (DepartamentoService DepartamentoService) {
		this.departamentoService = DepartamentoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Departamento> getDepartamento(@PathVariable Long depcodigo) {
		Departamento departamento = departamentoService.getDepartamentoById(depcodigo);
		if (departamento != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Departamento createJogo(@RequestBody Departamento departamento) {
		return departamentoService.saveDepartamentoo(departamento);
	}

	@DeleteMapping("/{id}")
	public void deleteDepartamento(@PathVariable Long depcodigo) {
		departamentoService.deletedepartamento(depcodigo);
	}

	// Utilizando o ResponseEntity e RequestEntity
	@GetMapping
	public ResponseEntity<List<Departamento>> getAllJogos(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Departamento> departamento = departamentoService.getAllDepartamento();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(departamento);
	}

	@PutMapping("/{id}")
	public Departamento updateJogo(@PathVariable Long depcodigo, @RequestBody Departamento departamento) {
		return departamentoService.updateDepartamento(depcodigo, departamento);
	}
}
