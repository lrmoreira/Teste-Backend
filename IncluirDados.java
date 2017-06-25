package br.com.lucas.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class IncluirDados {
		
	public static void main(String[] args) throws SQLException{
		
		
		Contatos contatos = new Contatos();
		Random ran = new Random();
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try{
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
		
		String sql = "insert into tb_customer_account values(?,?,?,?,?)";
		
		//Connection con = DriverManager.getConnection(url,"system","Tatiane0211"); 
			try(Connection con = DriverManager.getConnection(url,"system","Tatiane0211")){
				
		
				try(PreparedStatement stm = con.prepareStatement(sql)){
					for(int i = 0; i < contatos.pessoas.length; i++){
				
						stm.setInt(1, ran.nextInt(2700) + 1500);
						stm.setString(2, contatos.cpf_cnpj[i]);
						stm.setString(3, contatos.getPessoas(ran.nextInt(17)));
						stm.setString(4, "S");
						stm.setDouble(5, ran.nextDouble()*10000.000 + 100.00);
						stm.addBatch();		
					}
					stm.executeBatch();				
				}catch(SQLException e){
					System.out.println(e.getMessage());
				}
			
			sql = "select AVG(vl_total) from tb_customer_account where vl_total > 560 and id_customer between 1500 and 2700";	
			PreparedStatement stm2 = con.prepareStatement(sql);
				ResultSet rs = stm2.executeQuery();
					while(rs.next()){
						System.out.println("Média final é de: "+ rs.getDouble(1));
					}
		//}
		
		
			sql = "select NM_CUSTOMER from tb_customer_account where id_customer between 1500 and 2700 and vl_total > 560 order by vl_total desc";	
			PreparedStatement stm3 = con.prepareStatement(sql);
				ResultSet rs2 = stm3.executeQuery();
					System.out.println("Listagem de usuários utilizados para tirar a média: ");
						while(rs2.next()){
							System.out.println(rs2.getString(1));
						}
						
		}catch(SQLException e){
			System.out.println(e.getMessage());
	
				
		
	}
	}
}


