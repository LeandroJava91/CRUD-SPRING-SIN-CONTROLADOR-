package com.example.integracion;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.integracion.models.Alumno;
import com.example.integracion.models.Colegio;
import com.example.integracion.service.AlumnoService;
import com.example.integracion.service.ColegioService;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        // Obtener una instancia del servicio AlumnoService del contexto de la aplicación
        AlumnoService alumnoService = context.getBean(AlumnoService.class);
        ColegioService colegioService = context.getBean(ColegioService.class);
        

        
        
       /* 
        Colegio cole= new Colegio();
        cole.setNombre("perpetuo");
        Colegio cole2= new Colegio();
        cole2.setNombre("jesus de nazareth");
        colegioService.save(cole);
        colegioService.save(cole2);
        
     // Crear un nuevo alumno
        Alumno alumno = new Alumno();
        alumno.setNombre("Juan");
        alumno.setColegio(cole);
        
        Alumno alumno2 = new Alumno();
        alumno.setNombre("lotso");
        alumno.setColegio(cole2);
        
          
        // Guardar el alumno en la base de datos
        alumnoService.guardarAlumno(alumno);*/

        // Buscar un alumno por ID
        
        
        Alumno alumnoEncontrado = alumnoService.buscarAlumnoPorId(18L);
        //eliminarAlumnoPorId(17L);
        

        if (alumnoEncontrado != null) {
            // Imprimir los datos del alumno por consola
            System.out.println(alumnoEncontrado);
         
            
        } else {
            System.out.println("Alumno no encontrado");
        }
        
        ////////ELIMINAR ALUMNO////////////////////
        alumnoService.eliminarAlumnoPorId(17L);
        
      
        
        /////////MODIFICAR ALUMNO////////
        Alumno alumnomodi = new Alumno();
        Optional<Colegio> colee= colegioService.findById(2l);
        Colegio cole2 = colee.orElse(null);
        
        alumnomodi.setId(5l);
        alumnomodi.setNombre("OSGUI");
        alumnomodi.setColegio(cole2);
        alumnoService.actualizarAlumno(alumnomodi);
        
        
    }
}
