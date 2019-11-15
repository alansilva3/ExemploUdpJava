package br.ufs.dcomp.ExemploUdpJava; 

import java.net.*;
import java.util.Scanner;

public class Chat {
    
    protected static void sendMessage(String msg, int destination_port, DatagramSocket socket) throws SocketException {
        try {
            byte[] msg_buf = msg.getBytes();
            int msg_size = msg_buf.length;
            InetAddress destination_address = InetAddress.getLocalHost();//Pegar o ip da maquina local (cloud9)

            System.out.print("[ Montando datagrama UDP  ..................  ");
            DatagramPacket pack = new DatagramPacket(msg_buf, msg_size, destination_address, destination_port);
            System.out.println("[OK] ]");
            
            System.out.print("[ Enviando datagrama UDP  ..................  ");
            socket.send(pack);
            System.out.println("[OK] ]");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    protected static void receiveMessage(DatagramSocket socket) throws SocketException {
        try {
            byte[] buf = new byte[20];//define o tamanho do pacote q vai receber
            DatagramPacket pack = new DatagramPacket(buf, buf.length);
            
            System.out.print("[ Aguardando recebimento de mensagem  ..................  ");
            socket.receive(pack);//operação bloqueante
            System.out.println("[OK] ]");
            
            byte[] received_data = pack.getData();
            String received_msg = new String(received_data); 
            InetAddress origin_address = pack.getAddress();
            int origin_port = pack.getPort();
            
            System.out.println("  Mensagem:             "+received_msg);
            System.out.println("  Endereço de origem:   "+origin_address.getHostAddress());
            System.out.println("  Porta de origem:      "+origin_port);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    protected static String writeMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escreva uma nova mensagem:");
        System.out.print(">>> ");
        String msg = sc.nextLine();
        
        return msg;
    }
}