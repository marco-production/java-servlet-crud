/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import data.Conexion;
import entity.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class ClientDAO implements ClientInterface {

    private static final String SQL_SELECT = "SELECT * FROM clients";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM clients WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO clients(name, lastname, email, phone_number, balance) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE clients SET name=?, lastname=?, email=?, phone_number=?, balance=? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM clients WHERE id = ?";

    @Override
    public int toAdd(Client client) {
        Connection cn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            cn = Conexion.getConnection();
            stmt = cn.prepareStatement(SQL_INSERT);
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getLastname());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getPhoneNumber());
            stmt.setDouble(5, client.getBalance());

            stmt.executeQuery();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(cn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return rows;
    }

    @Override
    public Client toShow(Client client) {
        Connection cn = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;

        try {
            cn = Conexion.getConnection();
            stmt = cn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, client.getId());
            resultSet = stmt.executeQuery();

            // Nos posicionamos en el elemento 1.
            resultSet.absolute(1);

            String name = resultSet.getString("name"),
                    lastname = resultSet.getString("lastname"),
                    email = resultSet.getString("email"),
                    phoneNumber = resultSet.getString("phone_number");

            double balance = resultSet.getDouble("balance");

            Timestamp createdAt = resultSet.getTimestamp("created_at"),
                    updatedAt = resultSet.getTimestamp("updated_at");

            client.setName(name);
            client.setLastname(lastname);
            client.setEmail(email);
            client.setBalance(balance);
            client.setPhoneNumber(phoneNumber);
            client.setCreatedAt(createdAt);
            client.setUpdatedAt(updatedAt);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(resultSet);
                Conexion.close(stmt);
                Conexion.close(cn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return client;
    }

    @Override
    public List<Client> toList() {

        Connection cn = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        Client client;
        List<Client> clients = new ArrayList<>();

        try {
            cn = Conexion.getConnection();
            stmt = cn.prepareStatement(SQL_SELECT);
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");

                String name = resultSet.getString("name"),
                        lastname = resultSet.getString("lastname"),
                        email = resultSet.getString("email"),
                        phoneNumber = resultSet.getString("phone_number");

                double balance = resultSet.getDouble("balance");

                Timestamp createdAt = resultSet.getTimestamp("created_at"),
                        updatedAt = resultSet.getTimestamp("updated_at");

                // Create Object client
                client = new Client(id, name, lastname, email, phoneNumber, balance, createdAt, updatedAt);

                // Add client
                clients.add(client);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally {
            // Close conexion
            try {
                Conexion.close(resultSet);
                Conexion.close(stmt);
                Conexion.close(cn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return clients;
    }

    @Override
    public int toUpdate(Client client) {
        Connection cn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            cn = Conexion.getConnection();
            stmt = cn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getLastname());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getPhoneNumber());
            stmt.setDouble(5, client.getBalance());
            stmt.setInt(6, client.getId());

            stmt.executeQuery();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(cn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return rows;
    }

    @Override
    public int toDelete(Client client) {
        Connection cn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            cn = Conexion.getConnection();
            stmt = cn.prepareStatement(SQL_DELETE);
            stmt.setInt(6, client.getId());

            stmt.executeQuery();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(cn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return rows;
    }
}
