package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by caoquan on 3/21/17.
 */
public class LocationServer {
    public static final int PORT = 55555;
    private ServerSocket serverSocket;
    private int port;
    private ExecutorService pool;
    private CompanyLocation companyLocation;


    LocationServer(int port) {
        this.companyLocation = new CompanyLocation();
        this.port = port;
        try {
            this.serverSocket = new ServerSocket(this.port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        pool = Executors.newFixedThreadPool(15);
    }

    public void start() {
        System.out.println("Server is listening at port " + this.port);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Accept");
                LocationSlave slave = new LocationSlave(socket.getInputStream(), this.companyLocation);
                pool.execute(slave);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        LocationServer server = new LocationServer(PORT);
        server.start();
    }
}
