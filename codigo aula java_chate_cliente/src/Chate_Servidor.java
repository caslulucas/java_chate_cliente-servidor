import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Chate_Servidor {
    public static final int PORT = 4000;
    public ServerSocket serverSocket;
    public void start() throws IOException{
        serverSocket = new ServerSocket(PORT);
        System.out.println("Servidor Iniciado na porta " + PORT);
        String xmsg;
        xmsg = "vazio";
        do{
        
            Socket clienteSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            System.out.println("Cliente :" + clienteSocket.getRemoteSocketAddress());
            String msg = in.readLine();
            System.out.println("Mensagem recebida :"+msg);
            xmsg = msg;
        }while(!xmsg.equalsIgnoreCase("fim"));
    }
    
    public static void main(String[] args) {
        try {
        Chate_Servidor server = new Chate_Servidor();
        server.start();
        } catch(IOException ex){
            System.out.println("Erro ao iniciar o servidor");
        }
        System.out.println("Servidor Finalizado");
    }
    
}
