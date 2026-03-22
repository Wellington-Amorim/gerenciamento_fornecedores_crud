package com.as.gerenciamento_fornecedores.services;

import com.as.gerenciamento_fornecedores.models.FornecedorModel;
import com.as.gerenciamento_fornecedores.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    public FornecedorRepository fornecedorRepository;

    public List<FornecedorModel> listar() {
        return fornecedorRepository.findAll();
    }

    public FornecedorModel criar(FornecedorModel fornecedorModel) {
        return fornecedorRepository.save(fornecedorModel);
    }

    public Optional<FornecedorModel> buscarId(Long id) {
        return fornecedorRepository.findById(id);
    }

    public FornecedorModel atualizar(Long id, FornecedorModel fornecedorModel) {
        FornecedorModel model = fornecedorRepository.findById(id).get();
        model.setNomeFantasia(fornecedorModel.getNomeFantasia());
        model.setCnpj(fornecedorModel.getCnpj());
        model.setContato(fornecedorModel.getContato());
        return fornecedorRepository.save(model);
    }

    public void deletar(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
