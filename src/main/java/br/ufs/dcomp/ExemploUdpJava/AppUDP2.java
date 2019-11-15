package br.ufs.dcomp.ExemploUdpJava; 

import java.net.*;

public class AppUDP2 {

    public static void main(String[] args) throws SocketException {
        try{

            System.out.print("[ Alocando porta UDP                  ..................  ");
    	    DatagramSocket socket = new DatagramSocket(20000);
            System.out.println("[OK] ]");
            
            Chat.receiveMessage(socket);
            
            while (true) {
                System.out.println();
                String msg = Chat.writeMessage();
                Chat.sendMessage(msg, 10000, socket);
                
                Chat.receiveMessage(socket);
            }
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}