package com.wentong;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RouterServerHandler extends ChannelInboundHandlerAdapter {

    static ExecutorService executorService = Executors.newSingleThreadExecutor();
    PooledByteBufAllocator allocator = new PooledByteBufAllocator(false);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf reqMsg = (ByteBuf) msg;
        System.out.println("收到请求~");
        byte[] body = new byte[reqMsg.readableBytes()];
        executorService.execute(() -> {
            //解析请求消息，做路由转发，代码省略
            //转发成功，返回响应给客户端
            ByteBuf respMsg = allocator.heapBuffer(body.length);
            respMsg.writeBytes(body);//作为示例，简化处理，将请求返回
            ctx.writeAndFlush(respMsg);
            System.out.println("转发成功~");
        });
    }
}
