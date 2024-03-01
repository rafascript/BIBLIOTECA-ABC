package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Este campo não pode ser nulo")
	private String issn;
	private String titulo;
	private String sinopse;
	private long ano;
	private long paginas;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("livro")
	private Biblioteca biblioteca;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("livro")
	private Editora editora;
	
	@ManyToMany(cascade = CascadeType.ALL)	
	@JoinTable(name = "Autor")
	private List<Autor> autores;

}
