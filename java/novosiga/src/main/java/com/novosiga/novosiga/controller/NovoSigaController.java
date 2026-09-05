package com.novosiga.novosiga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/novosiga")
public class NovoSigaController {

    @GetMapping
    public String index(Model model) {
        return "index";
    }    
}
