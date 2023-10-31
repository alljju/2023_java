package Test;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static void main(String[] args) {
        // HashSet 객체 S1 생성 및 초기화
        Set<String> S1 = new HashSet<>();
        S1.add("A");
        S1.add("B");
        S1.add("C");

        // HashSet 객체 S2 생성 및 초기화
        Set<String> S2 = new HashSet<>();
        S2.add("A");
        S2.add("D");

        // 합집합 계산
        Set<String> union = new HashSet<>(S1);
        union.addAll(S2);

        // 교집합 계산
        Set<String> intersection = new HashSet<>(S1);
        intersection.retainAll(S2);

        // 결과 출력
        System.out.println("S1: " + S1);
        System.out.println("S2: " + S2);
        System.out.println("합집합: " + union);
        System.out.println("교집합: " + intersection);
    }
}

