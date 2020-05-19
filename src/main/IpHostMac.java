package main;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class IpHostMac {

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            NetworkInterface ni = NetworkInterface.getByInetAddress(address);
            byte[] mac = ni.getHardwareAddress();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            
            ImageIcon imagem = new ImageIcon("img.jpe");   
            JOptionPane.showMessageDialog(null, "Endereço IP: " + InetAddress.getLocalHost().getHostAddress() + "\nHostname: " + InetAddress.getLocalHost().getHostName() + "\nMac: " + sb.toString(), "Identificação Micro na rede", 0,imagem);
            //System.out.println(InetAddress.getLocalHost().getHostAddress());
            //System.out.println(InetAddress.getLocalHost().getHostName());
            //System.out.println(sb.toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    private static Object getToolkit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
