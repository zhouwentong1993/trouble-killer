package com.wentong;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.nio.charset.StandardCharsets;

public class Client {

    public static void main(String[] args) throws Exception {
//        for (int i = 0; i < 50000; i++) { // 连接5次
//            System.out.println("第 " + i + " 次连接");

            NioEventLoopGroup group = new NioEventLoopGroup();
            try {
                Bootstrap bootstrap = new Bootstrap().group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ch.pipeline().addLast(new EchoClientHandler());
                    }
                });
                ChannelFuture future = bootstrap.connect("localhost", 8080).sync();
//                future.channel().closeFuture().sync();
            } finally {
                group.shutdownGracefully();
            }
//        }


    }

    static class EchoClientHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelActive(ChannelHandlerContext ctx) {
            ByteBuf message = Unpooled.copiedBuffer("Hello, Netty!", StandardCharsets.UTF_8);
            ctx.writeAndFlush(message);

        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            ByteBuf byteBuf = (ByteBuf) msg;
            System.out.println("Received from server: " + byteBuf.toString(StandardCharsets.UTF_8));
            byteBuf.release();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            cause.printStackTrace();
            ctx.close();
        }
    }
}
