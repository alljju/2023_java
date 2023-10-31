package Test;

import java.io.*;

public class LineNumberingProgram {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("파일을 읽는 중 오류가 발생했습니다.");
        }
    }
}

