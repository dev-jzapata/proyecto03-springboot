package com.jzapata.manejospringdatajpa.pruebas;

import com.jzapata.manejospringdatajpa.entities.entity6.Aerolinea;
import com.jzapata.manejospringdatajpa.entities.entity6.Vuelo;
import com.jzapata.manejospringdatajpa.repositories.repository6.AerolineaRepository;
import com.jzapata.manejospringdatajpa.repositories.repository6.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Prueba006 implements CommandLineRunner {
    @Autowired
    VueloRepository vueloRepository;
    @Autowired
    AerolineaRepository aerolineaRepository;
    @Override
    public void run(String... args) throws Exception {

        //crear una aerolinea con vuelos

        Aerolinea aerolinea1 = new Aerolinea();
        aerolinea1.setNombre("Iberia");

        Vuelo vuelo1 = new Vuelo();
        vuelo1.setNumeroVuelo("xxx111");
        vuelo1.setDestino("Menorca");

        Vuelo vuelo2 = new Vuelo();
        vuelo2.setNumeroVuelo("xxx222");
        vuelo2.setDestino("Ibiza");

        aerolinea1.getVuelos().add(vuelo1);
        aerolinea1.getVuelos().add(vuelo2);

        aerolineaRepository.save(aerolinea1);

        //Leer AEROlinea desde el repository

        Aerolinea aerolineaDesdeDB = aerolineaRepository.findById(aerolinea1.getId()).orElse(null);
        System.out.println("Aerolinea: "+ aerolineaDesdeDB.getNombre());

        //Eliminar Aerolinea

        aerolineaRepository.delete(aerolineaDesdeDB);

        //Comprobar que la aerolinea y los vuelos an sido eliminada:

        List<Vuelo> vueloList = vueloRepository.findAll();
        System.out.println("Numero de vuelos en la base de datos: "+ vueloList.size());




    }
}
