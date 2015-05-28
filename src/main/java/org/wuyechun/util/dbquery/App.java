package org.wuyechun.util.dbquery;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 * 
 */
public class App {
	
	/**
	 * 农业
	 */
	public static String PARAM_NY="1";
	
	/**
	 * 总数
	 */
	public static String PARAM_ZS="2";
	
	
	/**
	 * 人口类型-实有人口
	 */
	public static String PARAM_SYRK="4";
	
	/**
	 * 人口类型-常住人口
	 */
	public static String PARAM_CZRK="1";
	
	/**
	 * 人口类型-流入人口
	 */
	public static String PARAM_LRRK="2";
	
	/**
	 * 人口类型-流出人口
	 */
	public static String PARAM_LCRK="3";
	
	public static void main(String[] args) {
		
		//writeTOText("你好");
		//writeTOText("EVERY");
		//JxlsUtil.writeSqlToExcel();
		
		
		/**********/
		//区域编码
		String [] areaName={"芜湖市","镜湖区","弋江区","三山区","鸠江区","经开区","无为县","繁昌县","南陵县","芜湖县"};
		String [] areaCode={"3402","340202","340203","340208","340207","340217","340225","340222","340223","340221"};
		
		for(int i=0;i<areaCode.length;i++){
			System.out.println("-------------------"+areaName[i]+"-------------------");
			
			//实有人口-总数
			String sql_syrk_zs=getQuerySql(PARAM_SYRK,PARAM_ZS,areaCode[i]);
			int syrk_zs=doQuery(sql_syrk_zs);
			System.out.println("实有人口-总数"+syrk_zs);
			
			//实有人口-农业
			String sql_syrk_ny=getQuerySql(PARAM_SYRK,PARAM_NY,areaCode[i]);
			int syrk_ny=doQuery(sql_syrk_ny);
			System.out.println("实有人口-农业"+syrk_ny);
			
			//实有人口-非农业
			System.out.println("实有人口-非农业"+(syrk_zs-syrk_ny));
			System.out.println("-------------------");
			
			//常住人口-总数
			String sql_czrk_zs=getQuerySql(PARAM_CZRK,PARAM_ZS,areaCode[i]);
			int czrk_zs=doQuery(sql_czrk_zs);
			System.out.println("常住人口-总数"+czrk_zs);
			
			//常住人口-农业
			String sql_czrk_ny=getQuerySql(PARAM_CZRK,PARAM_NY,areaCode[i]);
			int czrk_ny=doQuery(sql_czrk_ny);
			System.out.println("常住人口-农业"+czrk_ny);
			
			//实有人口-非农业
			System.out.println("实有人口-非农业"+(czrk_zs-czrk_ny));
			
			System.out.println("-------------------");
			
			//流出人口-总数
			String sql_lcrk_zs=getQuerySql(PARAM_LCRK,PARAM_ZS,areaCode[i]);
			int lcrk_zs=doQuery(sql_lcrk_zs);
			
			System.out.println("流出人口-总数"+lcrk_zs);
			
			//流出人口-农业
			String sql_lcrk_ny=getQuerySql(PARAM_LCRK,PARAM_NY,areaCode[i]);
			int lcrk_ny=doQuery(sql_lcrk_ny);
			System.out.println("流出人口-农业"+lcrk_ny);
			
			//流出人口-非农业
			System.out.println("实有人口-非农业"+(lcrk_zs-lcrk_ny));
			System.out.println("-------------------");
			
			//流入人口
			//总数
			String sql_lrrk_zs=getQuerySql(PARAM_LRRK,PARAM_ZS,areaCode[i]);
			int lrrk_zs=doQuery(sql_lrrk_zs);
			System.out.println("流入人口-总数"+lrrk_zs);
			//农业
			String sql_lrrk_ny=getQuerySql(PARAM_LRRK,PARAM_NY,areaCode[i]);
			int lrrk_ny=doQuery(sql_lrrk_ny);
			System.out.println("流入人口-农业"+lrrk_ny);
			//非农业
			System.out.println("流入人口-非农业"+(lrrk_zs-lrrk_ny));
			
			
		}
		
	}
	
	
	/**
	 * 
	 * 功能 :查询
	
	 * 开发：ycwu3 2015-4-28
	
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public static int doQuery(String sql) {
		
		String url = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=172.16.7.114)(PORT=1521))(ADDRESS=(PROTOCOL=TCP)(HOST=172.16.7.116)(PORT=1521))(LOAD_BALANCE=yes)(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=cache)(FAILOVER_MODE=(TYPE=SELECT)(METHOD=BASIC)(RETRIES=180)(DELAY=5))))";
		String user="grid"; 
		String password="123456";
		
		int count=0;
		try {
			Connection  conn=DbUtil.getDbConn(url,user,password);
			PreparedStatement pstm =conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
		
			if (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			//关闭连接
			if (pstm != null) {
				pstm.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	
	
	
	/**
	 * 
	 * 功能 :获取查询的SQL
	
	 * 开发：ycwu 2015-4-28
	
	 * @param rkType 人口类型
	 * @param hjType 户籍类型
	 * @param xzqh   行政区号
	 * @return
	 */
	private static String getQuerySql(String rkType,String hjType,String xzqh){
		
		String sql="";
		
		//实有人口，常住人口
		String sqlSYAndCZ="SELECT count(1)\n" +
				"  FROM psn_common_person\n" + 
				" WHERE logoff_flag || substr(BUILDING_NO, 1, "+xzqh.length()+"） =";
		
		//农村
		String sqlPartNC=" AND (census_type_nm ='农业家庭户口' or census_type_nm ='农业集体户口' )";
		
		//其它
		String sqlOther="SELECT count(1)\n" +
						"  FROM psn_common_person\n" + 
						" WHERE logoff_flag = '0'\n" ;
		
		//实有人口
		if(rkType!=null&&(PARAM_SYRK.equals(rkType))){
			sql=sqlSYAndCZ+"'0"+xzqh+"'";
		}else if(rkType!=null&&(PARAM_CZRK.equals(rkType))){
	    //常住人口
			sql=sqlSYAndCZ+"'0"+xzqh+"' AND CENSUS_TYPE = '1'";
		}else{
			//流出人口，流入人口	
			sql=sqlOther+"AND CENSUS_TYPE = '"+rkType+"'\n AND BUILDING_NO like '"+xzqh+"%'";
		}
		
		//农业
		if(hjType!=null&&PARAM_NY.equals(hjType)){
			 sql+=sqlPartNC;
		}
		
		return sql;
	}
	
	
	
	
	/***
	 * 
	 * 功能 :将查询结果输出到txt文件
	
	 * 开发：ycwu3 2015-4-29
	
	 * @param content
	 */
	public static void writeTOText(String content){
		try {
			RandomAccessFile randomFile = new RandomAccessFile("c:\\dbquyer.txt", "rw");  
			// 文件长度，字节数  
			long fileLength = randomFile.length();  
			//将写文件指针移到文件尾。  
			randomFile.seek(fileLength);  
			randomFile.writeUTF(content);
			randomFile.write((System.getProperty("line.separator")).getBytes());
			randomFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	
	
	//String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	//String user="dms"; 
	//String password="dms";
	//sql="SELECT COUNT(1) FROM SQL_BOOK";
	
	//(DESCRIPTION =(ADDRESS = (PROTOCOL = TCP)
	//(HOST = 172.16.7.114)(PORT = 1521))
	//(ADDRESS = (PROTOCOL = TCP)(HOST = 172.16.7.116)
	//(PORT = 1521))(LOAD_BALANCE = yes)(CONNECT_DATA = 
	//(SERVER = DEDICATED)(SERVICE_NAME = cache)(FAILOVER_MODE =(TYPE = SELECT)
	//(METHOD = BASIC)(RETRIES = 180)(DELAY = 5))
	//jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=172.16.7.114)(PORT=1521))(ADDRESS=(PROTOCOL=TCP)(HOST=172.16.7.116)(PORT=1521))(LOAD_BALANCE=yes)(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=center)(FAILOVER_MODE=(TYPE=SELECT)(METHOD=BASIC)(RETRIES=180)(DELAY=5))))
}
