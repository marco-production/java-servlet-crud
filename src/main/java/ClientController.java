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
        List<Client> clients = new ClientDAO().toList();
        System.out.println("Clients: " + clients);
        
        req.setAttribute("clients", clients);
        req.setAttribute("totalBalance", ClientController.totalBalance(clients));
        req.setAttribute("totalClients", clients.size());
        req.getRequestDispatcher("clients.jsp").forward(req, res);
    }
    
    protected static double totalBalance(List<Client> clients) {
       double total = 0;
       
       for(Client client: clients){
           total =+ client.getBalance();
       }
       
       return total;
    }
}