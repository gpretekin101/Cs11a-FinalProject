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
  static String[] directions = new String[dbSize];


  public static void main(String[] args){
    boolean more = true;
    while (more == true) {
      readSpreadsheet();
      narrowRecipes();
      printRecipes();
      measurments();
      more();
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
      directions[pos] = fields[22];
      pos++; // increment position and get ready to load in the next line of data
      }
  }
public static void welcome() {
    TextIO.putf("Welcome to the Recipe genetor! %n");
    TextIO.putf("The app will help you make the perfect recipes for your meal");
  }

public static String[] narrowRecipes() {
      new String[] findings = new String[30];
      String type, label;
      int time, cal, count;
      TextIO.putf("What type of dish would you like to make? %n");
      TextIO.putf("In this database we have salads, dessert, soups, appetizers, and entrees %n");
      type = textIO.getln();
      TextIO.putf("Do your guests have any dietary restrictions? %n");
      TextIO.putf("We have gluten free, dairy free, vegetarian, and vegan recipes in this database %n");
      label = TextIO.getln();
      TextIO.putf("How much time do you have to make the recipe? %n");
      time = TextIO.getlnInt();
      TextIO.putf("What is the most amount of calories your recipe can have? %n");
      cal = TextIO.getlnInt();
      for (int i=0; i >=0 && i< 50; i ++) {
        if (type.equals(type[i]) && label.equals(description[i]) && time[i] <= time && cal[i] >= calories){
            findings[i] = name[i];
            count ++;
          }
      } TextIO.putf("We have %d recipes that fit the criteria you have inputted %n", count);

        TextIO.putf("The recipes we found were ");
        for (int i; i < count; i++) {
            if (type.equals(type[i]) && label.equals(description[i]) && time[i] <= time && cal[i] >= calories){
                TextIO.putf("%s", name[i]);
                TextIO.putf("Ingredients: %n");
                for (int j; int j < 8; j++) { //goes through each of the ingredients and measurements
                  if (ing1[i]!= X) {
                      TextIO.putf("%d %s %n", meas1, ing1);
                  } if (ing2[i]!= X) {
                      TextIO.putf("%d %s %n", meas2, ing2);
                  } if (ing3[i]!= X) {
                      TextIO.putf("%d %s %n", meas3, ing3);
                  } if (ing4[i]!= X) {
                      TextIO.putf("%d %s %n", meas4, ing4);
                  } if (ing5[i]!= X) {
                      TextIO.putf("%d %s %n", meas5, ing5);
                  } if (ing6[i]!= X) {
                      TextIO.putf("%d %s %n", meas6, ing6);
                  } if (ing7[i]!= X) {
                      TextIO.putf("%d %s %n", meas7, ing7);
                    } if (ing8[i]!= X) {
                        TextIO.putf("%d %s %n", meas8, ing8);
                  else {
                      break;
                  }
                }
                TextIO.putf("Directions: %d %n", directions[i]);
                TextIO.putf("Calories: %d %n", calories[i]);
                TextIO.putf("Time to Make: %d %n", time[i]);
                TextIO.putf("This recipe is %s and %s %d", type[i], description[i]);
            }
      }
   }
}
