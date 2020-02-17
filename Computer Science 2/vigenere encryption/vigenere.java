import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;;

public class vigenere {

    public static ArrayList<Character> key = new ArrayList<Character>();
    public static ArrayList<Character> message = new ArrayList<Character>();
    public static ArrayList<Character> cipherText = new ArrayList<Character>();

    public static void main(String[] args) {

        File fileKey = new File(args[0]);
        File fileText = new File(args[1]);
        getKeyAndText(fileKey, fileText);

        getCipher();

        printText("Vigenere Key", key);
        printText("Plaintext", message);
        printText("Ciphertext", cipherText);

    }

    public static void getKeyAndText(File fileKey, File fileText) {

        // get key

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileKey));
            String line = null;
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    char temp = Character.toLowerCase(line.charAt(i));
                    int asciiTemp = temp;
                    if (asciiTemp >= 97 && asciiTemp <= 122) {
                        key.add(temp);
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // get message

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileText));
            String line = null;
            int count = 0;
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    char temp = Character.toLowerCase(line.charAt(i));
                    int asciiTemp = temp;
                    if (asciiTemp >= 97 && asciiTemp <= 122 && count < 512) {
                        message.add(temp);
                        count++;
                    }

                }
            }
            // padding
            int mLenght = message.size();
            for (int i = mLenght; i < 512; i++) {
                message.add(i, 'x');
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void printText(String header, ArrayList<Character> text) {
        System.out.println("\n\n" + header + ":\n");
        int lenght = text.size();
        int count = 0;
        for (int i = 0; i < lenght; i++) {

            System.out.print(text.get(i));
            count++;
            if (count == 80) {
                System.out.println();
                count = 0;
            }

        }
        System.out.println();
    }

    public static void getCipher() {
        int count = 0;
        for (int i = 0; i < 512; i++) {
            if (count >= key.size()) {
                count = 0;
            }
            int tempKey = key.get(count);
            tempKey = tempKey - 97;
            int tempMessage = message.get(i);
            tempMessage = tempMessage - 97;
            int tempCipher = (tempKey + tempMessage) % 26;
            tempCipher = tempCipher + 97;
            cipherText.add((char) tempCipher);
            // System.out.printf("k:%d kt:%c m:%d mt:%c c:%d ct:%c\n", tempKey,
            // key.get(count), tempMessage,
            // message.get(i), tempCipher, cipherText.get(i));
            count++;
        }
    }

}