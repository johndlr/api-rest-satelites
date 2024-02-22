package com.auroracode.springboot.satelitesRestApi.service;

import com.auroracode.springboot.satelitesRestApi.dao.SateliteDAO;
import com.auroracode.springboot.satelitesRestApi.entity.Satelite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SateliteServiceImpl implements SateliteService{
    private final SateliteDAO sateliteDAO;

    @Autowired
    public SateliteServiceImpl(SateliteDAO sateliteDAO) {
        this.sateliteDAO = sateliteDAO;
    }

    @Override
    @Transactional
    public Satelite insertar(Satelite satelite) {
        return sateliteDAO.save(satelite);
    }

    @Override
    public List<Satelite> listarTodo() {
        return sateliteDAO.findAll();
    }

    @Override
    public Satelite listarPorId(int id) {
        Optional<Satelite> result = sateliteDAO.findById(id);
        Satelite satelite = null;
        if (result.isPresent()){
            satelite = result.get();
        }else {
            throw new RuntimeException("No se encontro el satelite con id - " + id);
        }

        return satelite;
    }

    @Override
    @Transactional
    public void borrarPorId(int id) {
        sateliteDAO.deleteById(id);
    }
}
