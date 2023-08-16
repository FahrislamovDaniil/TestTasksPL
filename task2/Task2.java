package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(args[0]));

            String rawCircle = reader.readLine();
            if (rawCircle == null)
                throw new ArrayIndexOutOfBoundsException();

            String[] coordinates = rawCircle.split(" ");

            float x = Float.parseFloat(coordinates[0]);
            float y = Float.parseFloat(coordinates[1]);
            String rString = reader.readLine();
            if (rString == null)
                throw new ArrayIndexOutOfBoundsException();
            float r = Float.parseFloat(rString);

            reader = new BufferedReader(new FileReader(args[1]));
            String line = reader.readLine();
            int count = 0;
            while (line != null && count < 101) {
                String[] pointCoordinates = line.split(" ");
                float a = Float.parseFloat(pointCoordinates[0]);
                float b = Float.parseFloat(pointCoordinates[1]);

                printResult(x, y, r, a, b);

                line = reader.readLine();
                count++;
            }
            if (count == 0)
                throw new ArrayIndexOutOfBoundsException();
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Введите путь к корректным файлам!");
        }
    }

    private static void printResult(float x, float y, float r, float a, float b) {
        float v = (x - a) * (x - a) + (y - b) * (y - b);
        if (v < r * r) {
            System.out.print("1\n");
        } else if (v == r * r) {
            System.out.print("0\n");
        } else {
            System.out.print("2\n");
        }
    }
}