package com.wentong;

import io.netty.buffer.PooledByteBufAllocator;

import java.util.concurrent.TimeUnit;

public class TestMemoryAllocate {

    public static void main(String[] args) throws Exception {
        PooledByteBufAllocator allocator = new PooledByteBufAllocator(false);
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);

            allocator.heapBuffer("hello Netty.".length());
            TimeUnit.MILLISECONDS.sleep(100);
        }
    }

}
