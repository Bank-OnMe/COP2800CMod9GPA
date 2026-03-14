// PenguinAnalyzer.java
// Symone Banks
// Module 9

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class PenguinAnalyzer {

   private static final String FILE_NAME = "PalmerPenguins.csv";
   private ArrayList<PenguinData> penguinList;

   // Read penguin data from CSV
   public void readPenguinData() {

      penguinList = new ArrayList<>();

      try (BufferedReader reader =
           new BufferedReader(new FileReader(FILE_NAME))) {

         String line;

         reader.readLine(); // Skip header

         while ((line = reader.readLine()) != null) {

            String[] tokens = line.split(",");

            if (tokens.length >= 7) {

               try {

                  int sampleNumber = Integer.parseInt(tokens[0].trim());
                  String species = tokens[1].trim();
                  double billLength = Double.parseDouble(tokens[2].trim());
                  double billDepth = Double.parseDouble(tokens[3].trim());
                  double flipperLength = Double.parseDouble(tokens[4].trim());
                  double bodyMass = Double.parseDouble(tokens[5].trim());
                  String sex = tokens[6].trim();

                  PenguinData penguin =
                     new PenguinData(sampleNumber, species,
                     billLength, billDepth,
                     flipperLength, bodyMass, sex);

                  penguinList.add(penguin);

               }
               catch (NumberFormatException e) {
                  System.err.println("Skipping invalid row: " + line);
               }
            }
            else {
               System.err.println("Skipping malformed row: " + line);
            }
         }

      }
      catch (IOException e) {
         System.err.println("Error reading file: " + e.getMessage());
      }
   }

   // Print penguin data in formatted table
   public void printPenguinData() {

      System.out.printf("%-5s %-10s %-10s %-10s %-15s %-10s %-8s%n",
            "ID","Species","Bill Len","Bill Dep","Flipper Len","Mass","Sex");

      System.out.println("-------------------------------------------------------------");

      for (PenguinData penguin : penguinList) {

         System.out.printf("%-5d %-10s %-10.1f %-10.1f %-15.1f %-10.1f %-8s%n",
               penguin.getSampleNumber(),
               penguin.getSpecies(),
               penguin.getBillLength(),
               penguin.getBillDepth(),
               penguin.getFlipperLength(),
               penguin.getBodyMass(),
               penguin.getSex());
      }
   }

   // Write penguin data to output file
   public void writePenguinData() {

      try (PrintWriter writer =
           new PrintWriter(new FileWriter("PenguinOutput.txt"))) {

         writer.printf("%-5s %-10s %-10s %-10s %-15s %-10s %-8s%n",
               "ID","Species","Bill Len","Bill Dep","Flipper Len","Mass","Sex");

         for (PenguinData penguin : penguinList) {

            writer.printf("%-5d %-10s %-10.1f %-10.1f %-15.1f %-10.1f %-8s%n",
                  penguin.getSampleNumber(),
                  penguin.getSpecies(),
                  penguin.getBillLength(),
                  penguin.getBillDepth(),
                  penguin.getFlipperLength(),
                  penguin.getBodyMass(),
                  penguin.getSex());
         }

         System.out.println("Penguin data successfully written to PenguinOutput.txt.");
      }
      catch (IOException e) {
         System.err.println("Error writing to file: " + e.getMessage());
      }
   }
}
