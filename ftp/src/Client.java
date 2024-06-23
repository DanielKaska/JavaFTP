import java.io.*;
import java.net.Socket;

public class Client {
    static Socket socket;
    static PrintWriter sender;
    static DataOutputStream dataOutputStream;
    static String fileName;

    public static void main(String[] args) {
        try{
            //connection configuration
            socket = new Socket("127.0.0.1", 8080);

            //output stream
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            //set file name and send it to server
            fileName = "ftp.iml";
            dataOutputStream.writeChars(fileName);

            //create a file, and input stream
            File file = new File(fileName);
            FileInputStream fileInput = new FileInputStream(file);

            int fileByte;

            //read every byte from the file and send it to server
            while((fileByte = fileInput.read()) > 0){
                dataOutputStream.writeByte(fileByte);
                dataOutputStream.flush();
            }

            //close the connection
            socket.close();
            dataOutputStream.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}