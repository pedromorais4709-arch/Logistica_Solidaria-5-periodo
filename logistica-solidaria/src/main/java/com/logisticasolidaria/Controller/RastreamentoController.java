package com.logisticasolidaria.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rastreamento")
public class RastreamentoController {
    
    @GetMapping("/rastreamento")
    public String rastreamento() {
        return "rastreamento";
    }
}
