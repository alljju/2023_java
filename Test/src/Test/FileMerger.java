package Test;

import java.io.*;

public class FileMerger {
    public static void main(String[] args) {
        try {
            File inputFile1 = new File("input1.txt");
            File inputFile2 = new File("input2.txt");

            FileInputStream fis1 = new FileInputStream(inputFile1);
            FileInputStream fis2 = new FileInputStream(inputFile2);

            FileOutputStream fos = new FileOutputStream("output.txt");

            mergeFiles(fis1, fis2, fos);

            fis1.close();
            fis2.close();
            fos.close();

            System.out.println("두 파일이 성공적으로 병합되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("파일을 병합하는 중 오류가 발생했습니다.");
        }
    }

    public static void mergeFiles(InputStream is1, InputStream is2, OutputStream os) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = is1.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
        }

        while ((bytesRead = is2.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
    }
}

