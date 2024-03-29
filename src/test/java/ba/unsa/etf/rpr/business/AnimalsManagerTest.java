// all tests pass, but here the tests are connected to the database, so I won't consider these,
// because when downloading the dump database, it won't have all the data as with the current state of my database.
/*
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
    void TestAddingAnimalWithId() {
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
        assertThrows(FarmVetException.class, () -> {
            animalsManager.add(animal);
        });
    }

    @Test
    void TestAddingNewAnimal() {
        Animals animal = new Animals();
        animal.setId(0);
        animal.setKind("rabbit");
        animal.setName("Zeko");
        boolean addingsuccessfull = false;
        try {
            animalsManager.add(animal);
            List<Animals> l = new ArrayList<>();
            l = animalsManager.getAll();
            for (Animals x : l) {
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
        assertDoesNotThrow(() -> {
            animalsManager.getAll();
        });
    }

    @Test
    void TestDeleteMethod() {
        Animals animal = new Animals();
        animal.setId(0);
        animal.setKind("rabbit");
        animal.setName("Zeko");
        boolean deletesuccessfull = true;
        try {
            animalsManager.add(animal);
            List<Animals> l = new ArrayList<>();
            l = animalsManager.getAll();
            for (Animals x : l) {
                if (x.getName().equals("Zeko")) {
                    animalsManager.delete(x.getId());
                    break;
                }
            }
            l = animalsManager.getAll();
            for (Animals x : l) {
                if (x.getName().equals("Zeko")) {
                    deletesuccessfull = false;
                    break;
                }
            }
        } catch (FarmVetException e) {
            throw new RuntimeException(e);
        }

        assertTrue(deletesuccessfull);
    }

    @Test
    void TestOfValidateAnimalsName() {
        assertThrows(FarmVetException.class, () -> {
            animalsManager.validateAnimalsName("Po");
        });
    }

    @Test
    void TestSearchByName() {
        Animals animal = new Animals();
        animal.setId(0);
        animal.setKind("rabbit");
        animal.setName("Zeko");
        boolean searchsuccessfull = true;
        try {
            animalsManager.add(animal);
            List<Animals> l = new ArrayList<>();
            l = animalsManager.searchByName("Zeko");
            if (l.isEmpty()) searchsuccessfull = false;
            animalsManager.delete(l.get(0).getId());
        } catch (FarmVetException e) {
            throw new RuntimeException(e);
        }
        assertTrue(searchsuccessfull);
    }
}
*/