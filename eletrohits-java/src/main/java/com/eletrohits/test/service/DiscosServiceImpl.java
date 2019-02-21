package com.eletrohits.test.service;

import com.eletrohits.test.model.Discos;
import com.eletrohits.test.repository.DiscosReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscosServiceImpl implements DiscosService {

    @Autowired
    DiscosReposity discosRepository;

    @Override
    public Discos save(Discos dados) {
        discosRepository.update(dados);
        return dados;
    }

    @Override
    public Discos findById(Long id) {
        return discosRepository.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        Discos dados = discosRepository.findById(id);
        if(dados != null){
            discosRepository.delete(dados);
            return "Excluido com Sucesso";
        }
        return "Dados null";
    }

    @Override
    public List<Discos> findAll() {
        return discosRepository.findAll();
    }

    @Override
    public List<Discos> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<Discos> findAll(Iterable<Long> iterable) {
        return discosRepository.findAll();
    }

    @Override
    public <S extends Discos> List<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Discos findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Page<Discos> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Discos> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Discos> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Discos getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Discos> S findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Discos> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Discos> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Discos> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Discos> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Discos> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Discos Discos) {
        discosRepository.delete(Discos);
    }

    @Override
    public void delete(Iterable<? extends Discos> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}