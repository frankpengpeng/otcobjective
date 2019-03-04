package com.frank.practice.nio.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelSample {

    public static void main(String[] args) throws IOException {
        URL file = Thread.currentThread().getContextClassLoader().getResource("FileChannelResource.txt");
        System.out.println(file.getFile());
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile(file.getFile(), "rw");
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            int byteReader = fileChannel.read(byteBuffer);
            while (byteReader != -1){
                System.out.println("Read:" + byteReader);
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()){
                    System.out.println((char)byteBuffer.get());
                }
                byteBuffer.clear();
                byteBuffer.compact();
                byteReader = fileChannel.read(byteBuffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            aFile.close();
        }
    }
}
