package Test;

/*import java.util.ArrayList;
import java.util.Collections;

public class JuryScoreCalculator {
    public static void main(String[] args) {
        ArrayList<Double> scores = new ArrayList<>();
        // 심사 위원들의 점수를 입력받아 scores ArrayList에 추가하는 코드

        // 예시로 임의의 값들을 추가합니다.
        scores.add(7.5);
        scores.add(8.0);
        scores.add(9.0);
        scores.add(6.0);
        scores.add(9.5);
        scores.add(8.5);
        scores.add(7.0);
        scores.add(9.0);
        scores.add(8.0);
        scores.add(9.0);

        // 최저 점수와 최고 점수를 찾아서 제외합니다.
        double minScore = Collections.min(scores);
        double maxScore = Collections.max(scores);

        scores.remove(minScore);
        scores.remove(maxScore);

        // 나머지 점수들의 합을 구합니다.
        double total = 0;
        for (double score : scores) {
            total += score;
        }

        // 평균을 계산합니다.
        double average = total / scores.size();

        System.out.println("최저 점수: " + minScore);
        System.out.println("최고 점수: " + maxScore);
        System.out.println("나머지 점수들의 평균: " + average);
    }
}*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class JuryScoreCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> scores = new ArrayList<>();

        // 심사위원 점수 입력 받기
        for (int i = 0; i < 10; i++) {
            System.out.print("심사위원 " + (i+1) + "의 점수를 입력하세요 (0.0에서 10.0 사이): ");
            double score = scanner.nextDouble();

            if (score < 0.0 || score > 10.0) {
                System.out.println("잘못된 범위의 점수입니다. 다시 입력하세요.");
                i--; // 유효하지 않은 점수를 다시 입력받기 위해 i를 감소시킴
            } else {
                scores.add(score);
            }
        }

        // 최저 점수와 최고 점수를 찾아서 제외합니다.
        double minScore = Collections.min(scores);
        double maxScore = Collections.max(scores);

        scores.remove(minScore);
        scores.remove(maxScore);

        // 나머지 점수들의 합을 구합니다.
        double total = 0;
        for (double score : scores) {
            total += score;
        }

        // 평균을 계산합니다.
        double average = total / scores.size();

        System.out.println("최저 점수: " + minScore);
        System.out.println("최고 점수: " + maxScore);
        System.out.println("나머지 점수들의 평균: " + average);
    }
}


