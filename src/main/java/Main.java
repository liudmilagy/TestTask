import models.Value;

import services.ValueService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Float> list = new ArrayList<Float>();

        System.out.println("Вводите числа с новой строки. Ввод закончите словом \"end\"");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String word = bufferedReader.readLine();
        while (!word.equals("end")) {
            list.add(Float.parseFloat(word));
            word = bufferedReader.readLine();
        }

        sort(list);

        ValueService valueService = new ValueService();
        valueService.createTable();
        for (int i = 0; i <list.size(); i++) {
            System.out.println(list.get(i));

            Value value = new Value(list.get(i));
            valueService.saveValue(value);
        }

    }

    public static void sort(ArrayList<Float> list) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n - i + 1; j++) {
                if (list.get(j-1) > list.get(j)) {
                    swap(list, j-1, j);
                }
            }
        }
    }

    public static void swap(ArrayList<Float> list, int i, int j) {
        Float tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}
