package ba.unsa.etf.rpr.domain;

import java.util.Date;
import java.util.Objects;
/**
 * bean for Medicines
 * @author Emir Bronja
 */
public class Medicines implements Idable{
    private int id;
    private String medicine;
    private Animals animal;
    private Vets vet;
    private Date taked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }



    public Animals getAnimal() {
        return animal;
    }

    public void setAnimal(Animals animal) {
        this.animal = animal;
    }

    public Vets getVet() {
        return vet;
    }

    public void setVet(Vets vet) {
        this.vet = vet;
    }
    public Date getTaked() {
        return taked;
    }
    public void setTaked(Date taked) {
        this.taked = taked;
    }
    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", medicine='" + medicine + '\'' +
                ", animal=" + animal +
                ", vet=" + vet +
                ", taked=" + taked +
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
        return Objects.hash(id, medicine, animal, vet, taked);
    }
}
