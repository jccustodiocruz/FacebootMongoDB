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

    private static Comentario fromDtoC(Document d) {
        Comentario comentario = new Comentario();
        comentario.setUsuario(d.getString("Usuario"));
        comentario.setFecha(d.getDate("Fecha"));
        comentario.setContenido(d.getString("Contenido"));

        return comentario;
    }

    private static Document fromPtoD(Post p) {
        List<Document> comentarios = new ArrayList<>();
        List<Comentario> c = p.getComentarios();

        if (c != null) {
            for (Comentario c1 : c) {
                comentarios.add(fromCtoD(c1));
            }
        }

        Document d = new Document()
                .append("Usuario", p.getUsuario())
                .append("Fecha", p.getFecha())
                .append("Contenido", p.getContenido())
                .append("Tags", p.getTags())
                .append("Comentarios", comentarios);

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

        List<Comentario> comentario = new ArrayList<>();
        List<Document> doc = d.getList("Comentarios", Document.class);

        if (doc != null) {
            for (int i = 0; i < doc.size(); i++) {
                comentario.add(fromDtoC(doc.get(i)));
            }
        }

        post.setUsuario(d.getString("Usuario"));
        post.setFecha(d.getDate("Fecha"));
        post.setContenido(d.getString("Contenido"));
        post.setTags(d.getList("Tags", String.class));
        post.setComentarios(comentario);
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
