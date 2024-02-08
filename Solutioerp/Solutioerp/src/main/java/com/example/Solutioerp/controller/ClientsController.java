package com.example.Solutioerp.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Solutioerp.model.Clients;
import com.example.Solutioerp.services.ClientsService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/clientes")
public class ClientsController {

    @Autowired
    private ClientsService clientsService; 
    
    @GetMapping
    public List<Clients> obterTodos() {
        return clientsService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Clients> obterPorId(@PathVariable Integer id){
        return clientsService.obterPorId(id);
    }

    @PostMapping
    public Clients adicionar(@RequestBody Clients clients) {
        if("Fisica".equals(clients.getTypeClient())) {
            clients.setTaxIdentificationNumber(clients.getCpf());
        } else if ("Juridica".equals(clients.getTypeClient())) {
            clients.setTaxIdentificationNumber(clients.getCnpj());
        }
        
        return clientsService.adicionar(clients);
    }
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
        clientsService.deletar(id);
        return "Cliente com id:" + id +" foi removido!";
    }

    @PutMapping("/{id}")
    public Clients atualizar(@RequestBody Clients clients, @PathVariable Integer id) {      
        return clientsService.atualizar(id, clients);
    }
        


}
