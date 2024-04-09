package org.mario.controller;

import org.mario.Connect;
import org.mario.interfaces.ICrud;
import org.mario.model.Contato;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoController implements ICrud<Contato> {

    @Override
    public Contato create(Contato contato) {
        try{
            var con = Connect.conectar();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO tb_contatos(nome,email,fone)values(?,?,?)");
            pstm.setString(1, contato.getNome());
            pstm.setString(2,contato.getEmail());
            pstm.setString(3, contato.getFone());
            pstm.execute();
            System.out.println("Contato cadastrado com sucesso");
            Connect.desconectar(con);
        } catch(SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }
        return contato;
    }

    @Override
    public Contato delete(Integer id) {
        try{
            var con = Connect.conectar();
            PreparedStatement pstm = con.prepareStatement("DELETE FROM tb_contatos WHERE id=?");
            pstm.setInt(1,id);
            Contato contato = getById(id);
            pstm.execute();
            System.out.println("Contado deletado.");
            Connect.desconectar(con);
            return contato;
        } catch (SQLException e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Contato getById(Integer id) {
        try{
            var con = Connect.conectar();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM tb_contatos WHERE id=?");
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            Contato contato = new Contato();
            while(rs.next()){
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setFone(rs.getString("fone"));
            }
            Connect.desconectar(con);
            return contato;
        } catch (SQLException e){
            System.out.println("Erro: " + e.getMessage());
            return null;
            }
        }


    @Override
    public List<Contato> getAll() {
        try{
            var con = Connect.conectar();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM tb_contatos");

            ResultSet rs = pstm.executeQuery();
            List<Contato> contatos = new ArrayList<Contato>();
            while(rs.next()){
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setFone(rs.getString("fone"));
                contatos.add(contato);
            }
            Connect.desconectar(con);
            return contatos;
        } catch (SQLException e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Contato update(Contato contato, Integer id) {
        try{
            var con = Connect.conectar();
            PreparedStatement pstm = con.prepareStatement("update tb_contatos set nome=?, email=?, fone=? where id=?");
            pstm.setString(1, contato.getNome());
            pstm.setString(2,contato.getEmail());
            pstm.setString(3, contato.getFone());
            pstm.setInt(4, id);
            pstm.execute();
            System.out.println("Contato atualizado com sucesso");
            Connect.desconectar(con);
            return contato;
        } catch(SQLException e){
            System.out.println("Erro: " + e.getMessage());
            return contato;
        }


    }

}
