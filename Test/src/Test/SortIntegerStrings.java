package Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SortIntegerStrings {
    public static void main(String[] args) {
        try {
            // 파일 읽기
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            ArrayList<String> lines = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            // 문자열을 정수로 변환하여 정렬
            ArrayList<Integer> numbers = new ArrayList<>();
            for (String str : lines) {
                numbers.add(Integer.parseInt(str));
            }

            Collections.sort(numbers);

            // 정렬된 숫자를 문자열로 변환하여 파일에 쓰기
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            for (Integer number : numbers) {
                writer.write(number.toString());
                writer.newLine();
            }

            // 파일 닫기
            reader.close();
            writer.close();

            System.out.println("파일이 정상적으로 처리되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("파일 처리 중 오류가 발생했습니다.");
        }
    }
}
