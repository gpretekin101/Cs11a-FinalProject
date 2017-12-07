package recipeFinder;
public class Spreadsheets{
    import java.util.recipeFinder.Variables;
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
}
