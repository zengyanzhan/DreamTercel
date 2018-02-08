package com.yidu.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Properties;

/**
 * 读取属性文件 
 * @author HeXiXian
 * @date   2017年12月1日
 * @time   下午1:54:32
 *
 */
public class ReadProperties {
	/**
	 * 创建属性文件的方法
	 */
	public void createProperties(String str){
			//创建属性文件
			 Properties properties=new Properties();
			 //设置属性
			 properties.setProperty("updateData", str);
			 //保存到文件到中去
			 String path=this.getClass().getClassLoader().getResource("updateStr.properties").toString();
			 File file=new File(path.substring(6));
			 OutputStream os=null;
			 try {
				 //输出
				os=new FileOutputStream(file);
				properties.store(os, null);
				System.out.println("执行成功");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	/**
	 * 读取属性文件的方法
	 */
	public String readProperties(String key,String path){
		InputStream is=null;
		String value=null;
		  try {
			Properties properties=new Properties();
			 is = this.getClass().getResourceAsStream(path); 
	         properties.load(is);
	         
			//通过查询的键得到值
		   value=properties.getProperty(key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return value;
	}
	
	public String getUrl(){
		//file:/C:/Users/Administrator/workspace/DreamTercel/target/classes/LogManageTable.propertie
		return this.getClass().getClassLoader().getResource("LogManageTable.properties").toString();
	}
	
	
	public static void main(String[] args) {
		//new ReadProperties().createProperties("213");
		/*String user=new ReadProperties().readProperties("updateData","/updateStr.properties");
		System.out.println(user);*/
	}

}
