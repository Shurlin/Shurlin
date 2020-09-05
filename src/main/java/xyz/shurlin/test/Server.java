//package xyz.shurlin.test;
//
//import net.fabricmc.api.EnvType;
//import net.fabricmc.api.Environment;
//
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//@Environment(EnvType.SERVER)
//public class Server {
//
//    public Server() {
//        ServerThread thread = new ServerThread();
//        thread.start();
//    }
//
//    public static class ServerThread extends Thread{
//        @Override
//        public void run() {
//            try {
//                ServerSocket serverSocket = new ServerSocket(7830);
//                Socket socket = serverSocket.accept();
//                InputStream inputStream = socket.getInputStream();
//                OutputStream outputStream = socket.getOutputStream();
//                DataInputStream dataInputStream = new DataInputStream(inputStream);
//                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//    }
//}
