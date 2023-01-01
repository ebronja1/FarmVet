package ba.unsa.etf.rpr.domain;

import java.util.Objects;
/**
 * bean for Vets
 * @author Emir Bronja
 */
public class Vets implements Idable {
    private int id;
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vets vets = (Vets) o;
        return id == vets.id;
    }

    @Override
    public String toString() {
        return "Vets{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
