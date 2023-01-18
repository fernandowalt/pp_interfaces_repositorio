package org.walter.poointerfaces.repositorio;
import org.walter.poointerfaces.repositorio.excepciones.AccesoDatosException;
import org.walter.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import org.walter.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

public interface OrdenablePaginableCrudRepositorio<T> extends OrdenableRepositorio<T>, PaginableRepositorio<T>, CrudRepositorio<T>, ContableRepositorio {

    void eliminar(Integer id) throws AccesoDatosException;

    void insertar(T t) throws LecturaAccesoDatoException, EscrituraAccesoDatoException;
}
