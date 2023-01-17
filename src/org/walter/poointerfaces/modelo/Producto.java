package org.walter.poointerfaces.modelo;

public class Producto extends EntidadGenerica {
    private String descripcion;
    private Double precio;

    public Producto(String desc, double prc) {
        super();
        this.descripcion = desc;
        this.precio = prc;

    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;

    }

    @Override
    public String toString() {
        return "descripción= " + descripcion + '\'' +
                " precio=" + precio +
                " id=" + id;
    }
}
