package main.classes.fileReader;

import main.classes.Product;
import main.classes.Store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadProductFile {
    private final static String COMMA_DELIMITER = ",";

    public static List<List<String>> readFile() {

        List<List<String>> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/Vitus/IdeaProjects/week-three-task-java011-vitusvictor/src/main/resources/Product_list.csv"))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                result.add(Arrays.asList(values));
            }

            for (int i=1; i<result.size(); i++){
                Store.addProduct( new Product(result.get(i).get(0), result.get(i).get(1), result.get(i).get(2), result.get(i).get(3), result.get(i).get(4)));
            }


        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("Products: " + result);
        return result;
    }
}
