/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import entity.Client;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ClientDAO;

/**
 *
 * @author marco
 */
@WebServlet("/ClientController")
public class ClientController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        ClientController.getClientList(req, res);
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
           total =+ client.getBalance();
       }
       
       return total;
    }
    
    protected static void getClientList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        List<Client> clients = new ClientDAO().toList();
        req.setAttribute("clients", clients);
        req.setAttribute("totalBalance", ClientController.totalBalance(clients));
        req.setAttribute("totalClients", clients.size());
        req.getRequestDispatcher("views/clients.jsp").forward(req, res);
    }
}