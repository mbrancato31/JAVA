import java.util.Scanner;

public class divide{
   
    public int size, ntrack;
    public int []choices = new int[ntrack];
    public int [][]songs = new int[ntrack][10];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);            
        int size, ntrack;
        
        size = in.nextInt();
        ntrack = in.nextInt();

        
        int []choices = new int[ntrack];
        int [][]songs = new int[1000][10];


        for(int i = 0; i < ntrack; i++){
            choices[i] = in.nextInt();
            for(int j = 0; j < choices[i]; j++){
                songs[i][j] = in.nextInt();
            }
        }

        





    }
}