package br.appLogin.appLogin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.appLogin.appLogin.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {

}
