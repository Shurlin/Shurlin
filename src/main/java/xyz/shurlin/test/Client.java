//package xyz.shurlin.test;
//
//import net.fabricmc.api.EnvType;
//import net.fabricmc.api.Environment;
//import net.minecraft.client.network.ClientPlayerEntity;
//
//import java.io.DataInputStream;
//import java.io.InputStream;
//import java.net.Socket;
//
//@Environment(EnvType.CLIENT)
//public class Client {
//    public Client(ClientPlayerEntity player) {
//        ClientThread thread = new ClientThread(player);
//        thread.start();
//    }
//
//    public static class ClientThread extends Thread{
//        private ClientPlayerEntity player;
//
//        ClientThread(ClientPlayerEntity player) {
//            this.player = player;
//        }
//
//        @Override
//        public void run() {
//            try {
//                Socket socket = new Socket("106.52.127.102", 7830);
//                InputStream inputStream = socket.getInputStream();
//                DataInputStream dataInputStream = new DataInputStream(inputStream);
//                while(true){
//                    player.sendChatMessage(dataInputStream.readUTF());
//                }
//
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//    }
//}
