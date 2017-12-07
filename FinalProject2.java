public class FinalProject2 {

  //declare static arrays
  static int dbSize = 54;
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

  /**
  The main method
  @param args an array of strings which we ignore
  */
  public static void main(String[] args){
    boolean moreInput = true;                                   //initialize boolean variables
    boolean moreRecipes = true;
    while (moreInput == true) {
      readSpreadsheet();                                        //read data from excel file
      welcome();                                                //print welcome message
      int servings = narrowRecipes();                           //get user's criteria for recipe and print the title of recipes that fit in a list
      while (moreRecipes == true){                              //as long as the user wants to get recipes from the list
        int index = chooseRecipe();                             //get the index of the recipe the user chose
        printChosenRecipe(index, servings);                     //print the ingredients, directions, and other information about the recipe the user chose
        moreRecipes = chooseMore();                             //as the user if they want to choose another recipe title to get the ingredients and directions for
      }
      moreInput = more();                                       //ask the user if they want to put in more information to get a new set of recipes
      moreRecipes =true;
    }
    TextIO.putf("Bon appetit!");
  }


  /**
  welcome message
  no parameters
  no return
  */
  public static void welcome() {
    TextIO.putf("Welcome to the Recipe Generator! %n");
    TextIO.putf("The app will help you make the perfect recipes for your meal%n%n%n");
  }


  /**
  read information from a CSV file
  no parameters
  no return
  */
  public static void readSpreadsheet(){
    TextIO.readFile("Recipes.csv");                           //read from file
    TextIO.getln();                                           //ignore the first row (title of the columns)
    int pos=0;
    while (!TextIO.eof()){                                    //while it is not at the end of the file
      String line = TextIO.getln();                           //read in a line of data
      String[] fields = line.split(",");                      //split the line at commas
      readStrings(pos, fields);                               //set the values in the arrays
      readNumbers(pos, fields);
      pos++;                                                  //increment the array position
    }
  }


  /**
  taking strings from the CSV file and assigning them to arrays
  @param pos the position in the array that a value will be assigned to
  @param fields an array of strings that contains the values to be assigned
  no return since these are static arrays
  */
  public static void readStrings(int pos, String[] fields){
    name[pos] = fields[0];
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


  /**
  taking strings from the CSV file, converting them to doubles or ints, and assigning them to arrays
  @param pos the position in the array that a value will be assigned to
  @param fields and array of strings that contains the value to be assigned
  no return since these are static arrays
  */
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


  /**
  gets the criteria of a recipe from the user and prints out the titles of recipes that fulfill the criteria
  no parameters
  @return integer servings, the number of servings the user wants to make
  */
  public static int narrowRecipes(){
    String type = getType();                                    //appetizer, entree, salad, soup
    String label = getLabel();                                  //vegerarian, vegan, gluten-free, dairy-free
    int time = getTime();                                       //maximum amount of time user can cook for
    int cal = getCal();                                         //maximum number of calories per serving
    int servings = getServings();                               //number servings user wants to make
    printRecipes(type, label, time, cal);                       //print the titles of relavent recipes
    return servings;
  }


  /**
  ask user if they want to make an appetizer, entree, salad, or soup
  no parameters
  @return the type of dish the user wants to make, string
  */
  public static String getType(){
    TextIO.readStandardInput();
    TextIO.putf("What type of dish would you like to make? %n");
    String t;
    do{                                                           // make sure user's input is valid
      TextIO.putf("Please type salad, soup, appetizer, or entree %n");
      t = TextIO.getln();
    }while (!t.equalsIgnoreCase("salad") && !t.equalsIgnoreCase("soup") && !t.equalsIgnoreCase("appetizer") && !t.equalsIgnoreCase("entree"));
    return t;
  }


  /**
  ask if user wants their dish to be vegetarian, vegan, gluten-free, or dairy-free
  no parameters
  @return the restriction on the dish, string
  */
  public static String getLabel(){
    TextIO.putf("%nDo your guests have any dietary restrictions? %n");
    String l;
    do{                                                             //make sure user's input is valid
      TextIO.putf("Please type gluten-free, dairy-free, vegetarian, or vegan %n");
      l = TextIO.getln();
    }while (!l.equalsIgnoreCase("gluten-free") && !l.equalsIgnoreCase("dairy-free") && !l.equalsIgnoreCase("vegetarian") && !l.equalsIgnoreCase("vegan"));
    return l;
  }


  /**
  get the maximum amount of time user has to make the dish
  no parameters
  @return the time the user has to make the dish, int
  */
  public static int getTime(){
    TextIO.putf("%nHow much time (in minutes) do you have to make the recipe? %n");
    int time = TextIO.getlnInt();
    if (time<0){                                                     //make sure user's input is valid
      TextIO.putf("That is not a valid entry. Please enter the amount of time in minutes you have to make this recipe%n");
      time = TextIO.getlnInt();
    }
    return time;
  }


  /**
  get the maximum amount of calories per serving in the dish
  no parameters
  @return the maximum number of calories per serving, int
  */
  public static int getCal(){
    TextIO.putf("%nWhat is the most amount of calories per serving your recipe can have? %n");
    int cal = TextIO.getlnInt();
    if (cal <0){                                                      //make sure the user's input is valid
      TextIO.putf("That is not a valid entry. Please enter the maximum amount of calories per serving your recipe can have%n");
      cal = TextIO.getlnInt();
    }
  return cal;
  }


  /**
  get the number of servings the user wants to make
  no parameters
  @return the number of servings, int
  */
  public static int getServings(){
    TextIO.putf("%nHow many people are you cooking for?%n");
    int servings = TextIO.getlnInt();
    if (servings<0){                                                    // make sure the user's input is valid
      TextIO.putf("That is not a valid entry. Please enter the number of servings you would like to make %n");
      servings = TextIO.getlnInt();
    }
    return servings;
  }


  /**
  print out the titles of recipes that fit the user's criteria
  @param type a string that describes the type (appetizer, entree, soup, salad) of the dish
  @param label a string that describes the restrictions (vegetarian, vegan, gluten-free, dairy-free) of the dish
  @param time an int that describes the maximum amount of time in minutes that the user can cook
  @param cal an int that describes the maximum amount of calories per serving
  no return
  */
  public static void printRecipes(String type, String label, int time, int cal){
    int count = 0;                                                      //keep track of the number of recipes found
    for (int i=0; i<dbSize; i++){                                       // go through the arrays and print the titles of recipes that match all the criteria
      if(typeList[i].equalsIgnoreCase(type) && description[i].equalsIgnoreCase(label) && timeList[i]<=time && calories[i]<=cal){
        count++;                                                        //increment the number of recipes found
        TextIO.putf("%d. %s%n", count, name[i]);
      }
    }
    if (count>0){                                                       //tell the user how many recipes were found
      TextIO.putf("There are %d %s recipes that are %s, take less than %d minutes to make, and have under %d calories per serving.%n",count, type, label, time, cal);
    } else{
      TextIO.putf("Sorry, there are no %s recipes that are %s, take less than %d minutes to make, and have under %d calories per serving.%n%n%n",type, label, time, cal);
      narrowRecipes();                                                  //ask for different criteria if no recipes were found
    }
  }

  /**
  ask the user to pick which recipe they want to know more about
  no parameters
  @return the index (int) of the chosen recipe
  */
  public static int chooseRecipe(){
    TextIO.putf("Which dish would you like to get the recipe for?%n");
    boolean validInput = false;
    String chosenRecipe;
    int index=0;
    do{                                                                   //ask the user to type in the name of the recipe and check their response is valid
      chosenRecipe = TextIO.getln();
      validInput=checkInput(chosenRecipe);
    }while (!validInput);
    for (int i=0; i<name.length; i++){                                    //find the index of the recipe the user chose
      if (name[i].equalsIgnoreCase(chosenRecipe)){
        index =i;
      }
    }
    return index;
  }


  /**
  check to make sure the user had a valid entry for which recipe they want to know more about
  @param chosenRecipe a string that is the recipe the user chose
  @return true if valid, false if not
  */
  public static boolean checkInput(String chosenRecipe){
    for (int i=0; i<name.length; i++){                                     //go through array of recipe names and check to see if the user's entry matches one
      if (name[i].equalsIgnoreCase(chosenRecipe)){
        return true;
      }
    }
    TextIO.putf("Please type the name of the dish you would like to get the recipe for:%n");
    return false;
  }


  /**
  Prints the title, directions, and other information about the chosen recipe
  @param index the index(int) of the chosen recipe
  @param servings the number of servings (int) the user needs to make
  no return
  */
  public static void printChosenRecipe(int index, int servings){
    TextIO.putf("%n%n%n%s%n", name[index]);                    //print out the title of the recipe
    double multiply = changeServings(index, servings);         //change proportions of recipe to fit with the number of servings the user wants to make
    double actualServings= multiply*servingsList[index];       //calculate the actual servings the recipe will now make (should be equal to the number of servings the user needs to make)
    printIngandMeas(index);                                    //print ingredients and measurements
    printDirections(index);                                    //print directions
    printOtherInfo(index, actualServings);                     //print other infor
  }


  /**
  multiplies the quantities of ingredients by a factor so that user will know how much to add for the number of servings they need to make
  @param index the index (int) of the recipe
  @param servings the number of servings the user needs to make
  @return the factor by which all quantities must be multiplied
  */
  public static double changeServings(int index, int servings){
    double multiply = 1;
    if (servings>servingsList[index]){                        //only multiply if the recipe does not make enough, some recipes cannot be scaled back and so user may need to make more than they need
      multiply = (double)servings/(double)servingsList[index];
      meas1[index]=multiply*meas1[index];                    //multiply quantities of ingredients by a factor
      meas2[index]=multiply*meas2[index];
      meas3[index]=multiply*meas3[index];
      meas4[index]=multiply*meas4[index];
      meas5[index]=multiply*meas5[index];
      meas6[index]=multiply*meas6[index];
      meas7[index]=multiply*meas7[index];
      meas8[index]=multiply*meas8[index];
    }
    return multiply;
  }


  /**
  print ingredients and new measurements
  @param index the index (int) of the recipe
  no return
  */
  public static void printIngandMeas(int index) {
    TextIO.putf("Ingredients: %n");
    TextIO.putf("%1.2f %s %n", meas1[index], ing1[index]);
    TextIO.putf("%1.2f %s %n", meas2[index], ing2[index]);
    TextIO.putf("%1.2f %s %n", meas3[index], ing3[index]);        //all recipes have at least 3 ingredients
    if (meas4[index]!=0) {                                        //check to make sure there is an ingredient to print before printing it
        TextIO.putf("%1.2f %s %n", meas4[index], ing4[index]);
    }if (meas5[index]!=0) {
        TextIO.putf("%1.2f %s %n", meas5[index], ing5[index]);
    }if (meas6[index]!=0) {
        TextIO.putf("%1.2f %s %n", meas6[index], ing6[index]);
    }if (meas7[index]!=0) {
        TextIO.putf("%1.2f %s %n", meas7[index], ing7[index]);
    }if (meas8[index]!=0) {
        TextIO.putf("%1.2f %s %n", meas8[index], ing8[index]);
    }
  }


  /**
  print the directions for the recipe
  @param index the index (int) of the recipe
  no return
  */
  public static void printDirections(int index){
    String dir = directions[index];                           //turn the directions for the recipe into a string dir
    String [] split = dir.split(">");                         //split the string at the character ">" and store into an array split
    for (int i=0; i<split.length; i++){                       //print out each index of the array with a carriage return after
      TextIO.putf("%s%n", split[i]);
    }
  }


  /**
  prints out the calories, the amount of time to make, and the actual servings of the recipe
  @param index the index (int) of the recipe
  @param actualServings the actual number of servings the recipe makes, double
  no return
  */
  public static void printOtherInfo(int index, double actualServings){
    TextIO.putf("Calories per serving: %1.0f%n", calories[index]);
    TextIO.putf("Time to make: %1.0f minutes%n", timeList[index]);
    TextIO.putf("This recipe will make %1.0f servings%n", actualServings);
  }


  /**
  ask the user if they want the instructions to make a different recipe
  no parameters
  @return true if they want to get the instructions for a different recipe, false if they don't
  */
  public static boolean chooseMore(){
    TextIO.putf("Would you like to pick another dish to get the recipe for?%n");
    return TextIO.getlnBoolean();
  }


  /**
  ask the user if they want to enter a different set of criteria to find new recipes
  no parameters
  @return true if they want to enter more criteria, false if they do not, program ends if false
  */
  public static boolean more(){
    TextIO.putf("Would you like to enter new criteria for a recipe?%n");
    return TextIO.getlnBoolean();
  }
}
