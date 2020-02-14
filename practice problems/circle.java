import java.util.Scanner;
import java.lang.Math;

public class circle{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double val;

        val = in.nextDouble();

        val = (val * 4 * 100) / 48.23636;
        val =  Math.sqrt((val * val) / 2);
        val = val * val;

        System.out.printf("%.5f", val);

        
    }
}