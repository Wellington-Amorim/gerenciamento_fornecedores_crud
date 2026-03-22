package com.as.gerenciamento_fornecedores.controllers;

import com.as.gerenciamento_fornecedores.models.FornecedorModel;
import com.as.gerenciamento_fornecedores.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService  fornecedorService;

    @PostMapping
    public ResponseEntity<FornecedorModel> criar(@RequestBody FornecedorModel fornecedorModel){
        FornecedorModel fornecedor = fornecedorService.criar(fornecedorModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(fornecedorModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(fornecedor);
    }

    @GetMapping
    public ResponseEntity<List<FornecedorModel>> listar() {
        List<FornecedorModel> fornecedors = fornecedorService.listar();
        return ResponseEntity.ok().body(fornecedors);
    }

    @GetMapping("/{id}")
    public Optional<FornecedorModel> buscarId(@PathVariable Long id) {
        return fornecedorService.buscarId(id);
    }

    @PutMapping("/{id}")
    public FornecedorModel atualizar(@PathVariable Long id, @RequestBody FornecedorModel fornecedorModel) {
        return fornecedorService.atualizar(id, fornecedorModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        fornecedorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
