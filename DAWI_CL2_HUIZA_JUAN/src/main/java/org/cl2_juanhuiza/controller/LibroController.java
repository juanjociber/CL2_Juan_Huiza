package org.cl2_juanhuiza.controller;

import org.cl2_juanhuiza.model.Libro;
import org.cl2_juanhuiza.repository.IAutoresRepository;
import org.cl2_juanhuiza.repository.IGenerosRepository;
import org.cl2_juanhuiza.repository.ILibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LibroController {
	@Autowired
	private ILibrosRepository replib;

	@Autowired
	private IAutoresRepository repaut;
	
	@Autowired
	private IGenerosRepository repgen;
	
	@GetMapping("/libro/cargar")
	public String cargarformulario(Model model) {
		model.addAttribute("libro", new Libro());
		model.addAttribute("lstAutores",repaut.findAll());
		model.addAttribute("lstGeneros", repgen.findAll());
		
		return "crudlibroshuiza";
	}
	
	@PostMapping("/libro/eliminar")
	public String eliminarLibro(@ModelAttribute Libro libro, Model model) {
		System.out.println(libro);
		model.addAttribute("lstAutores",repaut.findAll());
		model.addAttribute("lstGeneros",repgen.findAll());
		
		try {
			replib.delete(libro);
			model.addAttribute("success","Proceso realizado con éxito");
		} catch (Exception e) {
			model.addAttribute("error","Error al eliminar libro");
		}
		return "crudlibroshuiza";
	}
	
	@GetMapping("/libro/listar")
	public String listadoLibro(Model model) {
		model.addAttribute("lstLibros",replib.findAll());
		return "consultahuiza";
	}
	
	@PostMapping("/libro/seleccionar")
	public String buscarLibro(@ModelAttribute Libro l, Model model) {
		System.out.println(l);
		model.addAttribute("libro",replib.findById(l.getCod_libro()));
		
		model.addAttribute("lstAutores",repaut.findAll());
		model.addAttribute("lstGeneros",repgen.findAll());
		
		return "crudlibroshuiza";
	}
}
