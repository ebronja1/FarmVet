package ba.unsa.etf.rpr;
import ba.unsa.etf.rpr.business.AnimalsManager;
import ba.unsa.etf.rpr.business.MedicinesManager;
import ba.unsa.etf.rpr.domain.Animals;
import ba.unsa.etf.rpr.domain.Medicines;
import ba.unsa.etf.rpr.domain.Vets;
import net.bytebuddy.asm.Advice;
import org.apache.commons.cli.*;
import java.sql.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author Emir Bronja
 * CLI (Command Line Interface) implementation in following class
 * Even though this type of presentation layer (called CLI) is becoming past tense for GUI apps
 * it's good to see how you can manipulate data through command line and database also
 *
 */
public class App {

    private static final Option addMedcine = new Option("m","add-medicine",false, "Adding new medicine to FarmVet database");
    private static final Option addAnimal = new Option("a","add-animal",false, "Adding new animal to FarmVet database");
    private static final Option getMedicines = new Option("getM", "get-medicines",false, "Printing all medicines from FarmVet database");
    private static final Option getAnimals = new Option("getA", "get-animals",false, "Printing all animals from FarmVet database");
    private static final Option animalDefinition = new Option(null, "animal",false, "Defining animal for next added medicine");
    private static final Option addVet = new Option("a","add-vet",false, "Adding new vet to FarmVet database");
    private static final Option getVets = new Option("getV", "get-vets",false, "Printing all vets from FarmVet database");
    private static final Option vetDefinition = new Option(null, "vet",false, "Defining vet for next added medicine");
    /**
     * @param options
     */
    public static void printFormattedOptions(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        PrintWriter printWriter = new PrintWriter(System.out);
        helpFormatter.printUsage(printWriter, 150, "java -jar quote-maker.jar [option] 'something else if needed' ");
        helpFormatter.printOptions(printWriter, 150, options, 2, 7);
        printWriter.close();
    }
    public static Options addOptions() {
        Options options = new Options();
        options.addOption(addMedcine);
        options.addOption(addAnimal);
        options.addOption(getMedicines);
        options.addOption(getAnimals);
        options.addOption(animalDefinition);
        options.addOption(addVet);
        options.addOption(getVets);
        options.addOption(vetDefinition);
        return options;
    }

    public static Animals searchThroughAnimals(List<Animals> listOfAnimals, String animalsName) {

        Animals animal = null;
        animal = listOfAnimals.stream().filter(an -> an.getName().toLowerCase().equals(animalsName.toLowerCase())).findAny().get();
        return animal;

    }
    public static Vets searchThroughVets(List<Vets> listOfVets, String vetsName) {

        Vets vet = null;
        vet = listOfVets.stream().filter(an -> an.getName().toLowerCase().equals(vetsName.toLowerCase())).findAny().get();
        return vet;

    }
    public static void main(String[] args) throws Exception {
        Options options = addOptions();

        CommandLineParser commandLineParser = new DefaultParser();

        CommandLine cl = commandLineParser.parse(options, args);

//        while(true) {
        if ((cl.hasOption(addMedcine.getOpt()) || cl.hasOption(addMedcine.getLongOpt())) && cl.hasOption((animalDefinition.getLongOpt()))) {
            MedicinesManager medicinesManager = new MedicinesManager();
            AnimalsManager animalsManager = new AnimalsManager();
            Animals animal = null;
            try {
                animal = searchThroughAnimals(animalsManager.getAll(), cl.getArgList().get(1));
            } catch (Exception e) {
                System.out.println("There is no category in the list! Try again.");
                System.exit(1);
            }
            Medicines medicine = new Medicines();
            medicine.setAnimal(animal);
            medicine.setMedicine(cl.getArgList().get(0));
            medicine.setTaked(Date.valueOf(LocalDate.now()));
            medicinesManager.add(medicine);
            System.out.println("You successfully added quote to database!");
        }
    }
}

