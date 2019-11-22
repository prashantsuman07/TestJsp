public interface Testdao {
	
	public boolean regUser(TestBean testBean);
	public  TestBean login(String uname,String pswd);
	public  boolean changePass(String uname,String pswd);
	
}