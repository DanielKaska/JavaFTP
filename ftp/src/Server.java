import java.io.*;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args){

        try{
            ServerSocket server = new ServerSocket(8080);

            while(true){
                var client = server.accept();
                var dataInputStream = new DataInputStream(client.getInputStream());

                var fileName = new String(String.valueOf(dataInputStream.read()));

                System.out.println(fileName);
                FileOutputStream f = new FileOutputStream(fileName);

                //byte
                int b;
                //read byte from input stream and write it to file
                while((b = dataInputStream.read()) > 0){
                    f.write(b);
                }

                //disconnect client, close file output stream
                client.close();
                f.close();

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
