package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Animals;
import ba.unsa.etf.rpr.exceptions.FarmVetException;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AnimalsDaoSQLImpl extends AbstractDao<Animals> implements AnimalsDao {
    public AnimalsDaoSQLImpl() {
        super("animals");
    }

    @Override
    public Animals row2object(ResultSet rs) throws FarmVetException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(Animals object) {
        return null;
    }
}
