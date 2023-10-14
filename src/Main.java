import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] mas= readNumberFromF("INPUT.TXT");
        int n = mas[0];
        int m = mas[1];
        int k = mas[2];

        if (!((n<=1)||(m<=1)||(k<=1)||(n>=100000)||(m>=100000)||(k>=100000))) {
            int i = 1;
            while (m - n > 0) {
                m = m - n + k;
                i++;
            }
            //System.out.println("Число ударов = " + i);
            if ((m < n) && (n <= k)) {
                String outputFName = "OUTPUT.TXT";
                Files.writeString(Path.of(outputFName), "NO");
            }
            else {
                String str = Integer.toString(i); // преобразование числа в строку
                String outputFName = "OUTPUT.TXT";
                Files.writeString(Path.of(outputFName), str);
            }
        }
        else
            System.out.println("Конец истории");
}
    private static int[] readNumberFromF(String fileName) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        //int n = scan.nextInt();
        int[] mas = new int[3];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scan.nextInt();
        }
        return mas;
    }
}