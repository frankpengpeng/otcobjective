package com.frank.practice.nio.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.Random;

public class ChannelTransfor {
    public static void main(String[] args) throws IOException {
        URL fromUrl = Thread.currentThread().getContextClassLoader().getResource("FromChannelFile.txt");

        RandomAccessFile fromFile = new RandomAccessFile(fromUrl.getFile(), "rw");
        URL toUrl = Thread.currentThread().getContextClassLoader().getResource("ToChannelFile.txt");

        RandomAccessFile toFile = new RandomAccessFile(toUrl.getFile(), "rw");

        FileChannel fromChannel = fromFile.getChannel();
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();
        fromChannel.transferTo(position,count, toChannel);

        toChannel.transferFrom(fromChannel,position, count);
    }
}
