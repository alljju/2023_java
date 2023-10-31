package Test;

import java.util.Scanner;

public class HangmanGame {
    private static final String[] WORDS = {"JAVA", "PYTHON", "CANDY", "APPLE"};
    private static final int MAX_TRIES = 6;

    private String wordToGuess;
    private char[] currentProgress;
    private int triesLeft;

    public HangmanGame() {
        // 게임 초기화
        wordToGuess = WORDS[(int) (Math.random() * WORDS.length)].toUpperCase();
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
        HangmanGame game = new HangmanGame();
        game.playGame();
    }
}

