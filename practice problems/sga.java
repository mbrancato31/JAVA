import java.util.Scanner;

public class sga{
    public static void main(String[] args) {
        
        int num, count = 0;
        Scanner input = new Scanner(System.in);
        num = input.nextInt();
        String words[] = new String[num];
       
        for(int i = 0; i < words.length; i++){
            words[i] = input.next();
        }

        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words.length; j++){
                if((words[i].charAt(0) == words[j].charAt(0)) && (words[i].compareTo(words[j]) != 0)){
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}
