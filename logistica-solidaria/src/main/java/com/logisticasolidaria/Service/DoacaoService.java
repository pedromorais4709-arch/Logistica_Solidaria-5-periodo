package com.logisticasolidaria.Service;

import org.springframework.stereotype.Service;
import com.logisticasolidaria.Model.Doacao;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoacaoService {
      private final List<Doacao> doacoes = new ArrayList<>();

    public DoacaoService() {
        doacoes.add(new Doacao("DOA-1025", "Cesta básica", "Alimentos", "Maceió - AL",
                "Entregue", "Alimentos essenciais para famílias.", "20 unidades", "08/09/2026"));
        doacoes.add(new Doacao("DOA-1024", "Roupas infantis", "Vestuário", "Rio Largo - AL",
                "Em transporte", "Peças em bom estado para crianças.", "35 peças", "07/09/2026"));
        doacoes.add(new Doacao("DOA-1023", "Material escolar", "Educação", "Maceió - AL",
                "Pendente", "Cadernos, lápis e mochilas para estudantes.", "50 kits", "06/09/2026"));
        doacoes.add(new Doacao("DOA-1022", "Kit higiene", "Higiene", "Satuba - AL",
                "Entregue", "Itens básicos de higiene pessoal.", "30 kits", "05/09/2026"));
        doacoes.add(new Doacao("DOA-1021", "Cobertores", "Vestuário", "Marechal Deodoro - AL",
                "Em transporte", "Cobertores para famílias em situação vulnerável.", "18 unidades", "04/09/2026"));
        doacoes.add(new Doacao("DOA-1020", "Alimentos não perecíveis", "Alimentos", "Maceió - AL",
                "Pendente", "Arroz, feijão, massas e outros alimentos.", "40 cestas", "03/09/2026"));
    }

    public List<Doacao> listarTodas() {
        return doacoes;
    }

    public List<Doacao> filtrar(String status, String categoria) {
        return doacoes.stream()
                .filter(d -> status == null || status.isEmpty() || d.getStatus().equals(status))
                .filter(d -> categoria == null || categoria.isEmpty() || d.getCategoria().equals(categoria))
                .toList();
    }

    public Doacao buscarPorId(String id) {
        return doacoes.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    public void adicionar(Doacao doacao) {
        doacoes.add(doacao);
    }

    public long contarPorStatus(String status) {
        return doacoes.stream().filter(d -> d.getStatus().equals(status)).count();
    }
}
