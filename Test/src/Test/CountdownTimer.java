package Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CountdownTimer {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // ArrayList에 정수 추가
        for (int i = 10; i >= 1; i--) {
            numbers.add(i);
        }

        // 큐에 정수들을 넣어줌
        queue.addAll(numbers);

        // 카운트다운 시작
        while (!queue.isEmpty()) {
            int number = queue.poll();
            System.out.println(number);

            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("타이머 종료");
    }
}

