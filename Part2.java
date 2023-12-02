import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class Part2 {
    ArrayList<String> input = new ArrayList<String>();

    public Part2(){
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

    ArrayList<Integer> results = new ArrayList<>();
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

            index = 0;
            int redMin = -1;
            int greenMin = -1;
            int blueMin = -1;

            //For every handful
            while(index < values.size()) {

                //For every cube in handful
                for (String item : values.get(index)) {
                    if (item.contains("red")) {
                        item = item.replace("red", "");
                        System.out.println("Cut red: " + item);
                        if(Integer.parseInt(item) > redMin){
                            System.out.println("Passed (red): " + item);
                            redMin = Integer.parseInt(item);
                        }
                    } else if (item.contains("green")) {
                        item = item.replace("green", "");
                        System.out.println("Cut green: " + item);
                        if(Integer.parseInt(item) > greenMin){
                            System.out.println("Passed (green): " + item);
                            greenMin = Integer.parseInt(item);
                        }
                    } else if (item.contains("blue")) {
                        item = item.replace("blue", "");
                        System.out.println("Cut blue: " + item);
                        if(Integer.parseInt(item) > blueMin){
                            System.out.println("Passed (blue): " + item);
                            blueMin = Integer.parseInt(item);
                        }
                    }
                }
                index++;
            }

            results.add(redMin * blueMin * greenMin);
        }

        int sum = 0;
        for(int x = 0; x < results.size(); x++){
                sum += results.get(x);
        }
        System.out.println(sum);
    }
}
