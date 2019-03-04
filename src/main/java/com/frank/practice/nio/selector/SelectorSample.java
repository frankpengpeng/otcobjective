package com.frank.practice.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorSample {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        channel.connect(new InetSocketAddress("http://localhost", 8080));
        SelectionKey selectionKey = channel.register(selector, SelectionKey.OP_READ);
        while (true){
            int readyChannels = selector.select();
            if(readyChannels == 0) continue;
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> it = selectionKeySet.iterator();
            while (it.hasNext()){
                SelectionKey sk = it.next();
                if(sk.isAcceptable()){
                    System.out.println("有通道接受已就绪");
                }
                if(sk.isConnectable()){
                    System.out.println("有通道链接已就绪");
                }
                if(sk.isReadable()){
                    System.out.println("有通道可读数据");
                }
                if(sk.isWritable()){
                    System.out.println("有通道可写数据");
                }
                it.remove();
            }
        }
    }
}