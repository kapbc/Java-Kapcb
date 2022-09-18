package com.kapcb.ccc.thread.output;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * <a>Title: PipedStream </a>
 * <a>Author: Kapcb <a>
 * <a>Description: PipedStream <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/13 9:52 PM
 * @since 1.0
 */
public class ByPipedStream {

    public static void main(String[] args) throws IOException {

        char[] aI = {'1', '2', '3', '4', '5', '6', '7'};
        char[] aC = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        PipedInputStream input1 = new PipedInputStream();
        PipedInputStream input2 = new PipedInputStream();

        PipedOutputStream output1 = new PipedOutputStream();
        PipedOutputStream output2 = new PipedOutputStream();

        input1.connect(output2);
        input2.connect(output1);

        String msg = "Your Turn";

        new Thread(() -> {

            byte[] buffer = new byte[9];

            try {
                for (char c : aI) {
                    input1.read(buffer);

                    if (new String(buffer).equals(msg)) {
                        System.out.println("Thread : " + Thread.currentThread().getName() + " output : [ " + c + " ]");
                    }

                    output1.write(msg.getBytes());
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }, "t1").start();

        new Thread(() -> {

            byte[] buffer = new byte[9];

            try {

                for (char c : aC) {

                    System.out.println("Thread : " + Thread.currentThread().getName() + " output : [ " + c + " ]");
                    output2.write(msg.getBytes());

                    if (new String(buffer).equals(msg)) {
                        continue;
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }, "t2").start();

    }

}
