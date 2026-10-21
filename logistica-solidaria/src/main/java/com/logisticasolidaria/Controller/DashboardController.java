package com.logisticasolidaria.Controller;

import com.logisticasolidaria.Service.DoacaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final DoacaoService doacaoService;

    public DashboardController(DoacaoService doacaoService) {
        this.doacaoService = doacaoService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("nomeUsuario", "Mariana");
        model.addAttribute("totalDoacoes", doacaoService.listarTodas().size());
        model.addAttribute("pendentes", doacaoService.contarPorStatus("Pendente"));
        model.addAttribute("entregues", doacaoService.contarPorStatus("Entregue"));
        model.addAttribute("doacoesRecentes", doacaoService.listarRecentes(4));
        return "dashboard";
    }
}