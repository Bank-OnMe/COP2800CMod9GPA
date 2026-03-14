// PenguinData.java
// Symone Banks
// Module 9

public class PenguinData {

   // Private fields for encapsulation
   private int sampleNumber;
   private String species;
   private double billLength;
   private double billDepth;
   private double flipperLength;
   private double bodyMass;
   private String sex;

   // Overloaded constructor to initialize fields
   public PenguinData(int sampleNumber, String species,
                      double billLength, double billDepth,
                      double flipperLength, double bodyMass,
                      String sex) {

      this.sampleNumber = sampleNumber;
      this.species = species;
      this.billLength = billLength;
      this.billDepth = billDepth;
      this.flipperLength = flipperLength;
      this.bodyMass = bodyMass;
      this.sex = sex;
   }

   // Getter methods for encapsulation
   public int getSampleNumber() { return sampleNumber; }
   public String getSpecies() { return species; }
   public double getBillLength() { return billLength; }
   public double getBillDepth() { return billDepth; }
   public double getFlipperLength() { return flipperLength; }
   public double getBodyMass() { return bodyMass; }
   public String getSex() { return sex; }
}
