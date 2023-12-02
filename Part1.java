import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Part1 {
    ArrayList<String> input = new ArrayList<String>();

    public Part1(){
        readFile();
        check();
    }
    private void readFile(){
        try{
            File file1 = new File("input.txt");
            Scanner sc1 = new Scanner(file1);
            while(sc1.hasNextLine()){
                input.add(sc1.nextLine());
            }
        }
        catch (Exception e){
            System.err.println("File not found");
        }
    }

    private void check(){
        //12 red, 13 green, 14 blue
        for(String row : input){
            //Get rid of Game x:
            int index = row.indexOf(':') + 2;
            String value = row.substring(index);
            //System.out.println(value);

            //Strip ; and whitespace
            value = value.replaceAll(";", ",");
            value = value.replaceAll("\\s+", "");
           // System.out.println(value);

            //Add to array
            String[] items = value.split(",");

            //Summing
            int redSum = 0;
            int greenSum = 0;
            int blueSum = 0;

            for(String item : items){
                if(item.contains("red")){
                    redSum += Integer.parseInt(item.substring(0, 1));
                }
                else if(item.contains("green")){
                    greenSum += Integer.parseInt(item.substring(0, 1));
                }
                else if(item.contains("blue")){
                    blueSum += Integer.parseInt(item.substring(0, 1));
                }
            }
            System.out.println("Red: " + redSum + " Blue: " + blueSum + " Green: " + greenSum);
            //Checking if valid
            boolean valid = true;
            if(redSum > 12){
                valid = false;
            }
            if(greenSum > 13){
                valid = false;
            }
            if(blueSum > 14){
                valid = false;
            }
            System.out.println(valid);
        }
    }
}
