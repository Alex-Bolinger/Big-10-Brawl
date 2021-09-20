import java.net.*;
import java.util.*;
import java.io.*;

public class GameServer {
    public ArrayList<Client> clients;

    public static void main(String[] args) {
        GameServer gs = new GameServer();
    }

    public GameServer() {
        try {
            ServerSocket ss = new ServerSocket(4040);
            clients = new ArrayList<>();
            while (true) {
                Socket s = ss.accept();
                clients.add(new Client(s));
                clients.get(clients.size() - 1).start();
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public int getClientCount() {
        return clients.size();
    }

    private class Client extends Thread {
        private Socket socket;

        public Client(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println(getClientCount());
        }
    }
}
