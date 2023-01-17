package org.walter.poointerfaces.repositorio;

import org.walter.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio<T> {
    List<T> ordenar(String atributo, Direccion dir);
}
