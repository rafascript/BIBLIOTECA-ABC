package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Livro;
import app.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	List<Livro> lista = new ArrayList<>();
	
	public String save(Livro livro) {
		this.livroRepository.save(livro);
		return livro.getTitulo()+ " salvo com sucesso";
	}
	
	public String update(long id, Livro livro) {
		livro.setId(id);
		this.livroRepository.save(livro);
		return "biblioteca não encontrado para alterar";
	}
	
	public List<Livro> listAll(){
		return this.livroRepository.findAll();
	}
	
	public Livro findById(long idLivro) {
		Livro livro = this.livroRepository.findById(idLivro).get();
		return livro;
		
	}
	
	public String delete(long idLivro) {
		this.livroRepository.deleteById(idLivro);
		return "Não encontrado";

}
}