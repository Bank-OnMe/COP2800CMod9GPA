// PalmerPenguins.java
// Symone Banks
// 3/14/2026
// Module 9


public class PalmerPenguins {

   public static void main(String[] args) {

      // Create analyzer object
      PenguinAnalyzer analyzer = new PenguinAnalyzer();

      // Read CSV file
      analyzer.readPenguinData();

      // Print formatted data
      analyzer.printPenguinData();

      // Write results to output file
      analyzer.writePenguinData();
   }
}
