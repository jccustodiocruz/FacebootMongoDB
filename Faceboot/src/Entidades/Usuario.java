/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author juanc
 */
public class Usuario {
    
    String username;
    String password;
    String name;
    int edad;
    String sexo;
    Date fechaNacimiento;
    List<String> gustosMusicales = new ArrayList<>();
    List<String> gustosPeliculas = new ArrayList<>();
    List<Post> comentarios = new ArrayList<>();

    public Usuario() {
    }
    
    public Usuario(String username, String password, String name, int edad, String sexo, Date fechaNacimiento, List<String> gustosMusicales, List<String> gustosPeliculas) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.edad = edad;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.gustosMusicales = gustosMusicales;
        this.gustosPeliculas = gustosPeliculas;
    }

    

    public List<String> getGustosMusicales() {
        return gustosMusicales;
    }

    public void setGustosMusicales(List<String> gustosMusicales) {
        this.gustosMusicales = gustosMusicales;
    }

    public List<String> getGustosPeliculas() {
        return gustosPeliculas;
    }

    public void setGustosPeliculas(List<String> gustosPeliculas) {
        this.gustosPeliculas = gustosPeliculas;
    }        

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Post> comentarios) {
        this.comentarios = comentarios;
    }
    
    
}
