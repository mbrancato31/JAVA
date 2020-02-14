import java.util.Scanner;

public class stopping{
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int miles, gas, gast, food, foodt, count = 0;
        miles = in.nextInt();
        gas = in.nextInt();
        food = in.nextInt();

        gast = gas;
        foodt = food;

        for(int i = 0; i < miles; i++){
            if(i == gas && i == food){
                food = food + foodt;
                gas = gas + gast;
                count++;
                //System.out.printf("a  i:%d, f:%d, G:%d \n", i,food,gas);
            }else if(i==food){
                food = food + foodt;
                count++;
               // System.out.printf("b  i:%d, f:%d, G:%d \n", i,food,gas);
            }else if(i==gas){
                gas = gas + gast;
                count++;
               // System.out.printf("c  i:%d, f:%d, G:%d \n", i,food,gas);
            }
        }

        System.out.println(count);


    }
}