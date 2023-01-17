package org.walter.poointerfaces.modelo;

import java.util.Objects;

public class EntidadGenerica {

    protected Integer id;
    private static int ultimoId;

    public EntidadGenerica() {
        this.id = ++ultimoId;

    }
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntidadGenerica base = (EntidadGenerica) o;
        return Objects.equals(id, base.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
