package com.gxa.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gxa.model.Course;
import com.gxa.model.Orders;
import com.gxa.model.Users;
import com.gxa.util.DBConnection;

public class JdbcBuild {
	      /* 
	       * 
	       * 
	       * ����List���ϣ��Ҽ����д洢Map����
	       * 
	       * */
	    public List<Map<String,Object>> getListForMap(String sql, Object... params ) throws SQLException{
		  Connection conn = DBConnection.getConnection();
		  QueryRunner queryRunner = new QueryRunner();
		  List<Map<String,Object>> list = queryRunner.query(conn, sql, new MapListHandler(), params);
		  DBConnection.closeConnection(conn);
			  return list;
		      }
	      
	      
	      	/*
	                                      ��װ������ɾ������ѯ�ȹ���
	       * 
	       * */
		  public int updateAll(String sql,Object... params) throws SQLException{
			  Connection conn = DBConnection.getConnection();
			  QueryRunner queryRunner = new QueryRunner();
			  int i = queryRunner.update(conn, sql, params);
			  DBConnection.closeConnection(conn);
			  return i ;
		  }
		  
	  /**
	   * ͨ��ĳ��������ѯ	  
	   * @param sql
	   * @param params
	   * @return
	   * @throws SQLException
	   */
	 public Map<String,Object> getForMap(String sql, Object... params) throws SQLException {
				Connection conn = DBConnection.getConnection();
				QueryRunner queryRunner = new QueryRunner();
				Map<String,Object> map = queryRunner.query(conn, sql, new MapHandler(), params);
				DBConnection.closeConnection(conn);
				return map;
			}
			
	  public List<Users> getUsers(String sql, Object... params) throws SQLException {
				Connection conn = DBConnection.getConnection();
				QueryRunner queryRunner = new QueryRunner();
				List<Users> list = queryRunner.query(conn, sql, new BeanListHandler<>(Users.class), params);
				DBConnection.closeConnection(conn);
				return list;
		}
	  
	  /**
	   * ��ѯ�γ�
	   * @param sql
	   * @param params
	   * @return
	   * @throws SQLException
	   */
	  public List<Course> getCourse(String sql, Object... params) throws SQLException {
			Connection conn = DBConnection.getConnection();
			QueryRunner queryRunner = new QueryRunner();
			List<Course> list = queryRunner.query(conn, sql, new BeanListHandler<>(Course.class), params);
			DBConnection.closeConnection(conn);
			return list;
	}
	  
	  
	  /**
	   * ��ѯ�γ�
	   * @param sql
	   * @param params
	   * @return
	   * @throws SQLException
	   */
	  public List<Orders> getOrders(String sql, Object... params) throws SQLException {
			Connection conn = DBConnection.getConnection();
			QueryRunner queryRunner = new QueryRunner();
			List<Orders> list = queryRunner.query(conn, sql, new BeanListHandler<>(Orders.class), params);
			DBConnection.closeConnection(conn);
			return list;
	}
	  
	  
	  /**
	   * ͳ�ƿγ̵�����Ŀ
	   * @param sql
	   * @return
	 * @throws SQLException 
	   */
	public int findAllCount(String sql) throws SQLException {
			Connection conn = DBConnection.getConnection();
			QueryRunner queryRunner = new QueryRunner();
			long count = (Long) queryRunner.query(conn,sql, new ScalarHandler());
			DBConnection.closeConnection(conn);
			return (int) count;
	}
	
/*	*//**
	 * ����ĳ������
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 *//*
	public Admin findAdmin(String sql,Object... params) throws SQLException {
		Connection conn = DBConnection.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		Admin admin = queryRunner.query(conn, sql, new BeanHandler<Admin>(Admin.class),params);
		DBConnection.closeConnection(conn);
		return admin;
	}
	*/
}	      


