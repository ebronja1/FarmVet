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
    private int animal_id;
    private int vet_id;
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
    public Date getTaked() {
        return taked;
    }
    public void setCreated(Date taked) {
        this.taked = taked;
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
        return Objects.hash(id, medicine, animal_id, vet_id, taked);
    }
}
