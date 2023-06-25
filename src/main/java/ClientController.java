/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import entity.Client;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.ClientDAO;

/**
 *
 * @author marco
 */
@WebServlet("/ClientController")
public class ClientController extends HttpServlet implements Serializable  {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String id, delete;
        id = req.getParameter("id");
        delete = req.getParameter("delete");
        
        if ((id != null && !id.equals("0")) && (Boolean.parseBoolean(delete) == false)) {
            Client client = new ClientDAO().toShow(Integer.parseInt(id));
            
            req.setAttribute("client", client);
            req.getRequestDispatcher("views/show.jsp").forward(req, res);
            
        } else {
            if(Boolean.parseBoolean(delete) == true){
                System.out.println("ESTOY ADENTRO");
                new ClientDAO().toDelete(Integer.parseInt(id));
            }
            System.out.println("ESTOY AFUERA " + Boolean.parseBoolean(delete));
            ClientController.getClientList(req, res);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        String fisrtName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phoneNumber = !"".equals(req.getParameter("phoneNumber")) ? req.getParameter("phoneNumber") : null;
        double balance = !"".equals(req.getParameter("balance")) ? Double.parseDouble(req.getParameter("balance")) : 0;
        
        Client client = new Client(fisrtName, lastName, email, phoneNumber, balance);
        int clientDao = new ClientDAO().toAdd(client);
        
        System.out.println(client.toString());
        System.out.println("clientDao: " + clientDao);
        
        ClientController.getClientList(req, res);
    }
    
    protected static double totalBalance(List<Client> clients) {
       double total = 0;
       
       for(Client client: clients){
           total += client.getBalance();
       }
       
       return total;
    }
    
    protected static void getClientList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        List<Client> clients = new ClientDAO().toList();
        
        // Agregar en el alcance de session
        HttpSession session = req.getSession();
        
        session.setAttribute("clients", clients);
        session.setAttribute("totalBalance", ClientController.totalBalance(clients));
        session.setAttribute("totalClients", clients.size());
        
        res.sendRedirect("views/clients.jsp");
        
        // Agregar en el alcance de request
        /*req.setAttribute("clients", clients);
        req.setAttribute("totalBalance", ClientController.totalBalance(clients));
        req.setAttribute("totalClients", clients.size());
        req.getRequestDispatcher("views/clients.jsp").forward(req, res);*/
    }
}