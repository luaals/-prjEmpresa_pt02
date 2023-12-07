package com.luanaalves.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luanaalves.prjEmpresa.entities.Funcionario;
import com.luanaalves.prjEmpresa.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	

	@Autowired
	private FuncionarioRepository funcionariorepository;

	public List<Funcionario> getAllFuncionarios() {
		return funcionariorepository.findAll();
	}

	public Funcionario getFuncionarioById(long funcodigo) {
		return funcionariorepository.findById(funcodigo).orElse(null);
	}

	public Funcionario saveFuncionario(Funcionario funcionario) {
		return funcionariorepository.save(funcionario);
	}

	public List<Funcionario> getFuncionariosByFunnomeAproximado(String funnome) {
		return funcionariorepository.findByNomeContaining(funnome);
	}

	public boolean deleteFuncionario(Long id) {
		Optional<Funcionario> funcionarioExistente = funcionariorepository.findById(id);
		if (funcionarioExistente.isPresent()) {
			funcionariorepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Funcionario updateFuncionario(Long funcodigo, Funcionario novoFuncionario) {
		Optional<Funcionario> funcionarioOptional = funcionariorepository.findById(funcodigo);
		if (funcionarioOptional.isPresent()) {
			Funcionario funcionarioExistente = funcionarioOptional.get();
			funcionarioExistente.setFunnome(novoFuncionario.getFunnome());
			funcionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());
			funcionarioExistente.setFunsalario(novoFuncionario.getFunsalario());

			if (novoFuncionario.getDepartamento() != null) {
				funcionarioExistente.setDepartamento(novoFuncionario.getDepartamento());
			}
			return funcionariorepository.save(funcionarioExistente);
		} else {
			return null; // Ou lançar uma exceção indicando que o funcionário não foi encontrado
		}
	}
}
