package org.wuyechun.util.dbquery;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.report.ReportManager;
import net.sf.jxls.report.ReportManagerImpl;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;



public class JxlsUtil {
	
	public static void writeToExcel(){
		
		 XLSTransformer transformer = new XLSTransformer();
		 //模板
		 String xlsTemplateFileName ="c:\\template.xls";
		 //输出结果
		 String xlsFileName = "c:"+File.separator+"result.xls";
         Map beans = new HashMap();
         beans.put("username","zhangsan");
         beans.put("password","zhangsan@iflytek.com");
         
         try {
			transformer.transformXLS(xlsTemplateFileName , beans, xlsFileName);
		} catch (ParsePropertyException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * 功能 :直接在Excle中配置SQL
	
	 * 开发：ycwu 2015-4-29
	 */
	public static void  writeSqlToExcel(){
		 Connection conn =DbUtil.getDbConn("jdbc:oracle:thin:@localhost:1521:orcl","dms","dms");
         Map beans = new HashMap();
         ReportManager rm = new ReportManagerImpl( conn, beans );
         beans.put("rm", rm);
         
         String templateFilePath="C:\\reportTemplate.xls";
         String destFilePath="C:\\report.xls";
         
         InputStream is=null;
		try {
			is = new BufferedInputStream(new FileInputStream("C:\\reportTemplate.xls"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
         XLSTransformer transformer = new XLSTransformer();
         
         try {
				transformer.transformXLS(templateFilePath,beans,destFilePath);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParsePropertyException e) {
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			}
	}
	

}
