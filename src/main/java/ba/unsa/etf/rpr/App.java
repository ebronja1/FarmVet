package ba.unsa.etf.rpr;
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

    public static void main(String[] args) {
    }
}
