package model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {
    static Thread sent;
    static Thread receive;
    static Socket socket;
    
    public static void main(String args[]){
            try {
                socket = new Socket("localhost",9999);
            } catch (UnknownHostException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            sent = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    BufferedReader stdIn =new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    System.out.println("Receiving string length");
                    int len_word = Integer.parseInt(stdIn.readLine());
                    System.out.println("recieved: " + len_word);
                    char words[] = new char[len_word];

                    for(int i = 0; i < len_word; i++)
                        words[i] = (char)32;
                    int correct = 0;
                    int mistakes = 0;
                    while(correct < len_word && mistakes < 10) {
                        Scanner sr = new Scanner(System.in);
                        String current = sr.nextLine();
                        out.print(current);
                        out.flush();
                        System.out.println("letter:" + current);
                        int veredict = Integer.parseInt(stdIn.readLine());
                        if(veredict == 0) {
                            int n_coincidences = Integer.parseInt(stdIn.readLine());
                            correct += n_coincidences;
                            for(int i = 0; i < n_coincidences; i++) {
                                int positions = Integer.parseInt(stdIn.readLine());
                                words[positions] = current.charAt(0);
                            }
                            for(int j = 0; j < words.length; j++)
                                System.out.print(words[j]);
                            System.out.println("");
                        }
                        else {
                            mistakes++;
                        }
                    }
                    if(correct == len_word) {
                        System.out.println("You guessed all the letters correctly :D");
                    }
                    else
                        System.out.println("Good luck next time");
                    socket.close();
                    out.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
        sent.start();
        try {
            sent.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}