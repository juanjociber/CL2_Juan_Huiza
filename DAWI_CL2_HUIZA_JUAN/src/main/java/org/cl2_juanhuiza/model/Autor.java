package org.cl2_juanhuiza.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="tb_autores")
@Data
public class Autor {

	@Id
	private int cod_autor;
	
	private String nom_autor;
	
	private String fna_autor;
}
