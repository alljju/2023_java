package Test;

import java.io.*;

public class FileComparator {
    public static void main(String[] args) {
        try {
            File file1 = new File("input1.txt");
            File file2 = new File("input2.txt");

            FileInputStream fis1 = new FileInputStream(file1);
            FileInputStream fis2 = new FileInputStream(file2);

            boolean areEqual = compareFiles(fis1, fis2);

            if (areEqual) {
                System.out.println("두 파일은 일치합니다.");
            } else {
                System.out.println("두 파일은 일치하지 않습니다.");
            }

            fis1.close();
            fis2.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("파일을 비교하는 중 오류가 발생했습니다.");
        }
    }

    public static boolean compareFiles(InputStream is1, InputStream is2) throws IOException {
        int byte1;
        int byte2;
        do {
            byte1 = is1.read();
            byte2 = is2.read();
            if (byte1 != byte2) {
                return false;
            }
        } while (byte1 != -1 && byte2 != -1);

        return true;
    }
}
