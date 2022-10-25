import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
 
public class Chate_Cliente {
    private Socket clientSocket;
    private static final String SERVIDOR_IP = "127.0.0.1";
    private Scanner scanner;
    private BufferedWriter out;
    
    public Chate_Cliente(){
        scanner = new Scanner(System.in);
    }
    
    public void start() throws IOException{
        String msg;
        do{
        clientSocket = new Socket(SERVIDOR_IP, Chate_Servidor.PORT);
        this.out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        System.out.println(
                "Cliente conectado ao servidor em " + SERVIDOR_IP + " na porta : "+Chate_Servidor.PORT);
        System.out.print("Digite uma mensagem para o servidor, ou fim para encerrar essa aplicação:");
        msg = scanner.nextLine();
        out.write(msg);
        out.newLine();
        out.flush();
        }while(!msg.equalsIgnoreCase("fim"));
    }
    public static void main(String[] args) {
        try{
            Chate_Cliente cliente = new Chate_Cliente();
            cliente.start();
        } catch (IOException ex){
            System.out.println("Erro ao iniciar o cliente.");
        }
        System.out.println("Cliente finalizado!");
    }  
}
 
