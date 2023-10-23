package Week06_02;

import java.util.Arrays;

@FunctionalInterface
interface ArrayProcessing {
    double process(double[] array);
}

public class LambdaTest {
    public static final ArrayProcessing maxer = array -> {
        double max = Arrays.stream(array).max().orElse(Double.NEGATIVE_INFINITY);
        return max;
    };

    public static final ArrayProcessing miner = array -> {
        double min = Arrays.stream(array).min().orElse(Double.POSITIVE_INFINITY);
        return min;
    };

    public static final ArrayProcessing sumer = array -> {
        double sum = Arrays.stream(array).sum();
        return sum / array.length;
    };

    public static void main(String[] args) {
        double[] numbers = {10.5, 20.3, 15.2, 8.7, 12.1};

        double maxResult = maxer.process(numbers);
        double minResult = miner.process(numbers);
        double averageResult = sumer.process(numbers);

        System.out.println("최대값: " + maxResult);
        System.out.println("최소값: " + minResult);
        System.out.println("평균값: " + averageResult);
    }
}

