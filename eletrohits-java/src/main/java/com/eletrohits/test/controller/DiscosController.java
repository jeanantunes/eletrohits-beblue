package com.eletrohits.test.controller;

import com.eletrohits.test.model.Discos;
import com.eletrohits.test.model.DiscosWrapper;
import com.eletrohits.test.service.DiscosService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/discos")
public class DiscosController {

    @Autowired
    private DiscosService discosService;

    @Value("${file.list}")
    private String json;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //List
    @GetMapping("/list")
    public List<Discos> getAllDiscos() throws IOException {

        List<Discos> allDiscos = discosService.findAll();
        if (allDiscos.isEmpty()) {
            logger.error("Lista de Discos vazia: " + allDiscos);
            readJsonWithObjectMapper();
            List<Discos> d = discosService.findAll();
            return d;
        }
        return allDiscos;
    }

    // Save
    @PutMapping(value = "/save/{dados}", produces = "application/text")
    public @ResponseBody
    String saveDiscos(@RequestBody Discos dados) {

        discosService.save(dados);

        Discos d = discosService.findById(dados.getId());
        d.setGenero(dados.getGenero());
        d.setNome(dados.getNome());
        d.setValor(dados.getValor());

        discosService.save(d);

        if (dados.getGenero() != null || dados.getNome() != null || dados.getValor() != null) {
            logger.info("dados Salvo: " + dados.getGenero() + ", " + dados.getNome() + ", " + dados.getValor() + "");
            return "Salvo com Sucesso.";
        } else {
            logger.error("Dados obrigatórios: genero: " + dados.getGenero() + " nome: " + dados.getNome() + " valor: " + dados.getValor() + "");
            return "Dados obrigatórios: genero: " + dados.getGenero() + " nome: " + dados.getNome() + " valor: " + dados.getValor() + "";
        }
    }

    // Find
    @PostMapping(value = "/find/{id}", produces = "application/json")
    public @ResponseBody
    Discos getDiscosById(@PathVariable(value = "id") Long id) {
        Discos dados = discosService.findById(id);
        if (dados == null) {
            logger.error("ID: " + id + " não Localizado.");
        }
        return dados;
    }

    // Update
    @PutMapping(value = "/update/{id}", produces = "application/text")
    public @ResponseBody
    String updateDiscos(@PathVariable(value = "id") Long id,
                                         @RequestBody Discos dadosDetails) {
        Discos dados = discosService.findById(id);
        if (dados == null) {
            logger.error("ID: " + id + ". Não Localizado.");
            return "ID: " + id + ". Não Localizado.";
        } else {
            discosService.save(dadosDetails);
            logger.info("Discos atualizada com Sucesso.");
        }
        return "Atualizado com Sucesso.";
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public String deleteDiscos(@PathVariable(value = "id") Long id) {
        Discos dados = discosService.findById(id);
        if (dados == null) {
            logger.error("ID: " + id + ". Não Localizado.");
            return "Discos não localizada.";
        } else {
            discosService.delete(dados);
            return "Excluido com Sucesso.";
        }
    }

    public ModelAndView readJsonWithObjectMapper() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //List<Discos> d = objectMapper.readValue(new File(json), objectMapper.getTypeFactory().constructCollectionLikeType(List.class,Discos.class));
        Discos d = objectMapper.readValue(new File(json), Discos.class);
        logger.info(d.toString());
        saveDiscos(d);
        return new ModelAndView("list");
    }

    @RequestMapping(value="discos", method=RequestMethod.POST,consumes="application/json",produces="application/json")
    @ResponseBody
    public List<String> saveDiscoList(@RequestBody DiscosWrapper wrapper) {
        List<String> response = new ArrayList<>();
        for (Discos discos: wrapper.getDiscos()){
            discosService.save(discos);
            response.add("Discos salvos: " + discos.toString());
        }
        return response;
    }


}