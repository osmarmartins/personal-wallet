package br.com.futura.pw.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.futura.pw.entity.Categoria;
import br.com.futura.pw.repository.CategoriaRepository;
import br.com.futura.pw.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	@Override
	@Transactional
	public Categoria salvar(Categoria categoria) {
		return repository.save(categoria);
	}
	
	@Override
	public Optional<Categoria> buscarPor(Long id) {
		return repository.findById(id);
	}

}
