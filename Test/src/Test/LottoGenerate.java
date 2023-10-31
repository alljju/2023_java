package Test;

import java.util.HashSet;

public class LottoGenerate {
    public static void main(String[] args) {
        HashSet<Integer> lottoNumbers = new HashSet<>();

        while (lottoNumbers.size() < 6) {
            int randomNumber = (int) (Math.random() * 45) + 1;
            lottoNumbers.add(randomNumber);
        }

        System.out.println("로또 번호: " + lottoNumbers);
    }
}

