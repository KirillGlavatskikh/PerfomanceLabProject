package task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task2 {

    public static void main(String[] args) throws IOException {

        File firstFile = new File(args[0]);
        File secondFile = new File(args[1]);

        FileReader ffr = new FileReader(firstFile);
        FileReader sfr = new FileReader(secondFile);

        BufferedReader fbr = new BufferedReader(ffr);
        BufferedReader sbr = new BufferedReader(sfr);

        List<String> fl = new ArrayList<>();
        while (fbr.ready()) {
            fl.add(fbr.readLine());
        }
        String coordinatCentr = "";
        String rad = "";
        for (int i = 0; i < fl.size(); i++) {
            coordinatCentr = fl.get(0);
            rad = fl.get(1);
        }
        float radius = Float.parseFloat(rad);
        float centrCircleCoordinataA = 0;
        float centrCircleCoordinataB = 0;
        String[] s = coordinatCentr.split(" ");
        for (int i = 0; i < 1; i++) {
            centrCircleCoordinataA = centrCircleCoordinataA + Float.parseFloat(s[0]);
            centrCircleCoordinataB += Float.parseFloat(s[1]);
        }

        printPointPosition(radius, centrCircleCoordinataA, centrCircleCoordinataB, sbr);

    }

    private static void printPointPosition(float radius, float centrCircleCoordinataA, float centrCircleCoordinataB, BufferedReader sbr) throws IOException {
        while (sbr.ready()) {
            float secondPointCoordinataA = 0;
            float secondPointCoordinataB = 0;
            String str = sbr.readLine();
            String[] strArr = str.split(" ");
            for (int i = 0; i < 1; i++) {
                secondPointCoordinataA += Float.parseFloat(strArr[0]);
                secondPointCoordinataB += Float.parseFloat(strArr[1]);
            }
            float hypotinusa = (float) Math.sqrt(Math.pow(secondPointCoordinataA, 2) + Math.pow(secondPointCoordinataB, 2));
            float result = (float) Math.floor(hypotinusa);
            if (radius + centrCircleCoordinataA > result && radius + centrCircleCoordinataB > result) {

                System.out.print(1 + "\r\n");
            } else if (radius + centrCircleCoordinataA == result && radius + centrCircleCoordinataB == result) {
                System.out.print(0 + "\r\n");
            } else {
                System.out.print(2 + "\r\n");

            }
        }
    }
}
