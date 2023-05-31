package com.crudprodutos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crudprodutos.bean.Produto;

public class ProdutoDao {

    public static Connection getConnection() {
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_produto", "root", "123456");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static List<Produto> getAllProdutos() {
        List<Produto> list = new ArrayList<Produto>();
        
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM produto");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("codigo"));
                produto.setDescricao(rs.getString("descricao"));
                list.add(produto);
            }
            
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return list;
    }

    public static Produto getProdutoById(int codigo) {
        Produto produto = null;
        
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM produto WHERE codigo=?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                produto = new Produto();
                produto.setCodigo(rs.getInt("codigo"));
                produto.setDescricao(rs.getString("descricao"));
            }
            
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return produto;
    }

    public static void addProduto(Produto produto) {
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO produto (descricao) VALUES (?)");
            ps.setString(1, produto.getDescricao());
            ps.executeUpdate();
            
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updateProduto(Produto produto) {
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE produto SET descricao=? WHERE codigo=?");
            ps.setString(1, produto.getDescricao());
            ps.setInt(2, produto.getCodigo());
            ps.executeUpdate();
            
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteProduto(int codigo) {
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM produto WHERE codigo=?");
            ps.setInt(1, codigo);
            ps.executeUpdate();
            
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
