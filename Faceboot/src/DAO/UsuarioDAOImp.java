/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Usuario;
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
public class UsuarioDAOImp implements UsuarioDAO {

    private MongoCollection<Document> users;

    public UsuarioDAOImp(MongoCollection<Document> users) {
        this.users = users;
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> result = new ArrayList<>();
        for (Document d : users.find()) {
            Usuario user = new Usuario();
            user.setName(d.getString("Nombre"));
            user.setUsername(d.getString("Username"));
            user.setPassword(d.getString("Password"));
            user.setEdad(d.getInteger("Edad"));
            user.setSexo(d.getString("Sexo"));
            user.setFechaNacimiento(d.getDate("Fecha Nacimiento"));
            user.setGustosMusicales(d.getList("Generos Musicales", String.class));
            user.setGustosPeliculas(d.getList("Generos de Pelicula", String.class));
            result.add(user);
        }
        return result;
    }

    @Override
    public Usuario findByUsername(String username) {
        Document d = users.find(Filters.eq("Username", username)).first();
        Usuario user = new Usuario();
        user.setName(d.getString("Nombre"));
        user.setUsername(d.getString("Username"));
        user.setPassword(d.getString("Password"));
        user.setEdad(d.getInteger("Edad"));
        user.setSexo(d.getString("Sexo"));
        user.setFechaNacimiento(d.getDate("Fecha Nacimiento"));
        user.setGustosMusicales(d.getList("Generos Musicales", String.class));
        user.setGustosPeliculas(d.getList("Generos de Pelicula", String.class));

        return user;
    }

    @Override
    public void add(Usuario usuario) {
        Document document = new Document()
                .append("Nombre", usuario.getName())
                .append("Username", usuario.getUsername())
                .append("Password", usuario.getPassword())
                .append("Edad", usuario.getEdad())
                .append("Sexo", usuario.getSexo())
                .append("Fecha Nacimiento", usuario.getFechaNacimiento())
                .append("Generos Musicales", usuario.getGustosMusicales())
                .append("Generos de Pelicula", usuario.getGustosPeliculas());

        users.insertOne(document);
    }

    @Override
    public void delete(Usuario usuario) {
        DeleteResult delete;
        delete = users.deleteOne(Filters.eq("Username", usuario.getUsername()));
    }

    @Override
    public void update(Usuario usuario) {
        UpdateResult update;
        update = users.updateOne(
                Filters.eq("Username", usuario.getUsername()),
                Updates.set("Nombre", usuario.getName()));
        update = users.updateOne(
                Filters.eq("Username", usuario.getUsername()),
                Updates.set("Password", usuario.getPassword()));
        update = users.updateOne(
                Filters.eq("Username", usuario.getUsername()),
                Updates.set("Generos Musicales", usuario.getGustosMusicales()));
        update = users.updateOne(
                Filters.eq("Username", usuario.getUsername()),
                Updates.set("Generos de Pelicula", usuario.getGustosPeliculas()));

    }
}
