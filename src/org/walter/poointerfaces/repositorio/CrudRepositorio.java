package org.walter.poointerfaces.repositorio;

import org.walter.poointerfaces.modelo.Cliente;

import java.util.Iterator;
import java.util.List;

public interface CrudRepositorio {

    List<Cliente> listar();

    Cliente porId(Integer id);

    void insertarCliente(Cliente cliente);

    void editarCliente(Cliente cliente);

    void eliminarCliente(Integer id);


}
