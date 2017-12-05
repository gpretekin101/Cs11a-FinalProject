public class FinalProject {
  static int dbSize = 23;
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
      welcome();
      readSpreadsheet();
      narrowRecipes();
      more = false;
      //printRecipes();
      //measurments();
      //more();
    }
  }


  public static void welcome() {
    TextIO.putf("Welcome to the Recipe Generator! %n");
    TextIO.putf("The app will help you make the perfect recipes for your meal%n");
  }


  public static void readSpreadsheet(){
    TextIO.readFile("Recipes.csv");
    TextIO.getln();
    int pos=0;
    while (!TextIO.eof()){
      String line = TextIO.getln();
      String[] fields = line.split(",");
      readStrings(pos, fields);
      readDoubles(pos, fields);
      pos++;
    }
  }


  public static void readStrings(int pos, String[] fields){
    name[pos] = fields[0];
    type[pos] = fields[1];
    description[pos] = fields[2];
    ing1[pos] = fields[7];
    ing2[pos] = fields[9];
    ing3[pos] = fields[11];
    ing4[pos] = fields[13];
    ing5[pos] = fields[15];
    ing6[pos] = fields[17];
    ing7[pos] = fields[19];
    ing8[pos] = fields[21];
    directions[pos] = fields[22];
  }


  public static void readDoubles(int pos, String[] fields){
    time[pos] = Double.parseDouble(fields[3]);
    calories[pos] = Double.parseDouble(fields[4]);
    servings[pos] = Double.parseDouble(fields[5]);
    meas1[pos] = Double.parseDouble(fields[6]);
    meas2[pos] = Double.parseDouble(fields[8]);
    meas3[pos] = Double.parseDouble(fields[10]);
    meas4[pos] = Double.parseDouble(fields[12]);
    meas5[pos] = Double.parseDouble(fields[14]);
    meas6[pos] = Double.parseDouble(fields[16]);
    meas7[pos] = Double.parseDouble(fields[18]);
    meas8[pos] = Double.parseDouble(fields[20]);
  }


  public static void narrowRecipes() {
    String type, label;
    int time, cal, count;
    TextIO.putf("What type of dish would you like to make? %n");
    type = getType();
    TextIO.putf("Do your guests have any dietary restrictions? %n");
    label = getLabel();
    TextIO.putf("How much time (in minutes) do you have to make the recipe? %n");
    time = getTime();
    TextIO.putf("What is the most amount of calories per serving your recipe can have? %n");
    cal = getCal();
  }


  public static String getType(){
    TextIO.readStandardInput();
    String t;
    do{
      TextIO.putf("Please type salad, dessert, soup, appetizer, or entree %n");
      t = TextIO.getln();
    }while (!t.equalsIgnoreCase("salad") && !t.equalsIgnoreCase("dessert") && !t.equalsIgnoreCase("soup") && !t.equalsIgnoreCase("appetizer") && !t.equalsIgnoreCase("entree"));
    return t;
  }


  public static String getLabel(){
    String l;
    do{
      TextIO.putf("Please type gluten-free, dairy-free, vegetarian, or vegan %n");
      l = TextIO.getln();
    }while (!l.equalsIgnoreCase("gluten-free") && !l.equalsIgnoreCase("dairy-free") && !l.equalsIgnoreCase("vegetarian") && !l.equalsIgnoreCase("vegan"));
    return l;
  }


  public static int getTime(){
    int time = TextIO.getlnInt();
    if (time<0){
      TextIO.putf("That is not a valid entry. Please enter the amount of time in minutes you have to make this recipe%n");
      time = TextIO.getlnInt();
    }
    return time;
  }


  public static int getCal(){
    int cal = TextIO.getlnInt();
    if (cal <0){
      TextIO.putf("That is not a valid entry. Please enter the maximum amount of calories per serving your recipe can have%n");
      cal = TextIO.getlnInt();
  }
  return cal;
  }
}


      /*
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
>>>>>>> 3834e77b680c25371f699ef8c8b52f42a87a864c
*/
