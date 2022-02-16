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
import model.bean.transacao;
import model.bean.usuario;

/**
 *
 * @author SARA
 */
public class transacaoDAO {
    
    public void create(transacao t){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            
        try {
            stmt = con.prepareStatement("INSERT INTO transacao (netAmount, decription, asOnDate, isIncome) VALUES (?,?,?,?)");
            stmt.setBigDecimal(1, t.getNetAmount());
            stmt.setString(2, t.getDescription());
            stmt.setTimestamp(3, t.getAsOnDate());
            stmt.setBoolean(4, t.getIsIncome());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar:" + ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<transacao> read(){
        
        
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            List<transacao> transacaoList = new ArrayList();
            
        try {
            stmt = con.prepareStatement("SELECT * FROM transacao");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                transacao t = new transacao();
                
                t.setTransactionId(rs.getInt("expenseId"));
                t.setNetAmount(rs.getBigDecimal("netAmount"));
                t.setDescription(rs.getString("description"));
                t.setAsOnDate(rs.getTimestamp("asOnDate"));
                t.setIsIncome(rs.getBoolean("isIncome"));
                
                transacaoList.add(t);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return transacaoList;
    }
    
    public List<transacao> readForDesc(int id,String desc){
        
        
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            List<transacao> transacaoList = new ArrayList();
            
        try {
            stmt = con.prepareStatement("SELECT * FROM transacao WHERE userId = ?  AND description LIKE ? ");
            stmt.setInt(1, id);
            stmt.setString(2, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                transacao t = new transacao();
                
                t.setTransactionId(rs.getInt("expenseId"));
                t.setNetAmount(rs.getBigDecimal("netAmount"));
                t.setDescription(rs.getString("description"));
                t.setAsOnDate(rs.getTimestamp("asOnDate"));
                t.setIsIncome(rs.getBoolean("isIncome"));
                
                transacaoList.add(t);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return transacaoList;
    }
    public List<transacao> readForUser(usuario user){
        
        
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            List<transacao> transacaoList = new ArrayList();
            
        try {
            stmt = con.prepareStatement("SELECT * FROM transacao WHERE userId = ?");
            stmt.setInt(1, user.getUserId());
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                transacao t = new transacao();
                
                t.setTransactionId(rs.getInt("expenseId"));
                t.setNetAmount(rs.getBigDecimal("netAmount"));
                t.setDescription(rs.getString("description"));
                t.setAsOnDate(rs.getTimestamp("asOnDate"));
                t.setIsIncome(rs.getBoolean("isIncome"));
                
                transacaoList.add(t);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return transacaoList;
    }
    
    public void update(transacao t){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            
        try {
            stmt = con.prepareStatement("UPDATE usuario SET netAmount = ?, description = ?, asOnDate = ?, isIncome = ? WHERE transactionId = ?");
            stmt.setBigDecimal(1, t.getNetAmount());
            stmt.setString(2, t.getDescription());
            stmt.setTimestamp(3, t.getAsOnDate());
            stmt.setBoolean(4, t.getIsIncome());            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar:" + ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
        
    public void delete(transacao t){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            
        try {
            stmt = con.prepareStatement("DELETE FROM transacao WHERE transactionId = ?");
            stmt.setInt(1, t.getTransactionId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir:" + ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
