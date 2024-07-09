package com.example.pacotedeviagem.services;

import com.example.pacotedeviagem.entities.Venda;
import com.example.pacotedeviagem.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {
    @Autowired
    private VendaRepository repository;

    public List<Venda> findAll(){
        return repository.findAll();
    }

    public Optional<Venda> findById(Long id){
        return repository.findById(id);
    }

    public Venda insert(Venda obj){
        return repository.save(obj);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Venda update(Long id, Venda obj) {
        Venda entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    public void updateData(Venda entity, Venda obj) {
        entity.setNomeCliente(obj.getNomeCliente());
        entity.setFormaPagamento(obj.getFormaPagamento());
        entity.setDataVenda(obj.getDataVenda());
    }
}
