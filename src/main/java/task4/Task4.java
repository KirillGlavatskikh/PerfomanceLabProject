package task4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task4 {

    public static void main(String[] args) throws IOException {

        File file = new File(args[0]);

        FileReader fileReader = new FileReader(file);
        List<String> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()) {
            list.add(bufferedReader.readLine());
        }

        int[] array = new int[list.size()];

        int index = 0;
        for (String s : list) {
            array[index++] = Integer.parseInt(s);
        }

        double average = Math.round(AverageValue(array));
        int count = 0;

        for (int j : array) {
            if (j < average) {
                count += average - j;
            }
            if (j > average) {
                count += j - average;
            }
        }
        System.out.println(count);
    }

    public static double AverageValue(int[] arr) {
        double sum = 0;

        for (int i : arr) {
            sum += i;
        }
        return sum / arr.length;
    }
}
