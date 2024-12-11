import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Date date = new Date();
        int currentYear = date.getYear();
        String yearValue = Integer.toString(currentYear).substring(1);
        String currentDate = "_" + yearValue+ "_" + date.getMonth() + "_" + date.getDate();
        String sourceFile = ".idea/Files/sourceFile.txt";
        String targetFile = ".idea/Files/newFile"+currentDate+".txt";

        try(
                FileReader fileReader = new FileReader(sourceFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                FileWriter fileWriter = new FileWriter(targetFile);
                ) {

            while (true){
                if (bufferedReader.lines() == null){
                    break;
                }
                else{
                    fileWriter.write(bufferedReader.readLine());
                    fileWriter.write("\n");
                }
            }

            System.out.println("File created!");

        } catch (NullPointerException e){
            System.out.println("No Problems Found in the File!");
        } catch (Exception exc){
            System.out.println(exc.getMessage());
        }
    }
}
