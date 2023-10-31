package Test;
import java.io.BufferedReader;

import java.io.BufferedWriter;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;



public class Test2 {

    public static void main(String[] args) {

        // 입력 및 출력 파일 경로 설정

        String inputFilePath = "obama.txt"; // 입력 파일 경로

        String outputFilePath = "output.txt"; // 출력 파일 경로



        try {

            // 입력 파일을 읽기 위한 BufferedReader 생성

            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));



            // 출력 파일을 쓰기 위한 BufferedWriter 생성

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));



            int charCode;

            while ((charCode = reader.read()) != -1) {

                char ch = (char) charCode;



                // 소문자인 경우에만 대문자로 변환

                if (Character.isLowerCase(ch)) {

                    ch = Character.toUpperCase(ch);

                }



                // 대문자로 변환된 문자를 출력 파일에 쓰기

                writer.write(ch);

            }



            // 파일 닫기

            reader.close();

            writer.close();



            System.out.println("파일 변환 완료");

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
