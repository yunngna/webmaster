package chap08;

public class DaoExampleMain {
	

	public static void main(String[] args) {
		dbwork(new OracleDao());
		dbwork(new MysqlDao());
	}
	
	

	 static void dbwork(DataAccessObject dao) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
	
	}
}
