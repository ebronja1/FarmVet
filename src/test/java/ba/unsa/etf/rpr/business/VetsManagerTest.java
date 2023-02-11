package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.domain.Animals;
import ba.unsa.etf.rpr.domain.Vets;
import ba.unsa.etf.rpr.exceptions.FarmVetException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class VetsManagerTest {
    VetsManager vetsManager = new VetsManager();

    @Test
    void TestAddingVetWithId() {
        Vets vet = new Vets();
        vet.setName("Hamo Hamic");
        vet.setUsername("Hamo");
        vet.setPassword("111");
        vet.setId(1);
        assertThrows(FarmVetException.class, () -> {
            vetsManager.add(vet);
        });
    }
}
