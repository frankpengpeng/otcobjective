package com.frank.practice.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    static Socket server;
    public static void main(String[] args) {
        try {
            server = new Socket(InetAddress.getLocalHost(),5899);
            BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            PrintWriter out = new PrintWriter(server.getOutputStream());
            BufferedReader wr = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                String str = wr.readLine();
                out.println(str);
                out.flush();
                if(str.equalsIgnoreCase("end")){
                    break;
                }
                System.out.println(in.readLine());
            }
            in.close();
            out.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
