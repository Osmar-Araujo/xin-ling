package br.com.xingling.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {
	
	@GetMapping("/adm")
	public String acessarPrincipal() {
		return "adm/index";
	}
}
