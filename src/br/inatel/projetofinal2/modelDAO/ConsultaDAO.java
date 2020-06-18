package br.inatel.projetofinal2.modelDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.inatel.projetofinal2.model.Consulta;

public class ConsultaDAO extends EntidadeDAO{

    //MÉTODO INSERIR CONSULTA
    public void inserirConsulta(Consulta novaConsulta){
        //CONEXÃO COM O BANCO DE DADOS
        cntDB();
        //STRING REFERENCIANDO OS OBJETOS A SEREM INSERIDOS NO BD COM ?
        String sql = "INSERT INTO Consulta(Medico_crm,Paciente_cpf,dataC,horario)"
                + " VALUES(?,?,?,?)";
        
        try{
            //OBJETO PS HERDADO DE EntidadeDAO
            //PASSAGEM DO OBJETO AO BANCO PELA CONEXÃO
            ps = cnt.prepareStatement(sql);
            //SETAGEM DOS DADOS NA ENTIDADE CONSULTA DO BANCO
            //ATRIBUIÇÃO DOS PARAMETROS REFERENCIADOS POR ? NO COMANDO SQL 
            ps.setString(1,novaConsulta.getCrmMedico());
            ps.setString(2,novaConsulta.getCpfPaciente());
            ps.setString(3,novaConsulta.getData());
            ps.setString(4,novaConsulta.getHorario());
            ps.execute();
            
        }catch(SQLException e){
            
            System.out.println("Erro: " + e.getMessage());
            
        }finally{
            
            try{
                //FECHAMENTO DO BANCO E CONSULTA
                cnt.close();
                ps.close();
                
            }catch(SQLException e){
                
                System.out.println("Erro: " + e.getMessage());
               
            }
            
        }
    }
    
    public ArrayList<Consulta> buscaConsultas(){
        
        //ARRAYLIST AUXILIAR DE CONSULTAS
        ArrayList<Consulta> listaConsultas = new ArrayList<>();
        
        //CONEXÃO COM O BD
        cntDB();
        
        //COMANDO A SER EXECUTADO NA QUERY
        String sql = "SELECT * FROM Consulta";
        
        try{
            
            //CRIAÇÃO DO OBJETO DE CONSULTA CONECTADO AO BD
            s = cnt.createStatement();
            //CRIAÇÃO DO OBJETO RESULTADO DE CONSULTA EXECUTANDO MÉTODO DE CONSULTA NA QUERY
            rs = s.executeQuery(sql);
            //LAÇO WHILE PERCORRENDO O BD ENQUANTO EXISTIR UM RESULTADO A FRENTE
            while(rs.next()){
                //PARA TODO RESULTADO A FRENTE CRIA-SE UMA NOVA CONSULTA TEMPORÁRIA
                Consulta temp = new Consulta(rs.getString("Medico_crm"),rs.getString("Paciente_cpf")
                , rs.getString("dataC"), rs.getString("horario"));
                
                //ADIÇÃO DESSA CONSULTA NO ARRAYLIST AUXILIAR
                listaConsultas.add(temp);
                
            }
            
        }catch(SQLException ex){
            
            System.out.println("Erro: " + ex.getMessage());
            
        }finally{
            
            try{
                //FECHAMENTO DA CONEXÃO
                cnt.close();
                //FECHAMENTO DA CONSULTA
                s.close();
                
            }catch(SQLException ex){
                
                System.out.println("Erro: " + ex.getMessage());
                
            }
            
        }
        //RETORNO DA LISTA DE CONSULTAS
        return listaConsultas;
    }
    
    //MÉTODO DE EXCLUSÃO DE CONSULTA LEVANDO EM CONSIDERAÇÃO CPF E CRM
    public void excluirConsulta(String cpf, String crm){
        //CONEXÃO COM O BD
        cntDB();
        //COMANDO SQL
        String sql = "DELETE FROM Consulta WHERE Paciente_cpf = ? AND Medico_crm = ?";
        
        try{
            //ATRIUIÇÃO DOS PARAMETROS REFERENCIADOS POR ?
            //NO COMANDO SQL
            ps = cnt.prepareStatement(sql);
            ps.setString(1,cpf);
            ps.setString(2,crm);
            ps.execute();
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            
        }finally{
            
            try{
                //FECHAMENTO DO BANCO DE DADOS
                cnt.close();
                //FECHAMENTO DO OBJETO DE CONSULTA
                ps.close();
                
            }catch(SQLException e){
                
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                
            }
            
        }
    }
    
}
