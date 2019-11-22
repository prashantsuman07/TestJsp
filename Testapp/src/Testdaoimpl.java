
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class Testdaoimpl implements Testdao{	
	@Override
	public boolean regUser(TestBean testBean) {
		
		Connection con=null;
		PreparedStatement stmt=null;
		boolean isAdded=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?user=root&password=root");
			String query="insert into student1 values(?,?,?,?)";
			stmt=con.prepareStatement(query);
		
			stmt.setString(1,testBean.getUsername());
			stmt.setString(2,testBean.getPassword());
			stmt.setInt(3,testBean.getAge());
			stmt.setString(4,testBean.getGender());
			
			int n=stmt.executeUpdate();
			if(n>0) {
				isAdded=true;
			}

	}
	catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			
			if(stmt !=null) {
				stmt.close();
			}
			if(con !=null) {
				con.close();
			}
				
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
		return isAdded;
		
	}

	

	@Override
	public TestBean login(String uname, String pswd) {
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		TestBean testBean=null;
		try {
			//Driver driver=new Driver();
			//DriverManager.registerDriver(driver);
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?user=root&password=root");
			String query="select * from student1 where username= ? and pass=?";
			stmt=con.prepareStatement(query);
			stmt.setString(1,uname);
			stmt.setString(2,pswd);
			rs=stmt.executeQuery();
			if(rs.next()) {
				testBean=new TestBean();
				testBean.setUsername(rs.getString("username"));
				testBean.setPassword(rs.getString("pass"));	
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) {
					rs.close();
				}
				if(stmt !=null) {
					stmt.close();
				}
				if(con !=null) {
					con.close();
				}
					
			}
			catch(Exception e){
				e.printStackTrace();
			}

		}
			return testBean;
	}

	@Override
	public boolean changePass(String uname,String pswd) {
		Connection con=null;
		PreparedStatement stmt=null;
		boolean isupdated=false;
		TestBean testbean=null;
		
		try {
			//Driver driver=new Driver();
			//DriverManager.registerDriver(driver);
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?user=root&password=root");
			String query="update student1 set pass=? where username=?";
			stmt=con.prepareStatement(query);
			stmt.setString(1,pswd);
			stmt.setString(2,uname);
			int n=stmt.executeUpdate();
			if(n>0) {
				isupdated=true;
			}

	}
	catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			
			if(stmt !=null) {
				stmt.close();
			}
			if(con !=null) {
				con.close();
			}
				
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
		return isupdated;
	}
	
}


	


