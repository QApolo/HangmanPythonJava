package model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client {
    static Socket socket;
    int correct;
    int mistakes;
    PrintWriter out;
    int len_word;
    char words[];
    BufferedReader stdIn;
    public Client(String ip, int port) {
        try {
             socket = new Socket(ip, port);
         } catch (UnknownHostException e1) {
             // TODO Auto-generated catch block
             e1.printStackTrace();
         } catch (IOException e1) {
             // TODO Auto-generated catch block
             e1.printStackTrace();
         }
    }
    public Client() {
        try {
             socket = new Socket("localhost",9999);
         } catch (UnknownHostException e1) {
             // TODO Auto-generated catch block
             e1.printStackTrace();
         } catch (IOException e1) {
             // TODO Auto-generated catch block
             e1.printStackTrace();
         }
    }
    public void init() {
        
        try {
            stdIn =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Receiving string length");
            len_word = Integer.parseInt(stdIn.readLine());
            System.out.println("recieved: " + len_word);
            words = new char[len_word];

            for(int i = 0; i < len_word; i++)
                words[i] = '_';
            correct = 0;
            mistakes = 0;
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public char[] getCurrentWord() {
        return words;
    }
    public void closeAll() {
        try {
            socket.close();
            
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getLetter(String current) {
            while(correct < len_word && mistakes < 10) {
        
                //Scanner sr = new Scanner(System.in);
               // String current = sr.nextLine();
                out.print(current);
                out.flush();
                System.out.println("letter:" + current);
                
                int veredict = 0;
                try {
                    veredict = Integer.parseInt(stdIn.readLine());
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(veredict == 0) {
                    int n_coincidences = 0;
                    try {
                        n_coincidences = Integer.parseInt(stdIn.readLine());
                    } catch (IOException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    correct += n_coincidences;
                    for(int i = 0; i < n_coincidences; i++) {
                        int positions = 0;
                        try {
                            positions = Integer.parseInt(stdIn.readLine());
                        } catch (IOException ex) {
                            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        words[positions] = current.charAt(0);
                    }
                    for(int j = 0; j < words.length; j++)
                        System.out.print(words[j]);
                    System.out.println("");
                }
                else {
                    mistakes++;
                }
                return;
            }
            if(correct == len_word) {
                System.out.println("You guessed all the letters correctly :D");
            }
            else
                System.out.println("Good luck next time");
    }
}