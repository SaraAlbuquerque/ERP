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
import model.bean.usuario;

/**
 *
 * @author SARA
 */
public class usuarioDAO {

    public void create(usuario u) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO usuario (userName, userPassword, recoveryAnswer, recoveryEmail) VALUES (?,?,?,?)");
            stmt.setString(1, u.getUserName());
            stmt.setString(2, u.getPassword());
            stmt.setString(3, u.getRecoveryAnswer());
            stmt.setString(4, u.getRecoveryEmail());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar:" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<usuario> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<usuario> usuarios = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();

            while (rs.next()) {

                usuario user = new usuario();

                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setRecoveryAnswer(rs.getString("recoveryAnswer"));
                user.setRecoveryEmail(rs.getString("recoveryEmail"));

                usuarios.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return usuarios;
    }

    public void update(usuario u) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE usuario SET userName = ?, userPassword = ?, recoveryAnswer = ?, recoveryEmail = ? WHERE userId = ?");
            stmt.setString(1, u.getUserName());
            stmt.setString(2, u.getPassword());
            stmt.setString(3, u.getRecoveryAnswer());
            stmt.setString(4, u.getRecoveryEmail());
            stmt.setInt(5, u.getUserId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar:" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(usuario u) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM usuario WHERE userId = ?");
            stmt.setInt(1, u.getUserId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir:" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public Boolean checkLogin(int id, String pass) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Boolean check = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE userId = ? AND userPassword = ?");
            stmt.setInt(1, id);
            stmt.setString(2, pass);
            rs = stmt.executeQuery();

            if (!rs.wasNull()) {

                check = true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;
    }

    public usuario readOne(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        usuario user = new usuario();

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE userId = ? AND userPassword = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            user.setUserId(rs.getInt("userId"));
            user.setUserName(rs.getString("userName"));
            user.setPassword(rs.getString("password"));
            user.setRecoveryAnswer(rs.getString("recoveryAnswer"));
            user.setRecoveryEmail(rs.getString("recoveryEmail"));

        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return user;
    }
}
