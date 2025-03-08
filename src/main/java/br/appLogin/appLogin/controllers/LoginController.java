package br.appLogin.appLogin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

	@GetMapping("/login")
	public String Login() {
		return "/login";
	}
	
	@GetMapping("/cadastroUsuario")
	public String cadastrar() {
		return "/cadastro";
	}
	
}
