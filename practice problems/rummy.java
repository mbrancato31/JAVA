import java.util.Scanner;

public class rummy{

    private static int cards[];
    private static boolean noComb = false;
    
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        cards = new int[7];
        // get cards
        for(int i = 0; i < 7; i++){
            cards[i] = input.nextInt();           
        }
       
        //organize them
        for(int i = 0; i < 7;i++){
            for(int j = 0; j <7; j++){
                if(cards[i] < cards[j]){
                    int temp = cards[j];
                    cards[j] = cards[i];
                    cards[i] = temp;
                }
            }
        }    


        do{
            if(seg() > escalera()){
                //add 50 to seg
            }else{
                //add 50 to es
            }
        }while(noComb != false);



    }

    public static int seg(){
        for(int i = 0; i < 7; i++){
            if(cards[])
        }

        
    }

    public static int escalera(){
        for(int i = 0; i < 7; i++){
        //    if()
        }

        
    }
}