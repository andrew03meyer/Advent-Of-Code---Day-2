import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

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

    ArrayList<String> results = new ArrayList<>();
    private void check(){
        //12 red, 13 green, 14 blue
        for(String row : input){
            //Get rid of Game x:
            int index = row.indexOf(':') + 2;
            String value = row.substring(index);
            //System.out.println(value);

            value = value.replaceAll("\\s+", "");

            //Add to array
            String[] items = value.split(";");

            //2D array of values
            ArrayList<ArrayList<String>> values = new ArrayList<>();
            for(String item : items) {
                values.add(new ArrayList<>(Arrays.asList(item.split(","))));
            }


            boolean valid = true;
            index = 0;

            //Summing
            while(valid && index < values.size()) {
                int redSum = 0;
                int greenSum = 0;
                int blueSum = 0;

                //System.out.println(values.get(index));
                for (String item : values.get(index)) {
                    //System.out.println("Item: " + item);
                    if (item.contains("red")) {
                        item = item.replace("red", "");
                        redSum += Integer.parseInt(item);
                    } else if (item.contains("green")) {
                        item = item.replace("green", "");
                        greenSum += Integer.parseInt(item);
                    } else if (item.contains("blue")) {
                        item = item.replace("blue", "");
                        blueSum += Integer.parseInt(item);
                    }

                    //Checking if valid
                    if(redSum > 12){
                        valid = false;
                    }
                    if(greenSum > 13){
                        valid = false;
                    }
                    if(blueSum > 14){
                        valid = false;
                    }
                }
                index++;
            }

            results.add(String.valueOf(valid));
        }

        int sum = 0;
        for(int x = 0; x < results.size(); x++){
            if(results.get(x).equals("true")){
                sum += x+1;
            }
        }
        System.out.println("Sum: " + sum);
    }
}
