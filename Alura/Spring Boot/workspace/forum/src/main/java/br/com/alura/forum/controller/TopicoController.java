package br.com.alura.forum.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.dto.DetalhesDoTopicoDTO;
import br.com.alura.forum.dto.TopicoDTO;
import br.com.alura.forum.form.AtualizacaoTopicoForm;
import br.com.alura.forum.form.TopicoForm;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

	@Autowired
	private TopicoRepository topicoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping
	public List<TopicoDTO> lista(String nomeCurso) {
		if (nomeCurso == null) {
			List<Topico> topicos = this.topicoRepository.findAll();

			return TopicoDTO.converte(topicos);
		} else {
			List<Topico> topicos = this.topicoRepository.findByCursoNome(nomeCurso);

			return TopicoDTO.converte(topicos);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<TopicoDTO> cadastra(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converte(this.cursoRepository);
		
		this.topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new TopicoDTO(topico));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoTopicoDTO> detalha(@PathVariable Long id) {
		Optional<Topico> optional = this.topicoRepository.findById(id);
		
		if (optional.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoTopicoDTO(optional.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicoDTO> atualiza(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form) {
		Optional<Topico> optional = this.topicoRepository.findById(id);
		
		if (optional.isPresent()) {
			Topico topico = form.atualiza(id, this.topicoRepository);
			
			return ResponseEntity.ok(new TopicoDTO(topico));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remove(@PathVariable Long id) {
		Optional<Topico> optional = this.topicoRepository.findById(id);
		
		if (optional.isPresent()) {
			this.topicoRepository.deleteById(id);
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
