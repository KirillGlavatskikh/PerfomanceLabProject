package highload.homework;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        startGame();
    }

    public static int[] generateRandomValue() {
        int[] result = new int[4];
        for (int i = 0; i < 4; i++) {
            result[i] = (int) (Math.random() * 6) + 1;
        }
        return result;
    }

    public static int[] inputValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¬ведите 4 цифры");
        String inputValue = scanner.next();
        String[] inputArr = inputValue.split("");
        int[] input = new int[4];
        for (int i = 0; i < inputArr.length; i++) {
            input[i] = Integer.parseInt(inputArr[i]);
        }
        return input;
    }

    public static void startGame() {
        int[] randomValue = generateRandomValue();
        System.out.println(Arrays.toString(randomValue));
        FileWork fileWork = new FileWork();
        Bull bull = new Bull();
        Cow cow = new Cow();
        fileWork.startGameInitWritingToFile(randomValue);
        boolean check = true;
        int countAttempt = 0;
        while(check){
            countAttempt++;
            int[] inputValue = inputValue();
            System.out.println(Arrays.toString(inputValue));
            int countBullResult = initCountBull(randomValue, inputValue);
            bull.setCountBull(countBullResult);
            int countCowResult = initCountCow(randomValue, inputValue);
            cow.setCountCow(countCowResult);
            fileWork.writingAttemptsInGameFile(inputValue, bull, cow, countAttempt);
            if(bull.getCountBull() == 4){
                System.out.println(bull + " за " + countAttempt + " попыток");
                check = false;
            }else{
                System.out.println(bull);
                System.out.println(cow);
            }
        }
    }


    public static int initCountBull(int[] randomValue, int[] userValue) {
        int countBull = 0;
        for (int i = 0; i < randomValue.length; i++) {
            if (randomValue[i] == userValue[i]) {
                countBull++;
            }
        }
        return countBull;
    }

    public static int initCountCow(int[] randomValue, int[] userValue) {
        int countCow = 0;
        for (int i = 0; i < randomValue.length; i++) {
            if (randomValue[i] != userValue[i]) {
                int uv = userValue[i];
                if (Arrays.stream(randomValue).anyMatch(x -> x == uv)) {
                    countCow++;
                }
            }
        }
        return countCow;
    }
}


