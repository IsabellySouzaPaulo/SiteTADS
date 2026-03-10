/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.HeadlessException;
import java.sql.Connection;
import jdbc.ModuloConexao;
import model.Pedido;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class PedidoDAO {
    
    private Connection con;
    /**
     * Método responsável por adicionar um novo Pedido
     */
    public void adicionarPedido(Pedido obj) {

        try {
            //1 passo - criar o sql
            String sql = "insert into pedidos(id_cliente, status, valor_total, observacoes ) values(?,?,?,?)";
            //2 passo o conectar o banco de dados e organizar o comando sql
            con = ModuloConexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCliente().getId());
            stmt.setString(2, obj.getStatus());
            stmt.setDouble(3, obj.getTotal());
            stmt.setString(4, obj.getObservacoes());
            
            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso!!");

        }catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
    

}
