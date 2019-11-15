package br.ufs.dcomp.ExemploUdpJava;

import java.net.*;

public class AppUDP1 {

    public static void main(String[] args) throws SocketException {
        try{
            System.out.print("[ Alocando porta UDP      ..................  ");
    	    DatagramSocket socket = new DatagramSocket(10000);
            System.out.println("[OK] ]");
            
            while (true) {
                System.out.println();
                String msg = Chat.writeMessage();
                Chat.sendMessage(msg, 20000, socket);
                
                Chat.receiveMessage(socket); //Espera a resposta sempre
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
    }
}