import java.util.Scanner;

public class bulk{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int items, price, dis;

        items = in.nextInt();
        price = in.nextInt();

        dis = 2 * (items - 1);

        System.out.println((price * items) - dis);


    }
}