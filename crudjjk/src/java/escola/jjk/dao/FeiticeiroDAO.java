/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escola.jjk.dao;

import escola.jjk.connection.ConnectionFactory;
import escola.jjk.model.Feiticeiro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Luiz
 */
public class FeiticeiroDAO {
    
    
    /*
    *CRUD
    
    *C.reate
    *R.ead
    *U.pdate
    *D.elete
    
    */
    
    
    
    
    /*
    GLOSSÁRIO
    
    PreparedStatement - o driver JDBC envia a consulta SQL sem os parâmetros 
    para ser compilada pelo servidor de banco de dados. Ao executar a instrução 
    com os parâmetros definidos, o driver enviará apenas os valores e solicitará
    a execução da consulta a partir do cache.
    
    Query - é uma solicitação de informações feita a um banco de dados. No 
    contexto da programação, uma query é são usada para recuperar, inserir, 
    atualizar ou excluir dados de uma ou mais tabelas em um banco de dados.
    
    */
    
    //Inserir valores no banco
    public void save(Feiticeiro feiticeiro) throws ClassNotFoundException, SQLException{
        
        String sql = "INSERT INTO feiticeiros(nome,grau,tecnica_inata,periodo_escolar) values(?,?,?,?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            //criar uma conexão com o BD
            conn = ConnectionFactory.createConnectionToMySQL();
            //Cria uma PreparedStatement para executar uma query
            pstm = conn.prepareStatement(sql);
            //adicionar os valores que são esperados pela query
            pstm.setString(1,feiticeiro.getNome());
            pstm.setString(2,feiticeiro.getGrau());
            pstm.setString(3,feiticeiro.getTecnica_inata());
            pstm.setString(4,feiticeiro.getPeriodo_escolar());
            
            //Executar a query
            pstm.execute();
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //Fechar as conexões
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }    
            }catch(Exception e){
                e.printStackTrace();
            
            }
        }
    }
    
}
