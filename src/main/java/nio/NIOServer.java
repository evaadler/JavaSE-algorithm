package nio;

import org.omg.CORBA.NO_IMPLEMENT;

import java.io.*;
import java.net.ServerSocket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class NIOServer {
    // 通道管理器
    private Selector selector;

    public void handlerRead(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        channel.read(buffer);

        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("服务端收到消息： "+ msg);

        // 回写数据
        ByteBuffer outBuffer = ByteBuffer.wrap("好的".getBytes());
        channel.write(outBuffer);
    }

    public void handler(SelectionKey key) throws IOException {
        //System.out.println();

        // 客户端请求链接事件
        if(key.isAcceptable()){
            handlerAccept(key);
            // 获得了刻度的事件
        }else if (key.isReadable()){
            handlerRead(key);
        }
    }

    private void handlerAccept(SelectionKey key) throws IOException {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        // 获得和客户端链接的通道
        SocketChannel channel = server.accept();

        // 设置成非阻塞
        channel.configureBlocking(false);

        // 在这里可以给客户端发送信息哦
        System.out.println("新的客户端链接");

        // 在和客户端链接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限
        // OP_Write 表示底层缓冲区是否有空间，是则响应返回true
        channel.register(this.selector, SelectionKey.OP_READ);
    }

    /**
     * 采用轮询的方式监听selector是是否有需要处理的事件，如有，则处理
     * @throws IOException
     */
    public void listen() throws IOException {
        System.out.println("服务端启动成功！");

        while (true) {
            selector.select();

            Iterator<?> ite = this.selector.selectedKeys().iterator();

            while (ite.hasNext()){
                SelectionKey key = (SelectionKey) ite.next();
                // 删除已选的key，以防重复处理
                ite.remove();

                handler(key);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        NIOServer server = new NIOServer();
        //server.initServer(8000);
        server.listen();

    }



    class InfoBean implements Cloneable {
        public String name;
        public int age;

    }
}




