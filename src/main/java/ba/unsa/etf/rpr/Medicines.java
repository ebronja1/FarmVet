package ba.unsa.etf.rpr;

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
}
