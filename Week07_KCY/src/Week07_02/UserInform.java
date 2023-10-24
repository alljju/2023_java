package Week07_02;


import java.io.*;

import java.util.Scanner;



public class UserInform {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String filePath = "contacts.txt";



        while (true) {

            System.out.println("메뉴:");

            System.out.println("1. 정보 입력");

            System.out.println("0. 정보 찾기");

            System.out.print("선택: ");

            String choice = scanner.nextLine();



            if ("1".equals(choice)) {

                // 사용자 정보 입력을 위한 변수

                String number, name, phoneNumber, email;



                try {

                    // 파일을 쓰기 위한 BufferedWriter 생성

                    BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));



                    // 사용자 정보 입력 받기

                    System.out.print("번호: ");

                    number = scanner.nextLine();

                    System.out.print("이름: ");

                    name = scanner.nextLine();

                    System.out.print("전화번호: ");

                    phoneNumber = scanner.nextLine();

                    System.out.print("이메일 주소: ");

                    email = scanner.nextLine();



                    // 사용자 정보를 CSV 형식으로 파일에 저장

                    writer.write(number + "," + name + "," + phoneNumber + "," + email);

                    writer.newLine();

                    writer.close();

                    System.out.println("사용자 정보가 파일에 저장되었습니다.");



                } catch (IOException e) {

                    e.printStackTrace();

                }

            } else if ("0".equals(choice)) {

                // 사용자로부터 검색할 번호 입력

                System.out.print("검색할 번호를 입력하세요: ");

                String searchNumber = scanner.nextLine();



                try {

                    // 파일에서 검색한 번호에 해당하는 정보 출력

                    BufferedReader reader = new BufferedReader(new FileReader(filePath));

                    String line;

                    boolean found = false;

                    while ((line = reader.readLine()) != null) {

                        String[] parts = line.split(",");

                        if (parts.length >= 3 && parts[0].equals(searchNumber)) {

                            System.out.println("번호: " + parts[0]);

                            System.out.println("이름: " + parts[1]);

                            System.out.println("전화번호: " + parts[2]);

                            System.out.println("이메일 주소: " + parts[3]);

                            found = true;

                            break;

                        }

                    }

                    if (!found) {

                        System.out.println("해당 번호를 가진 사용자를 찾을 수 없습니다.");

                    }

                    reader.close();

                } catch (IOException e) {

                    e.printStackTrace();

                }

            } else {

                System.out.println("잘못된 선택입니다. 다시 시도하세요.");

            }

        }

    }

}
