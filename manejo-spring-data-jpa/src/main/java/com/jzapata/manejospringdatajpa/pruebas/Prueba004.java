package com.jzapata.manejospringdatajpa.pruebas;

import com.jzapata.manejospringdatajpa.entities.entity4.Automovil;
import com.jzapata.manejospringdatajpa.entities.entity4.Propietario;
import com.jzapata.manejospringdatajpa.repositories.repository4.AutomovilRepository;
import com.jzapata.manejospringdatajpa.repositories.repository4.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Prueba004 implements CommandLineRunner {

    @Autowired
    AutomovilRepository automovilRepository;
    @Autowired
    PropietarioRepository propietarioRepository;

    @Override
    public void run(String... args) throws Exception {

        Propietario propietario1 = new Propietario();
        propietario1.setNombre("Propietario 01");

        Automovil automovil1 = new Automovil();
        automovil1.setMarca("Toyota");
        automovil1.setModelo("CH-R");

        automovil1.setPropietario(propietario1);
        propietario1.setAutomovil(automovil1);

        propietarioRepository.save(propietario1);
        //automovilRepository.save(automovil1);

        Long propietarioId = propietario1.getId();
        Propietario propietarioLeido = propietarioRepository.findById(propietarioId).orElse(null);
        if (propietarioLeido != null){
            System.out.println("Propietario Leido: " + propietarioLeido.getNombre());
        }

        //Actualizar el Automovil asociado al propietario

        Automovil automovilUpdate = propietario1.getAutomovil();
        automovilUpdate.setMarca("Alfa");
        automovilUpdate.setModelo("147");
        automovilRepository.save(automovilUpdate);

        //Eliminar el Propietario y su automovil

        propietarioRepository.delete(propietario1);


        //Verificar si el propietario ha sido eliminado

        Propietario propietarioEliminado = propietarioRepository.findById(propietarioId).orElse(null);
        if (propietarioEliminado == null){
            System.out.println("Propietario eliminado");
        }else {
            System.out.println("No se ha podido eliminar el propietario");
        }

    }
}
