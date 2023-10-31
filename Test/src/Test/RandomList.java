package Test;

import java.util.ArrayList;
import java.util.Random;

public class RandomList<T> {
    private ArrayList<T> elements;
    private Random random;

    public RandomList() {
        elements = new ArrayList<>();
        random = new Random();
    }

    public void add(T element) {
        elements.add(element);
    }

    public T select() {
        if (elements.isEmpty()) {
            return null;
        }

        int randomIndex = random.nextInt(elements.size());
        return elements.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomList<Integer> randomIntegers = new RandomList<>();
        randomIntegers.add(1);
        randomIntegers.add(2);
        randomIntegers.add(3);

        System.out.println("Selected: " + randomIntegers.select());

        RandomList<String> randomStrings = new RandomList<>();
        randomStrings.add("apple");
        randomStrings.add("banana");
        randomStrings.add("cherry");

        System.out.println("Selected: " + randomStrings.select());
    }
}

