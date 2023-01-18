package org.walter.poointerfaces.repositorio.lista;

import org.walter.poointerfaces.modelo.Cliente;
import org.walter.poointerfaces.repositorio.AbstractaListRepositorio;
import org.walter.poointerfaces.repositorio.Direccion;
import org.walter.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;

import java.util.List;

public  class ClienteListRepositorio  extends AbstractaListRepositorio<Cliente> {

    @Override
    public void editar(Cliente cliente) throws LecturaAccesoDatoException {
        Cliente cli = this.porId(cliente.getId());
        cli.setNombre(cliente.getNombre());
        cli.setApellido(cliente.getApellido());

    }

    @Override
    public List<Cliente> ordenar(String atributo, Direccion dir) {

        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);

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


}


