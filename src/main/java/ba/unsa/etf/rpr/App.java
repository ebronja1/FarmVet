package ba.unsa.etf.rpr;
import ba.unsa.etf.rpr.business.AnimalsManager;
import ba.unsa.etf.rpr.business.MedicinesManager;
import ba.unsa.etf.rpr.business.VetsManager;
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
        helpFormatter.printUsage(printWriter, 150, "java -jar FarmVet.jar [option] 'something else if needed' ");
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

        if ((cl.hasOption(addMedcine.getOpt()) || cl.hasOption(addMedcine.getLongOpt())) && cl.hasOption((animalDefinition.getLongOpt()))) {
            MedicinesManager medicinesManager = new MedicinesManager();
            AnimalsManager animalsManager = new AnimalsManager();
            Animals animal = null;
            try {
                animal = searchThroughAnimals(animalsManager.getAll(), cl.getArgList().get(1));
            } catch (Exception e) {
                System.out.println("There is no animal in the list! Try again.");
                System.exit(1);
            }
            VetsManager vetsManager = new VetsManager();
            Vets vet = null;
            try {
                vet = searchThroughVets(vetsManager.getAll(), cl.getArgList().get(2));
            } catch (Exception e) {
                System.out.println("There is no vet in the list! Try again.");
                System.exit(1);
            }
            Medicines medicine = new Medicines();
            medicine.setAnimal(animal);
            medicine.setVet(vet);
            medicine.setMedicine(cl.getArgList().get(0));
            medicine.setTaked(Date.valueOf(LocalDate.now()));
            medicinesManager.add(medicine);
            System.out.println("You successfully added medicine to database!");

        } else if (cl.hasOption(getMedicines.getOpt()) || cl.hasOption(getMedicines.getLongOpt())) {
            MedicinesManager medicinesManager = new MedicinesManager();
            medicinesManager.getAll().forEach(q -> System.out.println(q.getMedicine()));

        } else if (cl.hasOption(addAnimal.getOpt()) || cl.hasOption(addAnimal.getLongOpt())) {
            try {
                AnimalsManager animalsManager = new AnimalsManager();
                Animals animal = new Animals();
                animal.setName(cl.getArgList().get(0));
                animal.setKind(cl.getArgList().get(1));
                animalsManager.add(animal);
                System.out.println("Animal has been added successfully");
            } catch (Exception e) {
                System.out.println("There is already animal with same name in database! Try again");
                System.exit(1);
            }
        } else if (cl.hasOption(getAnimals.getOpt()) || cl.hasOption(getAnimals.getLongOpt())) {
            AnimalsManager animalsManager = new AnimalsManager();
            animalsManager.getAll().forEach(c -> System.out.println(c.getName()));

        } else if (cl.hasOption(addVet.getOpt()) || cl.hasOption(addVet.getLongOpt())) {
            try {
                VetsManager vetsManager = new VetsManager();
                Vets vet = new Vets();
                vet.setName(cl.getArgList().get(0));
                vet.setPassword(cl.getArgList().get(1));
                vet.setUsername(cl.getArgList().get(1));
                vetsManager.add(vet);
                System.out.println("Vet has been added successfully");
            } catch (Exception e) {
                System.out.println("There is already vet with same name in database! Try again");
                System.exit(1);
            }

        } else if (cl.hasOption(getVets.getOpt()) || cl.hasOption(getVets.getLongOpt())) {
            VetsManager vetsManager = new VetsManager();
            vetsManager.getAll().forEach(c -> System.out.println(c.getName()));

        } else {
            printFormattedOptions(options);
            System.exit(-1);
//                break;
        }
    }
}

