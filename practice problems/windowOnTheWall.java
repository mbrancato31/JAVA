import java.util.Scanner;

public class windowOnTheWall{

    public static void main(String[] args) {
        
        int width = 0, heigth = 0, gap = 0, res = 0;
        Scanner input = new Scanner(System.in);

        width = input.nextInt();
        heigth = input.nextInt();
        gap = input.nextInt();

        width = width - (2 * gap);
        heigth = heigth - (2 * gap);
        res = width * heigth;


        if(width < 0 || heigth < 0){
            System.out.println("0");
        }else System.out.println(res);


    }//end main
}