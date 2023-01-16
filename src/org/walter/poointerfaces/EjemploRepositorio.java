package org.walter.poointerfaces;

import org.walter.poointerfaces.modelo.Cliente;
import org.walter.poointerfaces.repositorio.ClienteListRepositorio;
import org.walter.poointerfaces.repositorio.CrudRepositorio;
import org.walter.poointerfaces.repositorio.Direccion;
import org.walter.poointerfaces.repositorio.PaginableRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        ClienteListRepositorio repo = new ClienteListRepositorio();
        repo.insertarCliente(new Cliente("braulio", "Gomez"));
        repo.insertarCliente(new Cliente("nicolas", "Lopez"));
        repo.insertarCliente(new Cliente("fernando", "Santamaria"));
        repo.insertarCliente(new Cliente("xisto", "Pinzon"));


        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);

        System.out.print("\n");

        List<Cliente> paginable = repo.listar(0, 2);
        paginable.forEach(System.out::println);

        System.out.print("\n");

        Cliente xistoActualizado = new Cliente("walter", "pinzon");
        xistoActualizado.setId(4);
        repo.editarCliente(xistoActualizado);

        System.out.println("\n================================\n");

        repo.listar().forEach(System.out::println);

        System.out.println("\n====================================\n");

        repo.eliminarCliente(4);

        repo.listar().forEach(System.out::println);

        List<Cliente> ascendente = repo.ordenar("nombre", Direccion.DES);
        System.out.println("\n=======================================\n");

        ascendente.forEach(System.out::println);

        System.out.println("\n=======================================\n");

        System.out.println(repo.total());


    }

}
