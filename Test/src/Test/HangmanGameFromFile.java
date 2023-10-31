package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HangmanGameFromFile {
    private static final String WORDS_FILE = "words.txt";
    private static final int MAX_TRIES = 6;

    private String wordToGuess;
    private char[] currentProgress;
    private int triesLeft;

    public HangmanGameFromFile(String word) {
        wordToGuess = word.toUpperCase();
        currentProgress = new char[wordToGuess.length()];
        for (int i = 0; i < wordToGuess.length(); i++) {
            currentProgress[i] = '_';
        }
        triesLeft = MAX_TRIES;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (triesLeft > 0) {
            // 게임 상태 출력
            System.out.println("현재 진행상황: " + new String(currentProgress));
            System.out.println("남은 시도 횟수: " + triesLeft);

            // 사용자 입력 받기
            System.out.print("알파벳을 추측하세요: ");
            String userInput = scanner.nextLine().toUpperCase();

            if (userInput.length() == 1) {
                char guessedLetter = userInput.charAt(0);

                // 정답에 해당 문자가 있는지 확인
                boolean found = false;
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guessedLetter) {
                        currentProgress[i] = guessedLetter;
                        found = true;
                    }
                }

                if (!found) {
                    triesLeft--;
                }
            } else {
                System.out.println("알파벳 한 글자만 입력하세요.");
            }

            // 정답을 다 맞췄는지 확인
            if (new String(currentProgress).equals(wordToGuess)) {
                System.out.println("축하합니다! 정답을 맞췄습니다.");
                break;
            }
        }

        if (triesLeft == 0) {
            System.out.println("아쉽습니다. 시도 횟수를 모두 사용했습니다. 정답은 " + wordToGuess + "입니다.");
        }
    }

    public static void main(String[] args) {
        ArrayList<String> words = loadWordsFromFile(WORDS_FILE);
        if (words.isEmpty()) {
            System.out.println("단어 목록이 비어있습니다. 프로그램을 종료합니다.");
            return;
        }

        int randomIndex = (int) (Math.random() * words.size());
        String randomWord = words.get(randomIndex);

        HangmanGameFromFile game = new HangmanGameFromFile(randomWord);
        game.playGame();
    }

    public static ArrayList<String> loadWordsFromFile(String fileName) {
        ArrayList<String> words = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("파일을 읽는 중 오류가 발생했습니다.");
        }

        return words;
    }
}

