package com.jzapata.manejospringdatajpa.pruebas;

import com.jzapata.manejospringdatajpa.entities.entity7.Alumno;
import com.jzapata.manejospringdatajpa.entities.entity7.Curso;
import com.jzapata.manejospringdatajpa.repositories.repository7.AlumnoRepository;
import com.jzapata.manejospringdatajpa.repositories.repository7.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class Prueba007 implements CommandLineRunner {

    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private CursoRepository cursoRepository;


    @Override
    public void run(String... args) throws Exception {

        Alumno alumno1 = new Alumno();
        alumno1.setNombre("Alumno01");

        Alumno alumno2 = new Alumno();
        alumno1.setNombre("Alumno02");


        Curso curso1 = new Curso();
        curso1.setNombre("Desarrollo web");

        Curso curso2 = new Curso();
        curso2.setNombre("Matematicas");

        alumno1.getCursos().add(curso1);
        alumno2.getCursos().add(curso2);
        alumno2.getCursos().add(curso1);

        alumnoRepository.save(alumno1);
        alumnoRepository.save(alumno2);

        //Busqueda
        Alumno alumnoRecuperado = alumnoRepository.findById(1L).orElse(null);
        System.out.println("Alumno recuperado: "+alumnoRecuperado.getNombre());

        Curso cursoRecuperado = cursoRepository.findById(1l).orElse(null);
        System.out.println("Curso recuperado: "+ cursoRecuperado.getNombre());

        //Eliminamos un estudiante x su id
        alumnoRepository.deleteById(1L);

        //Eliminar un curso x su id
        cursoRepository.deleteById(1L);




    }
}
