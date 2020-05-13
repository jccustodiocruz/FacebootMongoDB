/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Comentario;
import Entidades.Post;
import java.util.List;

/**
 *
 * @author juanc
 */
public interface PostDAO {
    
    List<Post> findAll();
    List<Post> findByTag(String tag);
    Post findByContenido(String contenido);
    void add(Post post);
    void delete(Post post);
    void agregarComentario(Post post, List<Comentario> comentarios);
}
