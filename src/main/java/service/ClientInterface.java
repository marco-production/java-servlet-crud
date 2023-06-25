/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import entity.Client;
import java.util.List;

/**
 *
 * @author marco
 */
public interface ClientInterface {
    
    int toAdd(Client client);
    
    Client toShow(int id);
    
    List<Client> toList();
    
    int toUpdate(Client client);
    
    int toDelete(int id);
}
