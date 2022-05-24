package org.cl2_juanhuiza.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="tb_generos")
@Data
public class Genero {

	@Id
	private int cod_genero;
	
	private String nombre_genero;
	
	private String sub_genero;
	
}
