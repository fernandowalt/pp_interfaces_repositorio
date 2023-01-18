package org.walter.poointerfaces.repositorio;

import org.walter.poointerfaces.modelo.Cliente;
import org.walter.poointerfaces.modelo.EntidadGenerica;
import org.walter.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import org.walter.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.walter.poointerfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatosException;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio<T extends EntidadGenerica> implements OrdenablePaginableCrudRepositorio<T> {

    protected final List<T> dataSource;

    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();

    }

    @Override
    public T porId(Integer id) throws LecturaAccesoDatoException {

        if (id == null || id <= 0) {
            throw new LecturaAccesoDatoException("El id debe ser mayor a 0 y no ses nulo");
        }

        T resultado = null;

        for (T cli : dataSource) {
            if (cli.getId() != null && cli.getId().equals(id)) {
                resultado = cli;
                break;
            }
        }

        if (resultado == null) {
            throw new LecturaAccesoDatoException("No exito el registro con el id: " + id);

        }
        return resultado;
    }

    @Override
    public List<T> listar() {
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
    public void insertar(T t) throws EscrituraAccesoDatoException {
        if (t == null) {
            throw new EscrituraAccesoDatoException("Error al insertar un objeto null ");
        }
        if (this.dataSource.contains(t)) {
            throw new RegistroDuplicadoAccesoDatosException("Error, el objeto con id: " + t.getId() + " ya existe en el repositorio");
        }

        dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException {
        dataSource.remove(this.porId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
