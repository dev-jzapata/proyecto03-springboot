package com.jzapata.manejospringdatajpa.pruebas;

import com.jzapata.manejospringdatajpa.entities.entity1.Direccion;
import com.jzapata.manejospringdatajpa.entities.entity1.Estudiante;
import com.jzapata.manejospringdatajpa.repositories.repository1.DireccionRepository;
import com.jzapata.manejospringdatajpa.repositories.repository1.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Prueba01 implements CommandLineRunner {
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private DireccionRepository direccionRepository;
    @Override
    public void run(String... args) throws Exception {

        Direccion direccion = new Direccion();
        direccion.setCalle("1235 calle principal");
        direccion.setCiudad("Ciudad Ejemplo 3");
        direccion.setCodigoPostal("123456");



        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Pepito");
        estudiante.setDireccion(direccion);

        estudianteRepository.save(estudiante);

        estudiante.setNombre("Pepito Actualizado");
        estudianteRepository.save(estudiante);

        Iterable<Estudiante> estudiantes = estudianteRepository.findAll();

        for(Estudiante e: estudiantes){
            System.out.println("Estudiante: "+e.getNombre()+ ", Direccion: "+ e.getDireccion().getCalle());
        }

    }
}
