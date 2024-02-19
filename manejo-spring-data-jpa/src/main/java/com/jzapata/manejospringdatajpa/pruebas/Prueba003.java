package com.jzapata.manejospringdatajpa.pruebas;

import com.jzapata.manejospringdatajpa.entities.entity3.Editor;
import com.jzapata.manejospringdatajpa.entities.entity3.Revista;
import com.jzapata.manejospringdatajpa.repositories.repository3.EditorRepository;
import com.jzapata.manejospringdatajpa.repositories.repository3.RevistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Prueba003 implements CommandLineRunner {

    @Autowired
    private EditorRepository editorRepository;

    @Autowired
    private RevistaRepository revistaRepository;

    @Override
    public void run(String... args) throws Exception {
        Editor editor1 = new Editor();
        editor1.setNombre("Nombre 01");

        Revista revista1 = new Revista();
        revista1.setNombre("Revista A");
        revista1.setEditor(editor1);

        Revista revista2 = new Revista();
        revista2.setNombre("Revista B");
        revista2.setEditor(editor1);

        editor1.getRevistas().add(revista1);
        editor1.getRevistas().add(revista2);

        editorRepository.save(editor1);

        //Leer el editor y sus revistas

        Optional<Editor> editorGuardado = editorRepository.findById(editor1.getId());
        if (editorGuardado.isPresent()){
            Editor editorObtenido = editorGuardado.get();
            System.out.println("Editor obtenido: "+ editorObtenido.getNombre());

            editorObtenido.getRevistas().size();
            //Actualizar el nombre del editor

            editorObtenido.setNombre("Editor abc");
            editorRepository.save(editorObtenido);
            System.out.println("Editor actualizado: "+ editorObtenido.getNombre());

            //Crear nueva revista
            Revista revista3 = new Revista();
            revista3.setNombre("Revista C");
            revista3.setEditor(editorObtenido);

            revistaRepository.save(revista3);
            System.out.println("Revista creada: "+revista3.getNombre());

            //eliminar revista
            Optional<Revista> revistaGuardada = revistaRepository.findById(revista1.getId());
            if (revistaGuardada.isPresent()){
                Revista revistaEliminar = revistaGuardada.get();
                revistaRepository.delete(revistaEliminar);
                System.out.println("Revista Eliminada: " + revistaEliminar.getNombre());

            }else {
                System.out.println("Revista no encontrada");
            }
        }else {
            System.out.println("Editor no encontrada");
        }

    }
}
