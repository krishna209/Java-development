package com.cloudwick.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCManager {

	private Connection con;

	private void getConnection() throws SQLException {
		String URL = "jdbc:mysql://localhost/test";
		con = DriverManager.getConnection(URL, "root", "Kittuu@209");
	}

	private void insertData(String uName, String pwd) throws SQLException {
		con.setAutoCommit(false);// This will not update the data in MYSQL it
									// will save the data into jdbc this feature
									// is useful in transaction managemnt
									// operations
		String query = "insert into user(UserName,Password) values(?,?)";/*
																		 * here
																		 * ?
																		 * means
																		 * dynamic
																		 * query
																		 */
		PreparedStatement ps = con.prepareStatement(query);/*
															 * here it is pre
															 * compiled query
															 * thats y there is
															 * an argument query
															 */
		ps.setString(1, uName);// since the userID and pwd are varchars in MYSQL
								// we use these statements
		ps.setString(2, pwd);
		int count = ps.executeUpdate();
		System.out.println("User inserted :" + count);
		con.commit();// this commits the data into MYSQL from jdbc

	}

	private void updateData(int userId, String uName) throws SQLException {
		String query = "update user set UserName='" + uName + "' where UserID="
				+ userId;
		Statement st = con.createStatement();// Here it is not a precompiled
												// query it will execute in
												// MYSQL
		int count = st.executeUpdate(query);
		System.out.println("User Updated :" + count);
	}

	private void fetchData() throws SQLException {
		String query = "select * from user";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);// This is traverses through rows
												// it doesnt care about the
												// columns
		while (rs.next())// to iterate through columns we use while
		{
			System.out.println("user ID:" + rs.getInt(1));
			System.out.println("User Name is:" + rs.getString(2));
			System.out.println("Password is:" + rs.getString(3));
		}
	}

	public void insertBatchData() throws SQLException {/*
														 * batch statements
														 * execute multiple
														 * lines of code at a
														 * time
														 */
		long startTime=System.currentTimeMillis();
		String query = "insert into user(UserName,Password) values(?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, "a");
		ps.setString(2, "b");
		ps.addBatch();
		ps.setString(1, "c");
		ps.setString(2, "d");
		ps.addBatch();
		ps.setString(1, "e");
		ps.setString(2, "f");
		ps.addBatch();
		ps.setString(1, "g");
		ps.setString(2, "h");
		ps.addBatch();
		ps.setString(1, "i");
		ps.setString(2, "j");
		ps.addBatch();
		ps.setString(1, "k");
		ps.setString(2, "l");
		ps.addBatch();
		int data[] = ps.executeBatch();
		long endTime=System.currentTimeMillis();
		System.out.println("Time elapsed :"+(endTime-startTime));

	}

	public static void main(String[] args) throws SQLException {
		JDBCManager jdbcm = new JDBCManager();
		jdbcm.getConnection();
		// jdbcm.insertData("ring", "trigger");
		// jdbcm.updateData(3,"reddy");
		// jdbcm.fetchData();
		//jdbcm.insertBatchData();
	}

}
