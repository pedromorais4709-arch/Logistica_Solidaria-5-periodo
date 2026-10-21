package com.logisticasolidaria.Service;

import com.logisticasolidaria.Model.Doacao;
import com.logisticasolidaria.Repository.DoacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoacaoService {

    private final DoacaoRepository doacaoRepository;

    public DoacaoService(DoacaoRepository doacaoRepository) {
        this.doacaoRepository = doacaoRepository;
    }

    public List<Doacao> filtrar(String status, String categoria) {
        return doacaoRepository.findAll().stream()
                .filter(d -> status == null || status.isBlank() || status.equals(d.getStatus()))
                .filter(d -> categoria == null || categoria.isBlank() || categoria.equals(d.getCategoria()))
                .toList();
    }

    public Doacao adicionar(Doacao doacao) {
        return doacaoRepository.save(doacao);
    }

    public List<Doacao> listarTodas() {
        return doacaoRepository.findAll();
    }

    public long contarPorStatus(String status) {
        return doacaoRepository.findAll().stream()
                .filter(d -> status.equals(d.getStatus()))
                .count();
    }

    public List<Doacao> listarRecentes(int limite) {
        return doacaoRepository.findAll().stream()
                .sorted((a, b) -> b.getId().compareTo(a.getId()))
                .limit(limite)
                .toList();
    }
}