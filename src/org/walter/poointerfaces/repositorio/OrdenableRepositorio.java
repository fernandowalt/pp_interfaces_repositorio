package org.walter.poointerfaces.repositorio;

import org.walter.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio {
    List<Cliente> ordenar(String atributo, Direccion dir);
}
