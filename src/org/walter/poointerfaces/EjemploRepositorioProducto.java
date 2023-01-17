package org.walter.poointerfaces;

import org.walter.poointerfaces.modelo.Producto;
import org.walter.poointerfaces.repositorio.AbstractaListRepositorio;
import org.walter.poointerfaces.repositorio.Direccion;
import org.walter.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {

        AbstractaListRepositorio<Producto> repo = new ProductoListRepositorio();
        repo.insertar(new Producto("Mesa", 2.58));
        repo.insertar(new Producto("Silla", 5.48));
        repo.insertar(new Producto("Casco", 6.3));
        repo.insertar(new Producto("Armario", 7.3));


        List<Producto> Productos = repo.listar();
        Productos.forEach(System.out::println);
        System.out.print("\n");

        List<Producto> paginable = repo.listar(0, 2);
        paginable.forEach(System.out::println);

        System.out.print("\n");

        Producto actualizado = new Producto("Lampara escritorio", 10.5);
        actualizado.setId(4);
        repo.editar(actualizado);

        System.out.println("\n================================\n");

        repo.listar().forEach(System.out::println);

        System.out.println("\n====================================\n");

        repo.eliminar(2);

        repo.listar().forEach(System.out::println);

        List<Producto> ascendente = repo.ordenar("precio", Direccion.DES);
        System.out.println("\n=======================================\n");

        ascendente.forEach(System.out::println);

        System.out.println("\n=======================================\n");

        System.out.println(repo.total());


    }

}
