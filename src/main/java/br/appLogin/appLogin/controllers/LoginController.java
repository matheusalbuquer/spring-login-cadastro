package br.appLogin.appLogin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.appLogin.appLogin.model.Usuario;
import jakarta.validation.Valid;


@Controller
public class LoginController {

	private Usuario ur;
	
	@GetMapping("/login")
	public String Login() {
		return "login";
	}
	
	@GetMapping("/cadastroUsuario")
	public String cadastrar() {
		return "cadastro";
	}
	
	@RequestMapping(value = "/cadastroUsuario", method = RequestMethod.POST)
	public String cadastroUsuario(@Valid Usuario usuario, BindingResult result) {
		
		if(result.hasErrors()) {
			return "redirect:/cadastroUsuario";
		}else {
			
		}
		
		return null;
	}
	
}
