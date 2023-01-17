package org.walter.poointerfaces.repositorio;

import org.walter.poointerfaces.modelo.Cliente;

import java.util.Iterator;
import java.util.List;

public interface CrudRepositorio<T> {

    List<T> listar();

    T porId(Integer id);

    void insertar(T cliente);

    void editar(T cliente);

    void eliminar(Integer id);


}
