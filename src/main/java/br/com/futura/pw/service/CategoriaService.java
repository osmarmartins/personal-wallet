package br.com.futura.pw.service;

import java.util.Optional;

import br.com.futura.pw.entity.Categoria;

public interface CategoriaService {

	Categoria salvar(Categoria categoria);

	Optional<Categoria> buscarPor(Long id);

}