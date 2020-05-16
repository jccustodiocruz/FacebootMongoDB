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

    private static Document fromPtoD(Post p) {
        Document d = new Document()
                .append("Usuario", p.getUsuario())
                .append("Fecha", p.getFecha())
                .append("Contenido", p.getContenido())
                .append("Tags", p.getTags())
                .append("Comentarios", p.getComentarios());

        return d;
    }

    private static Document fromCtoD(Comentario c) {
        Document d = new Document()
                .append("Usuario", c.getUsuario())
                .append("Fecha", c.getFecha())
                .append("Contenido", c.getContenido());
        return d;
    }

    private static Post fromDtoP(Document d) {
        Post post = new Post();        

        post.setUsuario(d.getString("Usuario"));
        post.setFecha(d.getDate("Fecha"));
        post.setContenido(d.getString("Contenido"));
        post.setTags(d.getList("Tags", String.class));
        post.setComentarios(d.getList("Comentarios", Comentario.class));
        return post;
    }

    @Override
    public List<Post> findAll() {
        List<Post> result = new ArrayList<>();
        for (Document d : posts.find()) {
            result.add(fromDtoP(d));
        }
        return result;
    }

    @Override
    public List<Post> findByTag(String tag) {
        List<Post> result = new ArrayList<>();
        for (Document d : posts.find(Filters.in("Tags", tag))) {
            result.add(fromDtoP(d));
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
        posts.insertOne(fromPtoD(post));
    }

    @Override
    public Post findByContenido(String contenido) {
        Document d = posts.find(Filters.eq("Contenido", contenido)).first();
        Post post = fromDtoP(d);
        return post;
    }

    @Override
    public void agregarComentario(Post post, List<Comentario> c) {
        List<Document> comentarios = new ArrayList<>();

        for (Comentario c1 : c) {
            comentarios.add(fromCtoD(c1));
        }

        UpdateResult update;
        update = posts.updateOne(Filters.eq("Contenido", post.getContenido()),
                Updates.set("Comentarios", comentarios));
    }

}
