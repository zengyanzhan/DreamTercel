package com.yidu.cashManagement.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	private String srcXlsPath="";//模板的路径
	private String desXlsPath="";//新生成下载的路径
	XSSFCellStyle style=null;
	XSSFCell cell=null;
	XSSFWorkbook wb=null;
	XSSFSheet sheet=null;
	//导出excel模板
	public void setSrcXlsPath(String strXlsPath) {
		this.srcXlsPath = strXlsPath;
	}
	//下载生成的模板
	public void setDesXlsPath(String desXlsPath) {
		this.desXlsPath = desXlsPath;
	}
	//得到工作表
	public void getSheet(String srcXlsPath,AppropriationOrder list) {
		File file=new File(srcXlsPath);
		if(!file.exists()){
			System.out.println("模板文件:"+srcXlsPath+"不存在!");  
			return;  
		}
		try {
			wb=new XSSFWorkbook(new FileInputStream(file));//创建XSSFWorKbook
			System.err.println("wb="+wb);
			sheet=wb.getSheetAt(0);//得到工作表
			System.err.println("sheet="+sheet);
			if(list!=null){
				System.out.println("进来了");
				sheet=wb.getSheetAt(0);//得到工作表
				System.err.println("sheet="+sheet);
				cell=sheet.getRow(0).getCell(0);//编号
				style=sheet.getRow(0).getCell(0).getCellStyle();
				cell.setCellValue("编号:"+list.getCode());
				cell.setCellStyle(style);
				//指令日期
				cell=sheet.getRow(1).getCell(0);//指令日期
				style=sheet.getRow(1).getCell(0).getCellStyle();
				cell.setCellValue("指令日期:"+list.getOrderDate());
				cell.setCellStyle(style);
				//到款日期
				cell=sheet.getRow(4).getCell(2);//到款日期
				style=sheet.getRow(4).getCell(2).getCellStyle();
				cell.setCellValue(list.getToAccountDate());
				cell.setCellStyle(style);
				//付款人
				cell=sheet.getRow(5).getCell(2);//付款人
				cell.setCellValue(list.getPayName());
				//付款银行
				cell=sheet.getRow(6).getCell(2);//付款银行
				cell.setCellValue(list.getPayBank());
				//付款人账号
				cell=sheet.getRow(7).getCell(2);//付款人账号
				style=sheet.getRow(7).getCell(2).getCellStyle();
				cell.setCellValue(list.getPayCode());
				cell.setCellStyle(style);
				//金额(小写)
				cell=sheet.getRow(9).getCell(2);
				style=sheet.getRow(9).getCell(2).getCellStyle();
				cell.setCellValue(list.getMoney());
				cell.setCellStyle(style);
				//金额(大写)
				cell=sheet.getRow(10).getCell(2);
				style=sheet.getRow(9).getCell(2).getCellStyle();
				cell.setCellValue(toUpperMoney(list.getMoney())+"");
				cell.setCellStyle(style);
				//收款人
				cell=sheet.getRow(12).getCell(2);
			
				cell.setCellValue(list.getCashName());
		
				//收款银行
				cell=sheet.getRow(13).getCell(2);
				
				cell.setCellValue(list.getCashBank());
		
				//收款账号
				cell=sheet.getRow(14).getCell(2);
				cell.setCellValue(list.getCashCode());
				cell.setCellStyle(style);
	
				//金额(小写)
				cell=sheet.getRow(16).getCell(2);
				style=sheet.getRow(16).getCell(2).getCellStyle();
				cell.setCellValue(list.getMoney());
				cell.setCellStyle(style);
				//金额(大写)
				cell=sheet.getRow(17).getCell(2);
				style=sheet.getRow(17).getCell(2).getCellStyle();
				cell.setCellValue(toUpperMoney(list.getMoney()));
				cell.setCellStyle(style);
				//备注
				cell=sheet.getRow(19).getCell(1);
				cell.setCellValue(list.getDesc());
				//收款人签字
//				cell=sheet.getRow(20).getCell(2);
//				style=sheet.getRow(20).getCell(2).getCellStyle();
//				cell.setCellValue(list.getCashName());
//				cell.setCellStyle(style);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void exportToNewFile(String desXlsPath) {  
		FileOutputStream out;  
		try {  
			out = new FileOutputStream(desXlsPath);  
			wb.write(out);  
			out.close();  
		} catch (FileNotFoundException e) {  
			e.printStackTrace();  
		} catch (IOException e) {  
			e.printStackTrace();  
		}  
	}
	/**
	 * 将钱数或小数类型转换为中文大写形式
	 * @param money
	 * @return 
	 */
	public String toUpperMoney(Double money){
		//0-9的数字大写数组
		String[] unit={"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
		//数位大写数组
		String[] digit={"","拾","佰","仟"};
		//每4位进阶数位大写数组
		String[] myriabit={"","万","亿","兆"};
		//接收分析后的大写数字
		StringBuffer str=new StringBuffer();
		//获得参数小数点前数字
		String dotFront = money.toString().split("\\.")[0];
		//获得参数小数点后数字
		String dotBack = money.toString().split("\\.")[1];
		//遍历小数点前数字字符串
		for (int i = 0; i < dotFront.length(); i++) {
			//获得相应字符并转换为数字类型
			Integer value=Integer.parseInt(((Character)dotFront.charAt(i)).toString());
			//获得数字相应数位
			int num=dotFront.length()-i-1;
			//当前大写数字字符串不以零为后缀或当前数字不为0则写入当前大写数字
			if(!str.toString().endsWith(unit[0])||value!=0)
				str.append(unit[value]);
			//当前数字不为0则写入当前位数
			if(value!=0)
				str.append(digit[(num)%4]);
			//当前大写数字字符串不以零为后缀或当前数字不为0并当前位数为4的倍数则写入每4位进阶数位
			if((!str.toString().endsWith(unit[0])||value!=0)&&(num)%4==0)
				str.append(myriabit[(num)/4]);
		}
		//当前位数以零结尾则去除零
		if(str.toString().endsWith(unit[0]))
			str.deleteCharAt(str.length()-1);//
		//加入单位 元
		str.append("圆");
		//加入小数点后数字第一位 单位角
		str.append(unit[Integer.parseInt(((Character)dotBack.charAt(0)).toString())]+"角");
		//分析小数点后数字不止一位 则 加入小数点后数字第二位 单位分
		if(dotBack.length()>1)
			str.append(unit[Integer.parseInt(((Character)dotBack.charAt(1)).toString())]+"分");
		//若当前大写数字字符串以零角为后缀 去除 零角 加入整
		if(str.toString().endsWith(unit[0]+"角")){
			str.delete(str.length()-2,str.length());
			str.append("整");
		}
		return str.toString();
	}


}
