package com.auroracode.springboot.satelitesRestApi.service;

import com.auroracode.springboot.satelitesRestApi.entity.Satelite;

import java.util.List;

public interface SateliteService {
    Satelite insertar(Satelite satelite);
    List<Satelite> listarTodo();
    Satelite listarPorId(int id);
    void borrarPorId(int id);
}
