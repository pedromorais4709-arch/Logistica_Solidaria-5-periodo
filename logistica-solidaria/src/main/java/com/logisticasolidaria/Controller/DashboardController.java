package com.logisticasolidaria.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.logisticasolidaria.Service.DoacaoService;
import org.springframework.ui.Model;

@Controller 
public class DashboardController {
    @Autowired 
    private DoacaoService doacaoService;

    @GetMapping ("/dashboard")
    public String dashboard(Model model) {
                model.addAttribute("nomeUsuario", "Mariana");
        model.addAttribute("totalDoacoes", doacaoService.listarTodas().size());
        model.addAttribute("pendentes", doacaoService.contarPorStatus("Pendente"));
        model.addAttribute("entregues", doacaoService.contarPorStatus("Entregue"));
        model.addAttribute("doacoesRecentes", doacaoService.listarTodas());
        return "dashboard";
    }

}
