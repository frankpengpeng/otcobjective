package com.frank.practice.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5899);
            Socket socket = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            while (true){
                String str = in.readLine();
                System.out.println(str);
                out.println("has received message...");
                out.flush();
                if(str.equalsIgnoreCase("end")){
                    break;
                }
            }
            in.close();
            out.close();
            server.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
