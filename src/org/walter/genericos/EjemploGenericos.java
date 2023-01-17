package org.walter.genericos;

import org.walter.poointerfaces.modelo.Cliente;
import org.walter.poointerfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {

    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Andres", "Guzman"));

        Cliente andres = clientes.get(0);
        Cliente andres2 = clientes.iterator().next();

        Cliente[] clientesArreglo = {new Cliente("Andres", "Guzman"), new Cliente("Walter", "Santamaria"), new Cliente("Pier", "Laplace")};

        Integer[] enterosArreglo = {1, 2, 3};

        List<Cliente> clientesList = fromArrayToList(clientesArreglo);
        List<Integer> enterosList = fromArrayToList(enterosArreglo);

        clientesList.forEach(System.out::println);
        System.out.println("\n");
        enterosList.forEach(System.out::println);

        List<String> nombres = fromArrayToList(new String[]{"Fernando", "Pepe", "Jhon", "Maria"}, enterosArreglo);
        nombres.forEach(System.out::println);

        List<ClientePremium> clientesPremiumList = fromArrayToList(new ClientePremium[]{new ClientePremium("Paco", "Fernandez")});


        imprimirCientes(clientesPremiumList);


        System.out.println("Maximo de 1, 9 y 4 es: " + maximo(1, 9, 4));
        System.out.println("Maximo de 3.9, 11.6 y 4 11.5: " + maximo(3.9, 11.6, 11.5));
        System.out.println("Maximo de zanahoria, arandano y manzana es: " + maximo("zanahoria", "arandanos", "manzanas"));


    }


    public static <T> List<T> fromArrayToList(T[] c) {

        return Arrays.asList(c);
    }

    public static <T extends Number> List<T> fromArrayToList(T[] c) {

        return Arrays.asList(c);
    }


    public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] c) {

        return Arrays.asList(c);
    }


    public static <T, G> List<T> fromArrayToList(T[] c, G[] x) {

        for (G elemento : x) {
            System.out.println(elemento);
        }
        return Arrays.asList(c);


    }

    public static void imprimirCientes(List<? extends Cliente> clientes) {

        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;

        }
        if (c.compareTo(max) > 0) {
            max = c;

        }
        return max;
    }


}
