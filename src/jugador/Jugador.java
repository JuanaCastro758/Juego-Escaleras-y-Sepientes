/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugador;

import java.util.Random;

/**
 *
 * @author Chiko malo
 */
public class Jugador {
    private int id;
    private String nombre;
    private String apellido;
    private int partidasGanadas;
    private int partidasPerdidas;
    public Jugador(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.partidasGanadas=0;
        this.partidasPerdidas=0;
    }
    public Jugador() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getPartidasGanadas() {
        return partidasGanadas;
    }
    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }
    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }
    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }
    public int getDado(int i,int f){
        Random random=new Random();
        int x=random.nextInt(f-i+1)+i;
        return x;
    }
    @Override
    public String toString() {
        return "--id:" + id + "    nombre:" + nombre + "    apellido:" + apellido + "    partidasGanadas:" + partidasGanadas + "    partidasPerdidas:" + partidasPerdidas;
    }
    
}
