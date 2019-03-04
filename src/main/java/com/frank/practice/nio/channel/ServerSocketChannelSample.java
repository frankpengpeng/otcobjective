package com.frank.practice.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelSample {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8080));
        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            if(serverSocketChannel!=null){
                // register socket channel to selector
            }
        }
    }
}
