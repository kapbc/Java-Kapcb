package com.kapcb.ccc.java.socket;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * <a>Title: SocketTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/18-14:32
 */
public class SocketTest {

    public static void main(String[] args) {
        try (Socket socket = new Socket("www.baidu.com", 443);
             Scanner scanner = new Scanner(socket.getInputStream(), StandardCharsets.UTF_8.toString());
        ) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
