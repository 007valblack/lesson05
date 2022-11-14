public class ShellSort {
    public static void sort (int[] arr, int h) {
        for (int i = h; i < arr.length; i++) {
            for (int j = i; j >= h; j = j - h) {
                if (arr[j] < arr[j-h]) {
                    int temp = arr[j-h];
                    arr[j-h] = arr[j];
                    arr[j] = temp;
                }
                else
                    break;
            }
        }
    }
}

