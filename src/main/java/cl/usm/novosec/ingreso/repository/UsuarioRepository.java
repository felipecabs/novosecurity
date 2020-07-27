package cl.usm.novosec.ingreso.repository;

import org.springframework.data.repository.CrudRepository;

import cl.usm.novosec.ingreso.dao.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

}
