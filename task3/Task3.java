package task3;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Task3 {
    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(args[0]));

            String line = reader.readLine();
            StringBuilder tests = new StringBuilder();
            while (line != null) {
                tests.append(line);
                line = reader.readLine();
            }
            String testsString = tests.toString();

            reader = new BufferedReader(new FileReader(args[1]));

            line = reader.readLine();
            StringBuilder values = new StringBuilder();
            while (line != null) {
                values.append(line);
                line = reader.readLine();
            }
            String valuesString = values.toString();

            int i = 0;
            while (testsString.contains("\"\"")) {
                String[] nextId = getNextId(testsString, valuesString, i).split("_");
                testsString = testsString.replaceFirst("\"\"", "\"" + getValue(valuesString, nextId[0]) + "\"");
                i = Integer.parseInt(nextId[1]);
            }

            File file = new File("report.json");
            PrintWriter out = new PrintWriter(file, StandardCharsets.UTF_8);
            out.write(testsString);
            out.flush();
        } catch (IOException e) {
            System.out.println("Невозможно считать файлы!");
        }
    }

    private static String getNextId(String file, String values, int index) {
        int j = file.indexOf("\"id\"", index) + "\"id\"".length();
        StringBuilder id = new StringBuilder();
        while (file.charAt(j) != ',') {
            if (file.charAt(j) != ':' && file.charAt(j) != ' ')
                id.append(file.charAt(j));
            j++;
        }
        if (!values.contains(id.toString()))
            return getNextId(file, values, j);
        return id + "_" + j;
    }

    private static String getValue(String file, String id) {
        int j = file.indexOf(":", file.indexOf(id)) + ":".length();

        while (file.charAt(j) != '"') {
            j++;
        }
        j++;
        StringBuilder value = new StringBuilder();
        while (file.charAt(j) != '"') {
            value.append(file.charAt(j));
            j++;
        }
        return value.toString();
    }
}