import java.util.Scanner;

public class fold{

    public static int x, y, nFold;

    public static void main(String[] args) {
        

        Scanner input = new Scanner(System.in);
        x = input.nextInt();
        y = input.nextInt();
        nFold = input.nextInt();
        
        for(int i = 0; i < nFold; i++){
            if(x > y){
                x = x/2;                
            }else{
                y = y/2;
            } 
        }

        if(x>y)  System.out.println(x + " " + y);
        else System.out.println(y + " " + x);

    }
}