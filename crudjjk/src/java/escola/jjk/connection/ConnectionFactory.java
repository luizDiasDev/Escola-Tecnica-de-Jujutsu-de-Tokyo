/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escola.jjk.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alunos
 */
public class ConnectionFactory {
    
    
    
    /*
    
    GLOSSÁRIO:
    
    static - serve para manter o valor do atributo na classe toda, 
    sem necessidade de declarar objetos.
    
    final - impede que esse atributo se repita em classes filhas.
    
    jdbc - Java Database Connectivity é uma API do Java que permite 
    que uma aplicação acesse um banco de dados.
    
    Class.forName - é um método Java que é usado para "carregar" uma classe na 
    memória JVM pelo nome, lendo o código que compõe a classe e alocando 
    espaço na memória para armazena-lo.
    
    */
    
    
    //nome do usuario do mysql
    private static final String USERNAME = "root";
    
    // senha do banco
    private static final String PASSWORD ="";
    
    //Caminho do BD,porta,nome do BD
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jujutsukaisenDB";
    
    /*
    * Conexão com o BD
    */
    
    public static Connection createConnectionToMySQL() throws ClassNotFoundException, SQLException{
        
        //Faz com que a classe seja carregada pela JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //cria a conexão com o BD
        Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
        
        return connection;
    }
    
    //filtrar se já existe alguma conexão ativa, para não ocupar espaço no sistema
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        
        //recuperar uma conexão com o banco de dados
        Connection con = createConnectionToMySQL();
        
        //Testar se a conexão é nula
        if(con!=null){
            System.out.println("Conexão obtida com sucesso!");
            con.close();
        }
        
    }
    
}
