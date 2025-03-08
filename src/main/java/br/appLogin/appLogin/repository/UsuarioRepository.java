package br.appLogin.appLogin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.appLogin.appLogin.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Optional findById(Long id);
	
	@Query(value = "select * from applogin.usuario where email = :email and senha = :senha ", nativeQuery = true)
	public Usuario login (String email, String senha);
}

