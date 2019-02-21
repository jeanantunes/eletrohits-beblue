package com.eletrohits.test.service;

import com.eletrohits.test.model.Discos;
import com.eletrohits.test.model.Discos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiscosService extends JpaRepository<Discos, Long> {

    Discos save(Discos dados);

    Discos findById(Long id);

    String deleteById(Long id);

    List<Discos> findAll();

    void delete(Long id);
}