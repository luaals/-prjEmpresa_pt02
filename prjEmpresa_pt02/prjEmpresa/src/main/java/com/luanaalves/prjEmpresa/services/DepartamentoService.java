package com.luanaalves.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.luanaalves.prjEmpresa.entities.Departamento;
import com.luanaalves.prjEmpresa.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {
	private final DepartamentoRepository departamentorepository;
	
	@Autowired
	public DepartamentoService(DepartamentoRepository departamentorepository) {
		this.departamentorepository = departamentorepository;
}
	
	public Departamento getDepartamentoById(Long depcodigo) {
		return departamentorepository.findById(depcodigo).orElse(null);
	}
	
	public List<Departamento> getAllDepartamento(){
		return departamentorepository.findAll();
	}
	
	public Departamento saveDepartamentoo(Departamento departamento) {
		return departamentorepository.save(departamento);
	}
		
	public void deletedepartamento(Long depcodigo) {
		departamentorepository.deleteById(depcodigo);
	}
	public Departamento updateDepartamento(Long depcodigo, Departamento novoDepartamento) {
        Optional<Departamento> departamentoOptional = departamentorepository.findById(depcodigo);
        if (departamentoOptional.isPresent()) {
        	Departamento departamentoExistente = departamentoOptional.get();
           	departamentoExistente.setDepnome(novoDepartamento.getDepnome());    
            return departamentorepository.save(departamentoExistente); 
        } else {
            return null; 
        }
	}
}