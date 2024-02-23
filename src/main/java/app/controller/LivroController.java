package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Livro;
import app.service.LivroService;

@RestController
@RequestMapping("/api/livro")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Livro livro){
		
		try {
			
			String mensagem = this.livroService.save(livro);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<String>("O seguinte erro  foi encontrado: "+e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Livro livro, @PathVariable long id){
		
		try {
			
			String mensagem = this.livroService.update(id, livro);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			return new ResponseEntity<String>("O seguinte erro  foi encontrado: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		
		}
		
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Livro>> listAll(){
		
		try {
			
			List<Livro> lista = this.livroService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	@GetMapping("/findById/{idLivro}")
	public ResponseEntity<Livro> findById(@PathVariable long idLivro){
		
		try {
			
			Livro livro = this.livroService.findById(idLivro);
			return new ResponseEntity<>(livro, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}
				
	}
	
	@DeleteMapping("/delete/{idLivro}")
	public ResponseEntity<String> delete(@PathVariable long idLivro){
		
	try {
			
			String mensagem = this.livroService.delete(idLivro);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<String>(""+e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}		
		
	}

}
