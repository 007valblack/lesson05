import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.io.FileWriter;

public class Main extends ShellSort {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Создание массива:");
        int[] arr = new int[10];
        int[] tempArr = arr;
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int) (Math.random() * arr.length);
        }
        System.out.println(Arrays.toString(arr));

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("src\\ShellSort.txt", "rw");
            String write = Arrays.toString(arr);
            randomAccessFile.writeBytes("Создание массива: " + write);
            randomAccessFile.writeBytes("\r\n");
            int h = arr.length/2;
            while (h >= 1) {
                ShellSort.sort(arr, h);
                h = h/2;

            }
            write = Arrays.toString(arr);
            randomAccessFile.writeBytes("Сортировка массива: " + write);
            randomAccessFile.writeBytes("\r\n");
            randomAccessFile.close();
        } catch (FileNotFoundException exception) {
            exception.getMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Сортировка массива:");
        System.out.println(Arrays.toString(arr));

        System.out.println("Массив записан в файл!");
    }
}