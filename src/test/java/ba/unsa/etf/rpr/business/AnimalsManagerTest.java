package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.domain.Animals;
import ba.unsa.etf.rpr.exceptions.FarmVetException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
