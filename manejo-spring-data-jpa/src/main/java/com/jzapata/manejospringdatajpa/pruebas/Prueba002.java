package com.jzapata.manejospringdatajpa.pruebas;

import com.jzapata.manejospringdatajpa.entities.entity2.Autor;
import com.jzapata.manejospringdatajpa.entities.entity2.Libro;
import com.jzapata.manejospringdatajpa.repositories.repository2.AutorRepository;
import com.jzapata.manejospringdatajpa.repositories.repository2.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Component
public class Prueba002 implements CommandLineRunner {
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private LibroRepository libroRepository;


    @Override
    public void run(String... args) throws Exception {
        Autor autor = new Autor();
        autor.setNombre("Nombre 01");

        Libro libro1 = new Libro();
        libro1.setTitulo("Titulo 01");

        Libro libro2 = new Libro();
        libro2.setTitulo("Titulo 02");

        autor.getLibros().add(libro1);
        autor.getLibros().add(libro2);

        autorRepository.save(autor);

        Optional<Autor> autorGuardado = autorRepository.findById(autor.getId());
        autorGuardado.ifPresent(a -> {
            System.out.println("Autor leido x id: "+a.getNombre());

            a.setNombre("Nuevo nombre del Autor");

            autorRepository.save(a);

            System.out.println("Autor actualizado: "+ a.getNombre());
        });

        List<Autor> autores = new ArrayList<>();
        for(Autor a : autores){
            System.out.println("-"+ a.getNombre());
        }
        autorRepository.delete(autor);
        System.out.println("Autor eliminado");
    }
}
