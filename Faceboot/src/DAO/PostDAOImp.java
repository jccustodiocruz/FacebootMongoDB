/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Comentario;
import Entidades.Post;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author juanc
 */
public class PostDAOImp implements PostDAO {

    private MongoCollection<Document> posts;

    public PostDAOImp(MongoCollection<Document> posts) {
        this.posts = posts;
    }

    @Override
    public List<Post> findAll() {
        List<Post> result = new ArrayList<>();
        for (Document d : posts.find()) {
            Post post = new Post();
            post.setUsuario(d.getString("Usuario"));
            post.setFecha(d.getDate("Fecha"));
            post.setContenido(d.getString("Contenido"));
            post.setTags(d.getList("Tags", String.class));
            post.setComentarios(d.getList("Comentarios", Comentario.class));
            result.add(post);
        }

        return result;
    }

    @Override
    public List<Post> findByTag(String tag) {
        List<Post> result = new ArrayList<>();
        for (Document d : posts.find(Filters.in("Tags", tag))) {
            Post post = new Post();
            post.setUsuario(d.getString("Usuario"));
            post.setFecha(d.getDate("Fecha"));
            post.setContenido(d.getString("Contenido"));
            post.setTags(d.getList("Tags", String.class));
            post.setComentarios(d.getList("Comentarios", Comentario.class));
            result.add(post);
        }

        return result;
    }

    @Override
    public void delete(Post post) {
        DeleteResult delete;
        delete = posts.deleteOne(Filters.eq("Contenido", post.getContenido()));
    }

    @Override
    public void add(Post post) {
        Document document = new Document()
                .append("Usuario", post.getUsuario())
                .append("Fecha", post.getFecha())
                .append("Contenido", post.getContenido())
                .append("Tags", post.getTags())
                .append("Comentarios", post.getComentarios());

        posts.insertOne(document);
    }

    @Override
    public Post findByContenido(String contenido) {
        Document d = posts.find(Filters.eq("Contenido", contenido)).first();
        Post post = new Post();
        post.setUsuario(d.getString("Usuario"));
        post.setFecha(d.getDate("Fecha"));
        post.setContenido(d.getString("Contenido"));
        post.setTags(d.getList("Tags", String.class));
        post.setComentarios(d.getList("Comentarios", Comentario.class));
        
        return post;
    }

    @Override
    public void agregarComentario(Post post, List<Comentario> comentarios) {
        UpdateResult update;
        update = posts.updateOne(Filters.eq("Contenido", post.getContenido()),
        Updates.addToSet("Comentarios", Arrays.asList(comentarios)));
    }

}
