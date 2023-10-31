package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Map<String, Integer> wordFrequency = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("words.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    // 소문자로 변경하여 처리 (대소문자 구분하지 않음)
                    word = word.toLowerCase();

                    if (!word.isEmpty()) {
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("파일을 읽는 중 오류가 발생했습니다.");
        }

        // 단어의 등장 횟수 출력
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "회");
        }
    }
}
