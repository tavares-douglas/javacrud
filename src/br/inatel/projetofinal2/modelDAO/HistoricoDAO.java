package br.inatel.projetofinal2.modelDAO;

import br.inatel.projetofinal2.model.Historico;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class HistoricoDAO extends EntidadeDAO{
    
    public void inserirHistorico(Historico novoHistorico){
        //CONEXÃO COM O BANCO DE DADOS
        cntDB();
        //PASSAGEM DO COMANDO SQL
        String sql = "INSERT INTO Historico VALUES(?,?,?,?,?,?,?)";
        
        try{
            //ATRIBUIÇÃO DOS PARAMETROS REFERENCIADOS POR ? NO COMANDO SQL
            ps = cnt.prepareStatement(sql);
            ps.setString(1,novoHistorico.getId());
            ps.setString(2,novoHistorico.getMassa());
            ps.setString(3,novoHistorico.getAltura());
            ps.setString(4,novoHistorico.getTipoSanguineo());
            ps.setBoolean(5,novoHistorico.isFumante());
            ps.setBoolean(6,novoHistorico.isAlcool());
            ps.setString(7,novoHistorico.getPacienteCpf());
            ps.execute();
            
        }catch(SQLException e){
            
            System.out.println("Erro: " + e.getMessage());
            
        }finally{
            
            try{
                //FECHAMENTO DA CONEXAO
                cnt.close();
                //FECHAMENTO DA CONSULTA
                ps.close();
                
            }catch(SQLException e){
                
                System.out.println("Erro: " + e.getMessage());
               
            }
            
        }
    }
    //MÉTODO PARA VERIFICAÇÃO DA EXISTENCIA DE CPF 
    public boolean verificaCpf(String cpf){
        //ATRIBUIÇÃO DE VALOR INICIAL DA VARIAVEL DE VERIFICAÇÃO
        boolean found = false;
        //CONEXÃO COM O BANCO DE DADOS
        cntDB();
        //COMANDO SQL DE VERIFICAÇÃO
        String sql = "SELECT 1 FROM Historico WHERE Paciente_cpf = ?";
        int aux;
        try{
            //ATRIBUIÇÃO DOS VALOR DO VALOR REFERIDO POR ? AO COMANDO SQL
            ps = cnt.prepareStatement(sql);
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            
            //LAÇO WHILE PERCORRE OS REGISTROS DO BD ENQUANTO HOUVER UM REGISTRO SEGUINTE
            while(rs.next()){
                
                //ATRIBUIÇÃO DO REGISTRO A VARIAVEL AUXILIAR
                aux = rs.getRow();
                if(aux != 0) //VERIFICACAO
                    found = true; //CASO O CPF SEJA ENCONTRADO
                
                else found = false; //CASO NAO SEJA
                
            }
            
        }catch(SQLException ex){
            
            System.out.println("Erro: " + ex.getMessage());
            
        }finally{
            
            try{
                //FECHAMENTO DO BD
                cnt.close();
                //FECHAMENTO DA CONSULTA
                ps.close();
                
                
            }catch(SQLException ex){
                
                System.out.println("Erro: " + ex.getMessage());
                
            }
            
        }
        
        //RETORNO DA VARIAVEL CONTIDO O RESULTADO DA VERIFICAÇÃO
        return found;
        
    }
    //METODO DE VERIFICACAO DE ID
    public boolean verificaId(String id){
        //ATRIBUIÇÃO DA VARIAVEL AUXILIAR COM O RETORNO 
        boolean found = false;
        //CONEXÃO COM BANCO DE DADOS
        cntDB();
        //COMANDO SQL A SER PASSADO NA CONSULTA
        String sql = "SELECT 1 FROM Historico WHERE idHistorico = ?";
        int aux;
        try{
            //ATRIBUIÇÃO DA CONSULTA AO BD
            ps = cnt.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            
            //LAÇO WHILE PARA PERCORRER CONJUNTO DE RESULTADOS
            //PERCORRE ENQUANTO OUVER RESULTADO A FRENTE
            while(rs.next()){
                //ATRIBUIÇÃO DO REGISTRO A VARIAVEL AUXILIAR
                aux = rs.getRow();
                if(aux != 0)
                    found = true;
                
                else found = false;
                
            }
            
        }catch(SQLException ex){
            
            System.out.println("Erro: " + ex.getMessage());
            
        }finally{
            
            try{
                
                cnt.close();
                ps.close();
                
            }catch(SQLException ex){
                
                System.out.println("Erro: " + ex.getMessage());
                
            }
            
        }
        
        
        return found;
        
    }
    
    public void excluirHistorico(String id){
        
        cntDB();
        
        String sql = "DELETE FROM Historico WHERE idHistorico = ?";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1,id);
            ps.execute();
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            
        }finally{
            
            try{
                
                cnt.close();
                ps.close();
                
            }catch(SQLException e){
                
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                
            }
            
        }
    }
    
    public ArrayList<Historico> buscaHistoricos(){
        
        ArrayList<Historico> listaHistorico = new ArrayList<>();
        
        cntDB();
        
        String sql = "SELECT * FROM Historico";
        
        try{
            
            s = cnt.createStatement();
            rs = s.executeQuery(sql);
            while(rs.next()){
                
                Historico temp = new Historico(rs.getString("idHistorico"),rs.getString("massa")
                , rs.getString("altura"), rs.getString("tipoSanguineo"),rs.getBoolean("fumante"),
                rs.getBoolean("alcool"),rs.getString("Paciente_cpf"));
                
                listaHistorico.add(temp);
                
            }
            
        }catch(SQLException ex){
            
            System.out.println("Erro: " + ex.getMessage());
            
        }finally{
            
            try{
                
                cnt.close();
                s.close();
                
            }catch(SQLException ex){
                
                System.out.println("Erro: " + ex.getMessage());
                
            }
            
        }
        return listaHistorico;
    }
}
