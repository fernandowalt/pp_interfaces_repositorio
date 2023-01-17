package org.walter.genericsclass;

public class Animal {
    private final String nombre;
    private final Tipo tipo;


    Animal(String nombre, Tipo tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo.toString();
    }
}
