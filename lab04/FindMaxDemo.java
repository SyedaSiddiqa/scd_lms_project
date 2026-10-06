public class FindMaxDemo {

    public static int findMaxBuggy(int[] numbers) {
        int maxValue = 0;
        for (int n : numbers) {
            if (n > maxValue) {
                maxValue = n;
            }
        }
        return maxValue;
    }

    public static int findMax(int[] numbers) {
        int maxValue = numbers[0]; // start from the first number, not 0
        for (int n : numbers) {
            if (n > maxValue) {
                maxValue = n;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] data = {-5, -2, -9};
        System.out.println("Buggy findMax : " + findMaxBuggy(data));
        System.out.println("Fixed findMax : " + findMax(data));
    }
}
