package org.walter.poointerfaces.repositorio;
import org.walter.poointerfaces.repositorio.excepciones.AccesoDatosException;

import java.util.List;

public interface CrudRepositorio<T>  {

    List<T> listar();

    T porId(Integer id) throws AccesoDatosException;

    void insertar(T t) throws AccesoDatosException;

    void editar(T t) throws AccesoDatosException;

    void eliminar(Integer id) throws AccesoDatosException;


}
