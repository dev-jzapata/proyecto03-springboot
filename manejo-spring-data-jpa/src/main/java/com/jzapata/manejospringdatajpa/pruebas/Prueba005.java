package com.jzapata.manejospringdatajpa.pruebas;

import com.jzapata.manejospringdatajpa.entities.entity5.Equipo;
import com.jzapata.manejospringdatajpa.entities.entity5.Jugador;
import com.jzapata.manejospringdatajpa.repositories.repository5.EquipoRepository;
import com.jzapata.manejospringdatajpa.repositories.repository5.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Transactional
public class Prueba005 implements CommandLineRunner {

    @Autowired
    private EquipoRepository equipoRepository;

    @Override
    public void run(String... args) throws Exception {
        Equipo equipo = new Equipo();
        equipo.setNombre("Equipo de futbol");

        Jugador jugador1 = new Jugador();
        jugador1.setNombre("Juan Perez");
        jugador1.setNumeroCamiseta(10);

        Jugador jugador2 = new Jugador();
        jugador2.setNombre("Christian Ramirez");
        jugador2.setNumeroCamiseta(7);

        equipo.getJugadores().add(jugador1);
        equipo.getJugadores().add(jugador2);

        equipoRepository.save(equipo);

        //Leer el equipo y sus jugadores
        Equipo equipoGuardado = equipoRepository.findById(equipo.getId()).orElse(null);
        if(equipoGuardado != null){
            System.out.println("Equipo : " + equipoGuardado.getNombre());
            System.out.println("Jugadores en el equipo (Usando LAZY)");
            System.out.println(equipoGuardado);
            for(Jugador jugador : equipo.getJugadores()){
                System.out.println("-" + jugador.getNombre() + "(Camisea #" + jugador.getNumeroCamiseta() + ")");
            }
        }

        //Realizar operaciones de actualizacion y eliminacion
        if(equipoGuardado != null){
            //Actualizar un jugador en el equipo
            Jugador jugadorActualizado = equipoGuardado.getJugadores().get(0);
            jugadorActualizado.setNumeroCamiseta(12);

            //No es necesario guardar nuevamente el euipo, ya que las actualizacions se aplican automaticamente debido al CascadeType.MERGE

            //Leer el equipo y sus jugadores nuevamente
            Equipo equipoActualizado = equipoRepository.findById(equipo.getId()).orElse(null);
            if(equipoActualizado != null){
                System.out.println("Equipo actualizado : " + equipoActualizado.getNombre());
                System.out.println("Jugadores actualizados : ");
                for(Jugador jugador : equipoActualizado.getJugadores()){
                    System.out.println("-" + jugador.getNombre() + "(Camisea #" + jugador.getNumeroCamiseta() + ")");
                }

                //Eliminar un jugador del equipo
                equipoActualizado.getJugadores().remove(1);

                //No es necesario guardar nuevamente el euipo, ya que las actualizacions se aplican automaticamente debido al CascadeType.MERGE
                equipoRepository.delete(equipoActualizado);
            }
        }

        //Verificamos si el equipo ha sido eliminado
        Equipo equipoEliminado = equipoRepository.findById(equipo.getId()).orElse(null);
        if(equipoEliminado == null){
            System.out.println("Equipo eliminado con éxito");
        }
    }
}
