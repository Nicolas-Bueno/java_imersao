package br.com.alura.linguagens.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {
    
    @Autowired
    private LinguagemRepository repositorio;
           

    @GetMapping(value="/linguagens-mais-usadas-em-2022")
    public List<Linguagem> processa() {
        List<Linguagem> linguagens = repositorio.findAll();
        return linguagens;
    }


}
