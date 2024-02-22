package com.auroracode.springboot.satelitesRestApi.rest;

import com.auroracode.springboot.satelitesRestApi.entity.Satelite;
import com.auroracode.springboot.satelitesRestApi.exception.SateliteNotFoundException;
import com.auroracode.springboot.satelitesRestApi.service.SateliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SateliteRestController {
    private final SateliteService sateliteService;

    @Autowired
    public SateliteRestController(SateliteService sateliteService) {
        this.sateliteService = sateliteService;
    }

    //Inserta un satelite en la base de datos.
    @PostMapping("/satelites")
    public Satelite insertarSatelite(@RequestBody Satelite satelite){
        //Se pone el id como cero para forzar la insercion.
        satelite.setId(0);
        Satelite tmpSatelite = sateliteService.insertar(satelite);
        return tmpSatelite;
    }

    //Actualiza un satelite en la base de datos
    @PutMapping("/satelites")
    public Satelite actualizarSatelite(@RequestBody Satelite satelite){
        return sateliteService.insertar(satelite);
    }

    //Lista todos los satelites
    @GetMapping("/satelites")
    public List<Satelite> listarSatelites(){
        return sateliteService.listarTodo();
    }

    //Lista un satelite de acuerdo por id
    @GetMapping("/satelites/{sateliteId}")
    public Satelite listarSatelite(@PathVariable int sateliteId){
        Satelite tmpSatelite = sateliteService.listarPorId(sateliteId);
        if (tmpSatelite == null){
            throw new SateliteNotFoundException("No se encontro el satelite con id: " + sateliteId);
        }
        return tmpSatelite;
    }

    //Eliminar un satelite de la base de datos
    @DeleteMapping("/satelites/{id}")
    public String eliminarSatelite(@PathVariable int id){
        Satelite tmpSatelite = sateliteService.listarPorId(id);
        if (tmpSatelite == null){
            throw new SateliteNotFoundException("No se encontro el satelite con id: " + id);
        }
        sateliteService.borrarPorId(id);

        return "Se elimino el satelite con id: " + id;
    }
}
