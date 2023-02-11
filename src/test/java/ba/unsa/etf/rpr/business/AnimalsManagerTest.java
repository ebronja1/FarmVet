package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.domain.Animals;
import ba.unsa.etf.rpr.exceptions.FarmVetException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalsManagerTest {
    AnimalsManager animalsManager = new AnimalsManager();
    @Test
    void TestAddingWithId() {
        Animals animal = new Animals();
        animal.setName("Kiki");
        animal.setKind("Cat");
        animal.setId(1);
        assertThrows(FarmVetException.class, () -> {
           animalsManager.add(animal);
        });
    }
    @Test
    void TestAddingWithoutParams() {
        Animals animal = new Animals();
        assertThrows(FarmVetException.class, ()->{
           animalsManager.add(animal);
        });
    }
    @Test
    void TestAddingNewAnimal() {
        Animals animal =  new Animals();
        animal.setId(0);
        animal.setKind("rabbit");
        animal.setName("Zeko");
        boolean addingsuccessfull = false;
        try {
            animalsManager.add(animal);
            List<Animals> l = new ArrayList<>();
            l = animalsManager.getAll();
            for (Animals x: l) {
                if (x.getName().equals("Zeko")) {
                    addingsuccessfull = true;
                    animalsManager.delete(x.getId());
                    break;
                }
            }
        } catch (FarmVetException e) {
            throw new RuntimeException(e);
        }
        assertTrue(addingsuccessfull);
    }
    @Test
    void TestGetAllMethod() {
        assertDoesNotThrow(()-> {
            animalsManager.getAll();
        });
    }

}
