package org.walter.poointerfaces.repositorio;
import org.walter.poointerfaces.modelo.Cliente;
import org.walter.poointerfaces.modelo.EntidadGenerica;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio <T extends EntidadGenerica> implements OrdenablePaginableCrudRepositorio<T> {

    protected final List<T> dataSource;

    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();

    }
    @Override
    public T porId(Integer id) {

        T resultado = null;

        for (T cli : dataSource) {
            if (cli.getId() != null && cli.getId().equals(id)) {
                resultado = cli;
                break;
            }
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
    public void insertar(T t) {
        dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) {
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
