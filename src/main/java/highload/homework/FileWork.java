package highload.homework;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileWork {

    private static final String FILE_PATH_BULLS_COWS_GAME = "D:/PerfomanceLabProject/src/main/java/highload" +
            "/homework/Bulls-cows_game.txt";
    private static final String FILE_PATH_FILE_WITH_NUMBERS = "D:/PerfomanceLabProject/src/main/java/highload" +
            "/homework/file_with_numbers.txt";
    private int countGame;

    public void startGameInitWritingToFile(int[] randomValue) {
        {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH_BULLS_COWS_GAME, true));
                Date date = new Date();
                checkFileNumbers();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                String resultStr = "Game №" + countGame + " " + simpleDateFormat.format(date) + " Загаданная строка " +
                        Arrays.toString(randomValue) + "\n";
                oos.writeObject(resultStr);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void checkFileNumbers() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH_FILE_WITH_NUMBERS));
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH_FILE_WITH_NUMBERS));
            List<String> list = new ArrayList<>();
            if (bufferedReader.read() == -1) {
                countGame = 1;
                oos.writeObject(countGame + "\n");
            } else {
                list.add(String.valueOf(bufferedReader.read()));
                countGame = list.size() + 1;
                oos.writeObject(countGame + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writingAttemptsInGameFile(int[] userValue, Bull bull, Cow cow, int countGame) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH_BULLS_COWS_GAME, true));
            String str = "Запрос: " + Arrays.toString(userValue) + " Ответ: " + bull + " " + cow + "\n";
            oos.writeObject(str);
            if(bull.getCountBull() == 4){
                oos.writeObject("Строка угадана за " + countGame + " попыток" +"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
