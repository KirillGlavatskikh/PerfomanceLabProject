public class Task1 {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        int[] value = new int[n];

        for(int i = 0; i < value.length; i++){
            value[i] = i + 1;
        }

        int number = 0;
        do{
            System.out.print(value[number]);
            number = (number + m - 1) % n;
        }while (number != 0);
    }
}
