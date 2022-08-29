package task_1;

public class Main {

    private final static int MULTIPLIER = 1103515245;
    private final static int INCREMENT = 12345;
    private final static int MODULUS = 2147483647;

    private static int seed = 3819201;

    public static void main(String[] args) {
        var array = createArray();
        printArray(array);

        var max = getMax(array);
        System.out.println("Max value: " + max);

        var min = getMin(array);
        System.out.println("Min value: " + min);

        var average = getAverage(array);
        System.out.println("Average value: " + average);
    }

    public static int[][] createArray() {
        var array = new int[5][5];

        for (var i = 0; i < array.length; i++) {
            for (var j = 0; j < array[0].length; j++) {
                array[i][j] = getRandomInt();
            }
        }
        return array;
    }

    public static void printArray(int[][] array) {
        for (var ints : array) {
            for (var j = 0; j < array[0].length; j++) {
                System.out.print(ints[j] + "\t\t\t");
            }
            System.out.println();
        }
    }

    public static int getRandomInt() {
        seed = (seed * MULTIPLIER + INCREMENT) % MODULUS;
        return seed;
    }

    public static int getMax(int[][] array) {
        var max = Integer.MIN_VALUE;

        for (var values : array) {
            for (var j = 0; j < array[0].length; j++) {
                if (max < values[j]) {
                    max = values[j];
                }
            }
        }
        return max;
    }

    public static int getMin(int[][] array) {
        var min = Integer.MAX_VALUE;

        for (var values : array) {
            for (var j = 0; j < array[0].length; j++) {
                if (min > values[j]) {
                    min = values[j];
                }
            }
        }
        return min;
    }

    public static int getAverage(int[][] array) {
        var sum = 0;
        var size = array.length * array[0].length;

        for (int[] values : array) {
            for (int j = 0; j < array[0].length; j++) {
                sum += values[j];
            }
        }
        return sum / size;
    }
}
