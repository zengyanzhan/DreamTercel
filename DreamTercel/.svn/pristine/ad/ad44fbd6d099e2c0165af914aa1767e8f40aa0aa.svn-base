package com.yidu.dayEnd.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 导出净值统计excel
 * @author 肖光宇
 * @date 2017年12月6日
 * @time 下午7:17:52
 *
 */
public class ExeportNetValue {
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
	public void getSheet(String srcXlsPath,NetValue list){
		System.err.println("list="+list);
		File file=new File(srcXlsPath);
		if(!file.exists()){
			System.out.println("模板文件:"+srcXlsPath+"不存在!");  
			return;  
		}
		try {
			wb=new XSSFWorkbook(new FileInputStream(file));
			System.err.println("wb="+wb);
			sheet=wb.getSheetAt(0);//得到工作表
			//获得第二行的样式
			style=sheet.getRow(1).getCell(0).getCellStyle();
			//得到第二行
			cell=sheet.getRow(1).getCell(0);
			//设置第二行的字段
			cell.setCellValue("统计日期："+list.getStatisticDate());
			//设置样式
			cell.setCellStyle(style);
			//基金代码
			cell=sheet.getRow(3).getCell(0);
			if(list.getStrFundCode()!=null){
				cell.setCellValue(list.getStrFundCode());
			}

			//单位净值
			cell=sheet.getRow(3).getCell(2);
			if(list.getStrMoney()!=null){
				cell.setCellValue(list.getStrMoney());
			}
			cell=sheet.getRow(3).getCell(1);
			//基金名称
			if(list.getStrFundName()!=null){
				cell.setCellValue(list.getStrFundName());
			}
			//资产净值
			cell=sheet.getRow(3).getCell(3);
			if(list.getStrTotalMoney()!=null){
				cell.setCellValue(list.getStrTotalMoney());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//创建XSSFWorKbook

	}
	//导出
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
}
