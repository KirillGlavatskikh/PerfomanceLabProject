package task4;

import java.io.*;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
        boolean check = true;

        while (check) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] < average) {
                    array[i] += 1;
                    count++;
                }
                if (array[i] > average) {
                    array[i] -= 1;
                    count++;
                }
                if (Arrays.stream(array).distinct().count() == 1) {
                    check = false;
                }
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
