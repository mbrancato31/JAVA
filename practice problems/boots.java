import java.util.Scanner;

public class boots{


    public static void main(String[] args) {

       
        
        Scanner in = new Scanner(System.in);
        int n;       
        boolean finish = false;
        n = in.nextInt();
        int sizes[] = new int[2 * n];
        for(int i = 0; i < sizes.length; i++){
            sizes[i] = in.nextInt();
        }

        for(int i = 0; i < sizes.length; i++){
            for(int j = 0; j < sizes.length; j++){
                if(sizes[i] < sizes[j]){
                    int temp = sizes[j];
                    sizes[j] = sizes[i];
                    sizes[i] = temp;
                }
            }
        }
        
        int i = 0, count = 0, count2 = 0, nTimes = 0, nChange = 0, g = 0;

        do{

            if(count >= sizes.length){
                i = sizes.length;
            }else if(sizes[i] == sizes[count]){
                count++;
                count2++;
               
            }else{
                
                
                if(count2%2 == 1){
                    nTimes++;
                    count++;
                    i = count;
                    if(count2 == 1 ){
                        if(i < sizes.length){
                            if(sizes[i] != sizes[i+1]){
                                nChange++;
                            }
                        }                        
                    }
                    count2 = 0;
                    
                }
                if(nTimes == 2){
                    nTimes = 0;
                    if(nTimes > 0){
                        nChange++;
                    }                    
                   
                }
                
            }
            if(i >= sizes.length){
                finish = true;
                nChange++;
               
            }

            if(g==30)finish = true;
            g++;

        }while(finish == false);

        System.out.println(nChange);
        



    }
}