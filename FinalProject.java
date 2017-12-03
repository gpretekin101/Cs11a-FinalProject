public class FinalProject {
  static int dbSize = 22;
  static String[] name = new String[dbSize];
  static String[] type = new String[dbSize];
  static String[] description = new String[dbSize];
  static double[] time = new double[dbSize];
  static double[] calories = new double[dbSize];
  static double[] servings = new double[dbSize];
  static double[] meas1 = new double[dbSize];
  static String[] ing1 = new String[dbSize];
  static double[] meas2 = new double[dbSize];
  static String[] ing2 = new String[dbSize];
  static double[] meas3 = new double[dbSize];
  static String[] ing3 = new String[dbSize];
  static double[] meas4 = new double[dbSize];
  static String[] ing4 = new String[dbSize];
  static double[] meas5 = new double[dbSize];
  static String[] ing5 = new String[dbSize];
  static double[] meas6 = new double[dbSize];
  static String[] ing6 = new String[dbSize];
  static double[] meas7 = new double[dbSize];
  static String[] ing7 = new String[dbSize];
  static double[] meas8 = new double[dbSize];
  static String[] ing8 = new String[dbSize];


  public static void main(String[] args){
    boolean more = true;
    while (more == true) {
      readSpreadsheet();
    //  narrowRecipes();
    //  printRecipes();
    //  measurments();
    //  more();
    }
  }

  public static void readSpreadsheet(){
    TextIO.readFile("Recipes.csv");
    TextIO.getln();  // skip the line of headers...
    int pos=0;
    while (!TextIO.eof()){
      String line = TextIO.getln(); // read in the next line from the file

      String[] fields = line.split(","); // split the columns apart

      // fill in the next position of all the arrays with the current fields
      name[pos] = fields[0];
      type[pos] = fields[1];
      description[pos] = fields[2];
      time[pos] = Double.parseDouble(fields[3]);
      calories[pos] = Double.parseDouble(fields[4]);
      servings[pos] = Double.parseDouble(fields[5]);
      meas1[pos] = Double.parseDouble(fields[6]);
      ing1[pos] = fields[7];
      meas2[pos] = Double.parseDouble(fields[8]);
      ing2[pos] = fields[9];
      meas3[pos] = Double.parseDouble(fields[10]);
      ing3[pos] = fields[11];
      meas4[pos] = Double.parseDouble(fields[12]);
      ing4[pos] = fields[13];
      meas5[pos] = Double.parseDouble(fields[14]);
      ing5[pos] = fields[15];
      meas6[pos] = Double.parseDouble(fields[16]);
      ing6[pos] = fields[17];
      meas7[pos] = Double.parseDouble(fields[18]);
      ing7[pos] = fields[19];
      meas8[pos] = Double.parseDouble(fields[20]);
      ing8[pos] = fields[21];
      pos++; // increment position and get ready to load in the next line of data
      }
  }
}
