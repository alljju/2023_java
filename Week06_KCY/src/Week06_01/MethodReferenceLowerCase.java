package Week06_01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceLowerCase {
    public static void main(String[] args) {
        List<String> listOfNames = Arrays.asList(new String[]
                {"Apple", "Banana","Cherry"});

        List<String> lowerCaseList = convertToLowerCase(listOfNames);
        System.out.println(lowerCaseList);
    }

    public static List<String> convertToLowerCase(List<String> inputList) {
        return inputList.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}
