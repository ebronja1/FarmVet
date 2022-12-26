package ba.unsa.etf.rpr.domain;

import java.util.Objects;
/**
 * bean for Medicines
 * @author Emir Bronja
 */
public class Medicines {
    private int id;
    private String name;
    private int animal_id;
    private int vet_id;

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
    public String toString() {
        return "Medicines{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", animal_id=" + animal_id +
                ", vet_id=" + vet_id +
                '}';
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }

    public int getVet_id() {
        return vet_id;
    }

    public void setVet_id(int vet_id) {
        this.vet_id = vet_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicines medicines = (Medicines) o;
        return id == medicines.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, animal_id, vet_id);
    }
}
