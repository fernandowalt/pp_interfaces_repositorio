package org.walter.poointerfaces;

import org.walter.poointerfaces.modelo.Cliente;
import org.walter.poointerfaces.repositorio.AbstractaListRepositorio;
import org.walter.poointerfaces.repositorio.lista.ClienteListRepositorio;
import org.walter.poointerfaces.repositorio.Direccion;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        AbstractaListRepositorio<Cliente> repo = new ClienteListRepositorio();
        repo.insertar(new Cliente("braulio", "Gomez"));
        repo.insertar(new Cliente("nicolas", "Lopez"));
        repo.insertar(new Cliente("fernando", "Santamaria"));
        repo.insertar(new Cliente("xisto", "Pinzon"));


        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);

        System.out.print("\n");

        List<Cliente> paginable = repo.listar(0, 2);
        paginable.forEach(System.out::println);

        System.out.print("\n");

        Cliente xistoActualizado = new Cliente("walter", "pinzon");
        xistoActualizado.setId(4);
        repo.editar(xistoActualizado);

        System.out.println("\n================================\n");

        repo.listar().forEach(System.out::println);

        System.out.println("\n====================================\n");

        repo.eliminar(4);

        repo.listar().forEach(System.out::println);

        List<Cliente> ascendente = repo.ordenar("nombre", Direccion.DES);
        System.out.println("\n=======================================\n");

        ascendente.forEach(System.out::println);

        System.out.println("\n=======================================\n");

        System.out.println(repo.total());


    }

}
