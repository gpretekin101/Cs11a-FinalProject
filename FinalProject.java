public class FinalProject {
  static int dbSize = 32;
  static String[] name = new String[dbSize];
  static String[] typeList = new String[dbSize];
  static String[] description = new String[dbSize];
  static double[] timeList = new double[dbSize];
  static double[] calories = new double[dbSize];
  static int[] servingsList = new int[dbSize];
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
    boolean moreInput = true;
    boolean moreRecipes = true;
    while (moreInput == true) {
      welcome();
      readSpreadsheet();
//      welcome();
//      narrowRecipes();
      //printRecipes();

//      int servings = narrowRecipes();
//      while (moreRecipes == true){
//        int index = chooseRecipe();
//        printRecipe(index, servings);
//        moreRecipes = chooseMore();
//      }
//      moreInput=false;
      //measurments();
      //more();
//    }
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
      readNumbers(pos, fields);
      pos++;
    }
  }


  public static void readStrings(int pos, String[] fields){
    name[pos] = fields[0];
    TextIO.putf("%s%n", name[pos]);
    typeList[pos] = fields[1];
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


  public static void readNumbers(int pos, String[] fields){
    timeList[pos] = Double.parseDouble(fields[3]);
    calories[pos] = Double.parseDouble(fields[4]);
    servingsList[pos] = Integer.parseInt(fields[5]);
    meas1[pos] = Double.parseDouble(fields[6]);
    meas2[pos] = Double.parseDouble(fields[8]);
    meas3[pos] = Double.parseDouble(fields[10]);
    meas4[pos] = Double.parseDouble(fields[12]);
    meas5[pos] = Double.parseDouble(fields[14]);
    meas6[pos] = Double.parseDouble(fields[16]);
    meas7[pos] = Double.parseDouble(fields[18]);
    meas8[pos] = Double.parseDouble(fields[20]);
  }
}

/*
  public static int narrowRecipes(){
    String type = getType();
    String label = getLabel();
    int time = getTime();
    int cal = getCal();
    int servings = getServings();
    printRecipes(type, label, time, cal);
    return servings;
  }

*/
/*public static String[] narrowRecipes() {
=======

  public static void welcome() {
      TextIO.putf("Welcome to the Recipe genetor! %n");
      TextIO.putf("The app will help you make the perfect recipes for your meal");
    }

  public static String narrowRecipes() {
>>>>>>> 1467f39e1226dc3f1ef8fd1f5cf5264726d7303e
      String[] findings = new String[30];
      String typeU, label;
      int timeU, cal, count;
      TextIO.putf("What type of dish would you like to make? %n");
      TextIO.putf("In this database we have salads, dessert, soups, appetizers, and entrees %n");
      typeU = TextIO.getln();
      TextIO.putf("Do your guests have any dietary restrictions? %n");
      TextIO.putf("We have gluten free, dairy free, vegetarian, and vegan recipes in this database %n");
      label = TextIO.getln();
      TextIO.putf("How much time do you have to make the recipe? %n");
      timeU = TextIO.getlnInt();
      TextIO.putf("What is the most amount of calories your recipe can have? %n");
      cal = TextIO.getlnInt();
      for (int i=0; i >=0 && i< 50; i ++) {
        if (typeU.equals(type[i]) && label.equals(description[i]) && time[i] <= timeU && calories[i] <= cal){
            findings[i] = name[i];
            count ++;
          }
      } TextIO.putf("We have %d recipes that fit the criteria you have inputted %n", count);
        return findings[]
  } */

/*
  public static String getType(){
    TextIO.readStandardInput();
    TextIO.putf("What type of dish would you like to make? %n");
    String t;
    do{
      TextIO.putf("Please type salad, dessert, soup, appetizer, or entree %n");
      t = TextIO.getln();
    }while (!t.equalsIgnoreCase("salad") && !t.equalsIgnoreCase("dessert") && !t.equalsIgnoreCase("soup") && !t.equalsIgnoreCase("appetizer") && !t.equalsIgnoreCase("entree"));
    return t;
  }


  public static String getLabel(){
    TextIO.putf("Do your guests have any dietary restrictions? %n");
    String l;
    do{
      TextIO.putf("Please type gluten-free, dairy-free, vegetarian, or vegan %n");
      l = TextIO.getln();
    }while (!l.equalsIgnoreCase("gluten-free") && !l.equalsIgnoreCase("dairy-free") && !l.equalsIgnoreCase("vegetarian") && !l.equalsIgnoreCase("vegan"));
    return l;
  }


  public static int getTime(){
    TextIO.putf("How much time (in minutes) do you have to make the recipe? %n");
    int time = TextIO.getlnInt();
    if (time<0){
      TextIO.putf("That is not a valid entry. Please enter the amount of time in minutes you have to make this recipe%n");
      time = TextIO.getlnInt();
    }
    return time;
  }


  public static int getCal(){
    TextIO.putf("What is the most amount of calories per serving your recipe can have? %n");
    int cal = TextIO.getlnInt();
    if (cal <0){
      TextIO.putf("That is not a valid entry. Please enter the maximum amount of calories per serving your recipe can have%n");
      cal = TextIO.getlnInt();
    }
  return cal;
  }


  public static int getServings(){
    TextIO.putf("How many people are you cooking for?%n");
    int servings = TextIO.getlnInt();
    if (servings<0){
      TextIO.putf("That is not a valid entry. Please enter the number of servings you would like to make %n");
      servings = TextIO.getlnInt();
    }
    return servings;
  }


  public static void printRecipes(String type, String label, int time, int cal){
    int count = 0;
    for (int i=0; i<dbSize; i++){
      if(typeList[i].equalsIgnoreCase(type) && description[i].equalsIgnoreCase(label) && timeList[i]<=time && calories[i]<=cal){
        count++;
        TextIO.putf("%d. %s%n", count, name[i]);
      }
    }
    if (count>0){
      TextIO.putf("There are %d %s recipes that are %s, take less than %d minutes to make, and have under %d calories per serving.%n",count, type, label, time, cal);
    } else{
      TextIO.putf("Sorry, there are no %s recipes that are %s, take less than %d minutes to make, and have under %d calories per serving.%n",type, label, time, cal);
      //ask to do again
    }
  }


  public static int chooseRecipe(){
    TextIO.putf("Which dish would you like to get the recipe for?%n"); //
    boolean validInput = false;
    String chosenRecipe;
    int index=0;
    do{
      chosenRecipe = TextIO.getln();
      validInput=checkInput(chosenRecipe);
    }while (!validInput);
    for (int i=0; i<name.length; i++){
      if (name[i].equalsIgnoreCase(chosenRecipe)){
        index =i;
      }
    }
    return index;
  }

  public static boolean checkInput(String chosenRecipe){
    for (int i=0; i<name.length; i++){
      if (name[i].equalsIgnoreCase(chosenRecipe)){
        return true;
      }
    }
    TextIO.putf("Please type the name of the dish you would like to get the recipe for:%n");
    return false;
  }


  public static void printRecipe(int index, int servings){
    TextIO.putf("%n%n%n %s%n", name[index]);
    changeServings(index, servings);
    printIngandMeas(index);


  }


  public static void changeServings(int index, int servings){
    if (servings>servingsList[index]){
      double multiply = (double)servings/(double)servingsList[index];
      meas1[index]=multiply*meas1[index];
      meas2[index]=multiply*meas2[index];
      meas3[index]=multiply*meas3[index];
      meas4[index]=multiply*meas4[index];
      meas5[index]=multiply*meas5[index];
      meas6[index]=multiply*meas6[index];
      meas7[index]=multiply*meas7[index];
      meas8[index]=multiply*meas8[index];
    }
  }


  public static boolean chooseMore(){
    TextIO.putf("Would you like to pick another dish to get the recipe for?%n");
    return TextIO.getlnBoolean();
  }

  public static void printIngandMeas(int index) {
    TextIO.putf("%1.2f %s %n", meas1[index], ing1[index]);
    TextIO.putf("%1.2f %s %n", meas2[index], ing2[index]);
    TextIO.putf("%1.2f %s %n", meas3[index], ing3[index]);
    TextIO.putf("Ingredients: %n");
    if (!ing4[index].equals("0")) {
        TextIO.putf("%d %s %n", meas4, ing4);
    } if (!ing5[index].equals("0")) {
        TextIO.putf("%d %s %n", meas5, ing5);
    } if (!ing6[index].equals("X")) {
        TextIO.putf("%d %s %n", meas6, ing6);
    } if (!ing7[index].equals("X")) {
        TextIO.putf("%d %s %n", meas7, ing7);
    } if (!ing5[index].equals("X")) {
        TextIO.putf("%d %s %n", meas8, ing8);
    } else {
          break;
      }
    TextIO.putf("Directions: %d %n", directions[index]);
    TextIO.putf("Calories: %d %n", calories[index]);
    TextIO.putf("Time to Make: %d %n", time[index]);
    TextIO.putf("This recipe is %s and %s %d", type[index], description[index]);
  }
}
*/
