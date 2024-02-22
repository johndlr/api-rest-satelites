package com.auroracode.springboot.satelitesRestApi.dao;

import com.auroracode.springboot.satelitesRestApi.entity.Satelite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SateliteDAO extends JpaRepository<Satelite, Integer> {



}
