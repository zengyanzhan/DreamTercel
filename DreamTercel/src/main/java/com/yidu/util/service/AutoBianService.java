package com.yidu.util.service;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.yidu.util.dao.UtilDao;
import com.yidu.util.domain.UtilDomian;
/**
 * 编号的处理类
 * @author ZouJianwen
 * @data  2017年11月9日
 * @time  下午3:25:08
 *
 */
@Service
public class AutoBianService {
	//自动装配session工厂
	@Autowired
	UtilDao utilDao;
	/**
	 * 自动生成编号的方法
	 * @param tableName   要生成的表名  
	 * @param top         要生成的编号的前缀
	 * @param cardField   要生成的编号在表中的字段名
	 * @param dateField   生成要通过时间字段   这就是保存时间的字段在表中的字段名称
	 * @param strDate     时间值 作为位生成条件
	 * @return 返回生成的编号
	 */
	public  String getAutoBianhao(String tableName,String top,String cardField,String dateField,Date strDate)throws Exception{
		//得到Sqlsesion
		//定义变量记录自动生成的编号
		String strCardNo="";
		try {
			//创建实体类记录条件
			UtilDomian utilDomian = new UtilDomian();
			utilDomian.setTableName(tableName);
			utilDomian.setCardField(cardField);
			
			System.out.println(dateField);
			System.out.println(strDate);
			//定义一个变量记录查询当前的最大编号
			System.out.println("zidong");
			String previousBianhao="";
			//判断时间字段和时间值是否为空  为空即表示表中没有时间 不需要根据时间查
			if(dateField==null||("").equals(dateField)||strDate==null||("").equals(strDate)){
				System.out.println("vewewew");
				//得到最大的编号
				previousBianhao= utilDao.selectCodeByMaXCode(utilDomian);
				//不为空 即通过时间查询	
				System.out.println("cha="+previousBianhao);
			}else{
				//添加时间判断在表中的列字段和值
				utilDomian.setDateField(dateField);
				utilDomian.setStrDate(strDate);
				
				//得到当天最大的编号
				previousBianhao= utilDao.selectCodeByDateAndMaxCode(utilDomian);
			}
			System.out.println("dvbywegeoiuewhoiuvfew");
			//当所查的为空
			if(previousBianhao==null||previousBianhao.equals("")){
				//添加前缀
				strCardNo=top;
				if(dateField==null||("").equals(dateField)||strDate==null||("").equals(strDate)){
				
					
				}else{
					//对时间进行切割
					SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");//转为格式化
					String str[]=simple.format(strDate).split("-");
					for (int i = 0; i < str.length; i++) {
						//循环把时间的单个字段添加到编号中
						strCardNo=strCardNo+str[i];
					}
					
				}
				
				//初始将编号定为当天的第一笔
				strCardNo=strCardNo+"001";
			}else{
				//切割得到最后三位  数字
				String strNum = previousBianhao.substring(previousBianhao.length()-3);
				//System.out.println(strNum);
				//将格式转为数字型
				Integer num = Integer.parseInt(strNum);
				//将编号+1
				num++;
				//判断数字的位数  个位添加两个0变为字符串  十位数 添加一个0变为字符串
				if(num<=9){
					strNum="00"+num;
				}else if(num<=99){
					strNum="0"+num;
				}else if(num<=999){
					strNum=""+num;
				}
				//最后得到所查询的字符编号切掉后三位加上新生成的后三位
				strCardNo=previousBianhao.substring(0, previousBianhao.length()-3)+strNum;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			//释放资源
			
		}
		return strCardNo;
	}
	 
	/**
	 * 文件上传的工具类
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param inputName 上传文件对象的表单的name
	 * @return  上传成功 返回文件的绝对路径  格式不对返回 上传的文件格式只支持dbf、xlxs、xls文件 上传失败  返回 上传失败
	 * @throws Exception
	 */
	public String  upload(HttpServletRequest request,HttpServletResponse response,String inputName) throws Exception{
		
		String filePathName="";
		MultipartHttpServletRequest  multipartRequest = (MultipartHttpServletRequest)request;
		//得到文件保存的目录
		String realpath = request.getSession().getServletContext().getRealPath("/importFile");
		 MultipartFile multipartFile=	multipartRequest.getFile(inputName);
		 
		 //创建每天的文件夹
		 SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		 realpath =realpath +"/"+format.format(new java.util.Date(System.currentTimeMillis()));
		 File pathFile = new File(realpath);
		 //判断文件夹是否存在
		 if(!pathFile.exists()){
			 pathFile.mkdirs();
		 }
		 
		 //得到上传的文件名
		String name= multipartFile.getOriginalFilename();
		//切割上传文件的后缀
		String postfix = name.substring(name.lastIndexOf("."));
		if(postfix.equals(".dbf")||postfix.equals(".xlsx")||postfix.equals(".xls")){
			 filePathName = realpath+"/"+name;
				File uploadFile = new File(filePathName);
				try {
					//保存到file
					multipartFile.transferTo(uploadFile);
				} catch (Exception e) {
					e.printStackTrace();
					return "上传失败";
				}
		}else{
			return "上传的文件格式只支持dbf、xlxs、xls文件";
		}
		System.err.println(name);
		return filePathName;
	}
	/**
	 * 下载的方法
	 * @param filePath 文件的绝对路径
	 * @param request 请求对象
	 * @param response 请求对象
	 * @throws UnsupportedEncodingException
	 */
	public void  downLoad(String filePath,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("multipart/form-data");
		String fileName=filePath.substring(filePath.lastIndexOf("/")+1);
		System.err.println(fileName);
		response.setHeader("Content-Disposition", "attachment;fileName="+new String(fileName.getBytes("UTF-8"),"ISO8859-1"));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(filePath));
			OutputStream outputStream=response.getOutputStream();
			byte[] b= new byte[2048];
			int length;
			while((length=inputStream.read(b))>0){
				
				outputStream.write(b,0,length);
				
			}
			
			inputStream.close();
			inputStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
