package org.cl2_juanhuiza.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="tb_libros")
@Data
public class Libro {
	@Id
	private int cod_libro;
	private String nom_libro;
	private String editorial_libro;
	private String fecha_publi;
	
	
	@ManyToOne
	@JoinColumn(name="cod_autor", insertable=false,updatable=false)
	private Autor autor;
	private int cod_autor;
	
	@ManyToOne
	@JoinColumn(name="cod_genero",insertable=false,updatable=false)
	private Genero genero;

	private int cod_genero;
}
