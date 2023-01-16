package org.walter.poointerfaces.repositorio;

import org.walter.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio implements OrdenablePaginableCrudRepositorio {

    private final List<Cliente> dataSource;

    public ClienteListRepositorio() {
        this.dataSource = new ArrayList<>();

    }

    @Override
    public List<Cliente> listar() {
        return dataSource;
    }

    public static int orden(String atributo, Cliente a, Cliente b) {
        int resul = 0;
        switch (atributo) {
            case "id" -> resul = a.getId().compareTo(b.getId());
            case "nombre" -> resul = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> resul = a.getApellido().compareTo(b.getApellido());
        }
        return resul;
    }

    @Override
    public Cliente porId(Integer id) {

        Cliente resultado = null;

        for (Cliente cli : dataSource) {
            if (cli.getId() != null && cli.getId().equals(id)) {
                resultado = cli;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void insertarCliente(Cliente cliente) {
        dataSource.add(cliente);
    }

    @Override
    public void editarCliente(Cliente cliente) {
        Cliente cli = this.porId(cliente.getId());
        cli.setNombre(cliente.getNombre());
        cli.setApellido(cliente.getApellido());

    }

    @Override
    public void eliminarCliente(Integer id) {
        dataSource.remove(this.porId(id));
    }

    @Override
    public List<Cliente> ordenar(String atributo, Direccion dir) {

        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);

        listaOrdenada.sort(new Comparator<Cliente>() {
            @Override
            public int compare(Cliente a, Cliente b) {

                int resultado = 0;

                if (dir == Direccion.ASC) {
                    resultado = orden(atributo, a, b);
                } else if (dir == Direccion.DES) {
                    resultado = orden(atributo, b, a);
                }
                return resultado;
            }

        });
        return listaOrdenada;
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
