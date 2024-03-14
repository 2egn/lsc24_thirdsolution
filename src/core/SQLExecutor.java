package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
//ctrl + space to load a importation screen


public class SQLExecutor {
	private Connection connection;
	public void Connect() throws SQLException{
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/?serverTimezone=Asia/Seoul&useSSL=FALSE&allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&allowLoadLocalInfile=true", "root", "1234");
	}
	public ResultSet executeReadQuery(String sql) throws SQLException{
		Statement statement = connection.createStatement();
		return statement.executeQuery(sql);
	}
	public void executeUpdateQuery(String sql) throws SQLException{
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
	}
	public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}