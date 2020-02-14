import java.util.Scanner;

public class parity{
    public static void main(String[] args) {
        
        
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        char theWord[] =new char[word.length()];
        int even = 0, odd = 0;

        int count[] = new int[word.length()];

         for(int i = 0; i < theWord.length; i++){
             theWord[i] = word.charAt(i);
         }

        for(int i = 0; i < theWord.length; i++) {
            for(int j = 0; j < theWord.length; j++) {
                if(theWord[i] == theWord[j]){
                    count[i]++;
                }
            }
        }

        for(int i = 0; i < count.length; i++){
            count[i] = count[i]%2;
            if(count[i] == 0) even++;
            if(count[i] == 1) odd++;

        }

        if(even == count.length) System.out.println("0");
        else if(odd == count.length) System.out.println("1");
        else System.out.println("2");


        

    }
}