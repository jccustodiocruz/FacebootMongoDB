/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Usuario;
import java.util.List;

/**
 *
 * @author juanc
 */
public interface UsuarioDAO {
    
    List<Usuario> findAll();
    Usuario findByUsername(String username);
    void add(Usuario usuario);
    void update(Usuario usuario);
    void delete(Usuario usuario);
}
