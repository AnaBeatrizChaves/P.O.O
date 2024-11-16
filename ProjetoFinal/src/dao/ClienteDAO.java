package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;

public class ClienteDAO {
	    //Classes do banco de dados que serão implementadas com base na classe ConexaoFactory:
	    Connection con;
	    PreparedStatement ps;
	    ResultSet rs;
	    String sql;
	    
	    //Metodo Listar
	    public ArrayList<Cliente> getLista()throws SQLException{
	        ArrayList<Cliente> cliente = new ArrayList<>();
	        
	        //comando sql
	        sql = "SELECT id_usuario, nome, cpf, dataNascimento, telefone, endereco" +
	                "FROM cliente";
	        con = ConnectionFactory.conectar();
	        ps  = con.prepareStatement(sql);
	        rs = ps.executeQuery();
	        
	        //Buscando as informações no sql:
	        while(rs.next()){
	        Cliente c = new Cliente(0, null, null, null, null, null, null);
	        c.setId_usuario(rs.getInt("id_usuario"));
	        c.setNome(rs.getString("nome"));
	        c.setCpf(rs.getString("cpf"));
	        c.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
	        c.setTelefone(rs.getString("telefone"));
	        c.setEndereco(null);
	        c.setSenha(rs.getString("senha"));
	        
	        //grava as informações no:
	        cliente.add(c);
	    }
	        //Fecha a conexão:
	        ConnectionFactory.close(con);
	        return cliente;
	    }//Fim do método listar
	    
	    
	    //Metodo Gravar
	    public boolean gravar(Cliente c) throws SQLException{
	        con = ConnectionFactory.conectar();
	        
	        if(c.getIdCliente() == 0){
	            sql = "INSERT INTO cliente (nome, cpf, email, endereco, telefone, dataCadastro, status) "+
	                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
	            ps = con.prepareStatement(sql, 0);
	            //Vinculando os argumentos aos elementos
	            ps.setString(1, c.getNome());
	            ps.setString(2, c.getCpf());
	            ps.setString(3, c.getEmail());
	            ps.setString(4, c.getEndereco());
	            ps.setString(5, c.getTelefone());
	            ps.setDate(6, new Date(c.getDataCadastro().getTime()));
	            ps.setInt(7, c.getStatus());
	        }else{
	            sql = "UPDATE cliente set nome = ?, cpf = ?, email = ?, endereco = ?, telefone = ?, dataCadastro = ?, status = ? "+
	                    "WHERE idCliente = ?";
	            ps = con.prepareStatement(sql);
	            //Vinculando os argumentos aos elementos
	            ps.setString(1, c.getNome());
	            ps.setString(2, c.getCpf());
	            ps.setString(3, c.getEmail());
	            ps.setString(4, c.getEndereco());
	            ps.setString(5, c.getTelefone());
	            ps.setDate(6, new Date(c.getDataCadastro().getTime()));
	            ps.setInt(7, c.getStatus());
	            ps.setInt(8, c.getIdCliente());
	        }
	        
	        //Executando a query
	        ps.executeUpdate();
	        ConnectionFactory.close(con);
	        
	        return true;
	    }//Fim do Método Gravar
	    
	    //CarregarPorId
	    public Cliente getCarregarPorId(int idCliente)throws SQLException{
	        Cliente c = new Cliente();
	        sql = "SELECT idCliente, nome, cpf, email, endereco, telefone, dataCadastro, status " +
	                "FROM cliente WHERE idCliente = ? ";
	        
	        //Abrindo a conexao e executando o comando sql
	        con = ConnectionFactory.conectar();
	        ps = con.prepareStatement(sql);//Preparando a Query(instrução)
	        
	        //Vinculando os argumentos aos elementos
	            ps.setInt(1,idCliente);
	            rs = ps.executeQuery();
	            
	            if(rs.next()){
	                c.setIdCliente(rs.getInt("idCliente"));
	                c.setNome(rs.getString("nome"));
	                c.setCpf(rs.getString("cpf"));
	                c.setEmail(rs.getString("email"));
	                c.setEndereco(rs.getString("endereco"));
	                c.setTelefone(rs.getString("telefone"));
	                c.setDataCadastro(rs.getDate("dataCadastro"));
	                c.setStatus(rs.getInt("status"));
	            }
	            
	            ConnectionFactory.close(con);
	            
	        return c;
	    }
	    
	    //Desativar Cliente
	    public boolean desativar(Cliente c) throws SQLException{
	        sql = "UPDATE cliente set status = 0 " +
	                "WHERE idCliente = ?";
	        con = ConnectionFactory.conectar();
	        
	        ps=con.prepareStatement(sql);
	        ps.setInt(1, c.getIdCliente());
	        ps.executeUpdate();
	        ConnectionFactory.close(con);
	        
	        
	        return true;
	    }
	    
	    //Ativar Cliente
	    public boolean ativar(Cliente c) throws SQLException{
	        sql = "UPDATE cliente set status = 1 " +
	                "WHERE idCliente = ?";
	        con = ConnectionFactory.conectar();
	        
	        ps=con.prepareStatement(sql);
	        ps.setInt(1, c.getIdCliente());
	        ps.executeUpdate();
	        ConnectionFactory.close(con);
	        
	        
	        return true;
	    }
	    
	}//Fim da class Cliente DAO
