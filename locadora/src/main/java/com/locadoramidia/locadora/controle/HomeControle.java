package com.locadoramidia.locadora.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author João Pedro
 */

@Controller
public class HomeControle {
    
    @GetMapping("/")
    public String home(){
        return "index";
    }
}
