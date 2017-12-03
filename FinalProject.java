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
      narrowRecipes();
      printRecipes();
      measurments();
      more();
    }
}
