package Week06_03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

enum Type {
    MEAT, FISH, OTHER
}

public class Test {
    public static void main(String[] args) {
        List<Food> foodList = Arrays.asList(
                new Food("Steak", false, 800, Type.MEAT),
                new Food("Salmon", false, 450, Type.FISH),
                new Food("Spinach", true, 23, Type.OTHER),
                new Food("Rice", true, 218, Type.OTHER),
                new Food("Chicken", false, 335, Type.MEAT)
        );

        // 칼로리가 300 이하이면서 채식인 음식만 골라내기
        List<Food> selectedFoods = foodList.stream()
                .filter(food -> food.getCalories() <= 300 && food.isVege())
                .collect(Collectors.toList());

        System.out.println("300 칼로리 이하이면서 채식인 음식:");
        for (Food food : selectedFoods) {
            System.out.println(food.getName());
        }
    }
}

