package com.logisticasolidaria.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/rastreamento")
public class RastreamentoController {
    
    @GetMapping("/rastreamento")
    public String rastreamento() {
        return "rastreamento";
    }
}
