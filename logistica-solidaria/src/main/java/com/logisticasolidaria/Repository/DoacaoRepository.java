package com.logisticasolidaria.Repository;

import com.logisticasolidaria.Model.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoacaoRepository extends JpaRepository<Doacao, Long> {
}