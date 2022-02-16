/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.despesas;

/**
 *
 * @author SARA
 */
public class enderecoDAO {
    
        public void create(despesas d){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            
        try {
            stmt = con.prepareStatement("INSERT INTO despesas (expenseAmount, spendOnDate, note) VALUES (?,?,?)");
            stmt.setBigDecimal(1, d.getExpenseAmount());
            stmt.setDate(2, d.getSpendOnDate());
            stmt.setString(3, d.getNote());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar:" + ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<despesas> read(){
        
        
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            List<despesas> despesasList = new ArrayList();
            
        try {
            stmt = con.prepareStatement("SELECT * FROM despesas");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                despesas d = new despesas();
                
                d.setExpenseId(rs.getInt("expenseId"));
                d.setExpenseAmount(rs.getBigDecimal("expenseAmount"));
                d.setSpendOnDate(rs.getDate("spendOnDate"));
                d.setNote(rs.getString("note"));
                
                despesasList.add(d);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return despesasList;
    }
    
    public void update(despesas d){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            
        try {
            stmt = con.prepareStatement("UPDATE usuario SET expenseAmount = ?, spendOnDate = ?, note = ? WHERE expenseId = ?");
            stmt.setBigDecimal(1, d.getExpenseAmount());
            stmt.setDate(2, d.getSpendOnDate());
            stmt.setString(3, d.getNote());
            stmt.setInt(4, d.getExpenseId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar:" + ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
        
    public void delete(despesas d){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            
        try {
            stmt = con.prepareStatement("DELETE FROM despesas WHERE expenseId = ?");
            stmt.setInt(1, d.getExpenseId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir:" + ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
