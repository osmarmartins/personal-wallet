package br.com.futura.pw.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.futura.pw.dto.CategoriaDTO;
import br.com.futura.pw.entity.Categoria;
import br.com.futura.pw.helpper.Response;
import br.com.futura.pw.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@PostMapping
	public ResponseEntity<Response<CategoriaDTO>> create(@Valid @RequestBody CategoriaDTO dto, BindingResult result) {
		Response<CategoriaDTO> response = new Response<CategoriaDTO>();
		Categoria categoria = service.salvar(this.convertDtoToEntity(dto));
		response.setData(this.convertEntityToDto(categoria));

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	private Categoria convertDtoToEntity(CategoriaDTO dto) {
		Categoria c = new Categoria();
		c.setDescricao(dto.getDescricao());
		c.setImagem(dto.getImagem());
		
		return c;
	}
	
	private CategoriaDTO convertEntityToDto(Categoria c) {
		CategoriaDTO dto = new CategoriaDTO();
		dto.setDescricao(c.getDescricao());
		dto.setImagem(c.getImagem());
		
		return dto;
	}
 
}
