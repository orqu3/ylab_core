package homework_1.task_1;

public class Main {

    private final static int MULTIPLIER = 1103515245;
    private final static int INCREMENT = 12345;
    private final static int MODULUS = 2147483647;

    private static int seed = 3819201;

    public static void main(String[] args) {
        int[][] array = createArray();
        printArray(array);

        int max = getMax(array);
        System.out.println("Max value: " + max);

        int min = getMin(array);
        System.out.println("Min value: " + min);

        int average = getAverage(array);
        System.out.println("Average value: " + average);
    }

    public static int[][] createArray() {
        int[][] array = new int[5][5];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = getRandomInt();
            }
        }
        return array;
    }

    public static void printArray(int[][] array) {
        for (int[] ints : array) {
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
        int max = Integer.MIN_VALUE;

        for (int[] ints : array) {
            for (var j = 0; j < array[0].length; j++) {
                if (max < ints[j]) {
                    max = ints[j];
                }
            }
        }
        return max;
    }

    public static int getMin(int[][] array) {
        int min = Integer.MAX_VALUE;

        for (int[] ints : array) {
            for (var j = 0; j < array[0].length; j++) {
                if (min > ints[j]) {
                    min = ints[j];
                }
            }
        }
        return min;
    }

    public static int getAverage(int[][] array) {
        int sum = 0;
        int size = array.length * array[0].length;

        for (int[] ints : array) {
            for (int j = 0; j < array[0].length; j++) {
                sum += ints[j];
            }
        }
        return sum / size;
    }
}
