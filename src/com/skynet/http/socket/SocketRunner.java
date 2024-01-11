package com.skynet.http.socket;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;

public class SocketRunner {
    public static void main(String[] args) throws IOException {
        var inetAddresses = Inet4Address.getByName("google.com");
        try (Socket socket = new Socket(inetAddresses, 80);
             var outputStream = new DataOutputStream(socket.getOutputStream());
             var inputStream = new DataInputStream(socket.getInputStream())) {

            outputStream.writeUTF("Hello world!");
            byte[] response = inputStream.readAllBytes();
            System.out.println(response.length);
        }
    }
}
