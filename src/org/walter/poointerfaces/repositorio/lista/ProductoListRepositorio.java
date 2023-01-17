package org.walter.poointerfaces.repositorio.lista;
import org.walter.poointerfaces.modelo.Producto;
import org.walter.poointerfaces.repositorio.AbstractaListRepositorio;
import org.walter.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractaListRepositorio<Producto> {


    @Override
    public void editar(Producto producto) {
        Producto p = porId(producto.getId());

        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> ordenar(String atributo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource);

        listaOrdenada.sort((a, b) -> {
            int resultado = 0;

            if (dir == Direccion.ASC) {
                resultado = orden(atributo, a, b);
            } else if (dir == Direccion.DES) {
                resultado = orden(atributo, b, a);
            }
            return resultado;
        });
        return listaOrdenada;
    }

    @Override
    public List<Producto> listar() {
        return dataSource;
    }

    public static int orden(String atributo, Producto a, Producto b) {
        int resul = 0;
        switch (atributo) {
            case "id" -> resul = a.getId().compareTo(b.getId());
            case "descripcion" -> resul = a.getDescripcion().compareTo(b.getDescripcion());
            case "precio" -> resul = a.getPrecio().compareTo(b.getPrecio());
        }
        return resul;
    }
}

