package org.cl2_juanhuiza.repository;

import org.cl2_juanhuiza.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibrosRepository extends JpaRepository<Libro, Integer> {

}
