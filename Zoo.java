import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents the zoo and its operations.
 */
public class Zoo {
    private final List<Animal> animals;
    private final Map<String, Integer> speciesCount;

    /**
     * Constructor for the Zoo class.
     */
    public Zoo() {
        this.animals = new ArrayList<>();
        this.speciesCount = new HashMap<>();
    }

    /**
     * Reads animal details from the input file and adds them to the zoo.
     *
     * @param filename the name of the input file
     * @throws IOException if an I/O error occurs
     */
    public void readAnimalsFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                String species = parts[2];

                Animal animal = switch (species) {
                    case "Hyena" -> new Hyena(name, age, true);
                    case "Lion" -> new Lion(name, age, true);
                    case "Tiger" -> new Tiger(name, age, true);
                    case "Bear" -> new Bear(name, age, true);
                    default -> throw new RuntimeException("Unknown species: " + species);
                };

                animals.add(animal);
                speciesCount.put(species, speciesCount.getOrDefault(species, 0) + 1);
            }
        }
    }

    /**
     * Writes a report to the output file.
     *
     * @param filename the name of the output file
     * @throws IOException if an I/O error occurs
     */
    public void writeReportToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Map.Entry<String, Integer> entry : speciesCount.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
                for (Animal animal : animals) {
                    if (animal.getSpecies().equals(entry.getKey())) {
                        writer.write("  - " + animal.getName() + ", " + animal.getAge() + "\n");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        try {
            zoo.readAnimalsFromFile("arrivingAnimals.txt"); // Verify filename
            zoo.writeReportToFile("newAnimals.txt");
            System.out.println("Report created successfully in newAnimals.txt.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}