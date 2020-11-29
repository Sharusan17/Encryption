import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        char alphabet;
        String ciphertext = " ";

        Random rand = new Random();
        int shift = rand.nextInt(26);
        System.out.println("Enter a message");
        String msg = s.nextLine();
        for (int i=0; i<msg.length(); i++){
            alphabet = msg.charAt(i);
            alphabet = (char) (alphabet + shift);
            ciphertext = ciphertext + alphabet;
        }

        String decryption = " ";
        for (int i=0; i<ciphertext.length(); i++){
            alphabet = ciphertext.charAt(i);
            alphabet = (char) (alphabet - shift);
            decryption = decryption + alphabet;
        }


        try {
            FileWriter myWriter = new FileWriter("encryption.txt");
            myWriter.write("ciphertext: " + ciphertext + "          ");
            myWriter.close();
            System.out.println("Message Encrypted Successful");
        } catch (IOException e) {
            System.out.println("Message Encrypted Failed");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("decryption.txt");
            myWriter.write("decrypted: " + decryption + "          ");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Message Encrypted Failed");
            e.printStackTrace();
        }
    }
}