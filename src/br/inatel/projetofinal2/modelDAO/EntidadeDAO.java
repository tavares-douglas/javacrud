package br.inatel.projetofinal2.modelDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EntidadeDAO {

    //OBJETO DE CONEXÃO
    Connection cnt;
    //OBJETO DE CONSULTA OTIMIZADA
    PreparedStatement ps;
    //OBJETO DE CONSULTA PADRÃO
    Statement s;
    //CONJUNTO DE RESULTADOS
    ResultSet rs;
    
    //DADOS DO BANCO A SER CONECTADO
    String database = "Projeto2";
    String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    String user = "root";
    String password = "poalegre4";
    
    
    //CLASSE DE CONEXÃO COM O BANCO DE DADOS
    public void cntDB(){
        
        try{
            //PROMOVENDO A CONEXÃO COM OS DADOS DO BANCO INFORMADOS ACIMA
            cnt = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão bem sucedida!");
            
        }catch(SQLException e){
            
            System.out.println("Erro: " + e.getMessage());
            
        }
    }
    
  
}
