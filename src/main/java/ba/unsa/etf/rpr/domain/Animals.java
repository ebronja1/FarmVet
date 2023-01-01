package ba.unsa.etf.rpr.domain;

import java.util.Objects;
/**
 * bean for Animals
 * @author Emir Bronja
 */
public class Animals implements Idable{
    private int id;
    private String name;
    private String kind;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animals = (Animals) o;
        return id == animals.id;
    }

    @Override
    public String toString() {
        return name;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, kind);
    }
}
