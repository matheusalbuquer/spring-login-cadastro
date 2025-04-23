package br.appLogin.appLogin.controllers;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.appLogin.appLogin.model.Usuario;
import br.appLogin.appLogin.repository.UsuarioRepository;
import br.appLogin.appLogin.services.CookieService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;


@Controller
public class LoginController {

	@Autowired
	private UsuarioRepository ur;
	
	@GetMapping("/login")
	public String Login() {
		
		return "login";
	}
	
	@GetMapping("/")
	public String dashboard(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		model.addAttribute("nome",CookieService.getCookie(request, "nomeUsuario"));
		return "index";
	}
	
	public String logout


	@PostMapping("/logar")
	public String loginUsuario(Usuario usuario, Model model, HttpServletResponse response) throws UnsupportedEncodingException {
	    Usuario usuarioLogado = this.ur.login(usuario.getEmail(), usuario.getSenha());

	    if (usuarioLogado != null) {
	        CookieService.setCookie(response, "usuarioId", String.valueOf(usuarioLogado.getId()), 10000);
	        CookieService.setCookie(response, "nomeUsuario", usuarioLogado.getNome(), 10000);
	        return "redirect:/";
	    }

	    model.addAttribute("erro", "Usuário inválido");
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
		}
			ur.save(usuario);
		
			
		return "redirect:/login";
	}
	
	
}
