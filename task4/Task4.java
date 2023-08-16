package task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task4 {
    public static void main(String[] args) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(args[0]));

            int result = 0;
            int sum = 0;
            int count = 0;
            String line = reader.readLine();

            while (line != null) {
                sum += Integer.parseInt(line);
                count++;
                line = reader.readLine();
            }
            if (count == 0)
                throw new NumberFormatException();
            int average = sum / count;

            reader = new BufferedReader(new FileReader(args[0]));
            for (int i = 0; i < count; i++) {
                int e = Integer.parseInt(reader.readLine());
                result += Math.abs(average - e);
            }

            System.out.println(result);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Невозможно считать файл!");
        }
    }
}