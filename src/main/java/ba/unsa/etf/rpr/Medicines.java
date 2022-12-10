package ba.unsa.etf.rpr;

import java.util.Objects;

public class Medicines {
    private int id;
    private String name;
    private Animals animals;
    private Vets vets;

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

    public Animals getAnimals() {
        return animals;
    }

    public void setAnimals(Animals animals) {
        this.animals = animals;
    }

    public Vets getVets() {
        return vets;
    }

    public void setVets(Vets vets) {
        this.vets = vets;
    }

    @Override
    public String toString() {
        return "Medicines{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", animals=" + animals +
                ", vets=" + vets +
                '}';
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
        return Objects.hash(id, name, animals, vets);
    }
}
