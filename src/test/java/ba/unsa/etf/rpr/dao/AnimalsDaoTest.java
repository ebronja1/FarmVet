package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.business.AnimalsManager;
import ba.unsa.etf.rpr.domain.Animals;
import ba.unsa.etf.rpr.exceptions.FarmVetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class AnimalsDaoTest {

    private AnimalsManager animalsManager;
    @Mock
    private AnimalsDao animalsDao;

    public Animals animal = new Animals(0, "Fifi", "dog");


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        animalsManager = new AnimalsManager();
    }
    @Test
    public void addTest() throws FarmVetException {
        animalsDao.add(animal);
        verify(animalsDao).add(animal);
    }
    @Test
    void updateTest() throws Exception {
        animal.setName("Mocky the dog");
        animalsDao.update(animal);
        verify(animalsDao).update(animal);
    }
}
