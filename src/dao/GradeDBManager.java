package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GradeDBManager {
//	private String INSERTUSER = " INSERT INTO `grade_table` VALUES ('1', '张三','98547',''),('2', '李四','98548',''); ";

	private Connection connection;
	private Statement stmt;

	public GradeDBManager(Connection connection) {
		// TODO Auto-generated constructor stub
		this.connection = connection;
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param name
	 *            姓名
	 * @param jobid
	 *            工号
	 * @return 是否注册成功
	 * @throws SQLException 
	 */
	// 注册用户
	public boolean insertUser(String name, String jobid) throws SQLException {
		if (stmt != null) {

		} else {
			System.out.println("stmt null");
		}
		//
		if (jobid == null) {
			System.out.println("输入为空");
			return false;
		} else {

				String sql = "INSERT INTO `"+DBString.DB_grade_table_NAME+"` VALUES ('" + name + "', '" + jobid + "',NULL,NULL);";
				System.out.println(sql);
				int result = stmt.executeUpdate(sql);
				System.out.println(result);
				return true;
		
		}

	}

	/**
	 * 查询所有信息
	 * 
	 * @return resultset集合
	 */
	public ResultSet selectUser() {

		String sql = "SELECT * FROM "+DBString.DB_grade_table_NAME;
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return rs;
	}

	// 删除

	/***
	 * 自动更新时间戳
	 * 
	 * @param jobnumber
	 *            工号
	 * @param grade
	 *            成绩
	 * @return 是否成功
	 */

	public boolean updataGrade(String jobnumber, int grade) {
		if (jobnumber == null) {
			return false;
		} else {
			String updategradeSQL = "update " + DBString.DB_grade_table_NAME+" SET grade=" + grade + "   where jobnumber=" + jobnumber
					+ " ; ";

			try {

				stmt.executeUpdate(updategradeSQL);
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

	}
	
	/**
	 * 查询用户是否存在
	 * @param jobnumber
	 * @return  
	 */
	public boolean selectUserExist(String jobnumber) {
		if(jobnumber!=null) {
			String selectUserExist="SELECT jobnumber FROM "+DBString.DB_grade_table_NAME+" where jobnumber="+jobnumber;
			//System.out.println(selectUserExist);
			try {
				ResultSet resultset	 =	stmt.executeQuery(selectUserExist);
				resultset.last();
				System.out.println(resultset.getRow());
				if(resultset.getRow()!=0) {
					
					return true;
			}
			else {
				System.out.println("row0");
				return false;
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}
		else {
			System.out.println("jobnumber ==null");
			return false;
		}
		
	}
	
	//SELECT * FROM grade_manager_db.grade_table_reset  where DATE_FORMAT(grade_table_reset.current_time,'%Y-%M-%d')>DATE_FORMAT('2017-12-05','%Y-%M-%d') and DATE_FORMAT(grade_table_reset.current_time,'%Y-%M-%d')<DATE_FORMAT('2017-12-07','%Y-%M-%d');
	public  ResultSet  selectbydata(String startTime,String endTime){
		ResultSet resultset=null;
		String selectBydataSQL="SELECT * FROM grade_manager_db.grade_table_reset  where DATE_FORMAT(grade_table_reset.current_time,'%Y-%M-%d')>=DATE_FORMAT('"+startTime+"','%Y-%M-%d') and DATE_FORMAT(grade_table_reset.current_time,'%Y-%M-%d')<=DATE_FORMAT('"+endTime+"','%Y-%M-%d');";
		System.out.println(selectBydataSQL);
		try {
			 resultset=stmt.executeQuery(selectBydataSQL);
			 
			return resultset;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		return resultset;
		}
		
		
	}

}
