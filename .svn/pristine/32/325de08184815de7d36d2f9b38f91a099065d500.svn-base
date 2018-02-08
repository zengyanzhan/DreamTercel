package com.yidu.dayEnd.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.dayEnd.dao.NetValueDao;
import com.yidu.dayEnd.domain.NetValue;
import com.yidu.dayEnd.service.NetValueService;
import com.yidu.util.AllUtil;
/**
 * 净值统计业务逻辑层接口实现类
 * @author 向燕春
 * @date 2017年11月18日
 * @time 下午10:07:17
 *
 */
@Transactional
@Service
public class NetValueServiceImpl implements NetValueService {
	@Autowired
	NetValueDao netValueDao;

	@Override
	public String strWhere(NetValue netValue){
		//创建一个字符串
		StringBuffer buffer=new StringBuffer("");
		//判断基金编号是否为空
		if(netValue.getFundCode()!=null&&!netValue.getFundCode().equals("")){
			buffer.append("  and fund_code  =  '"+netValue.getFundCode()+"'");
		}
		//判断父类树形编号是否为空
		if(netValue.getTreeFatherCode()!=null&&!netValue.getTreeFatherCode().equals("")){
			buffer.append("  and tree_father_code  =  '"+netValue.getTreeFatherCode()+"'");
		}
		//判断统计日期是否为空
		if(netValue.getStatisticDateWhere()!=null&&!netValue.getStatisticDateWhere().equals("")){
			buffer.append("  and statistic_date =  to_date(' "+netValue.getStatisticDateWhere()+"','yy-MM-dd')");
		}
		String flag=buffer.toString();
		return flag;
	}

	@Override
	public HashMap<String, Object> selectNetValues
								(
									String tableName, 
									String qualification, 
									Integer page, 
									Integer rows,
									Integer rowsTotal, 
									String orderColumn, 
									String orderStyle) {
		//创建一个集合
		HashMap<String,Object> map = new HashMap<String,Object>();
		//将数据放到集合里面（表名，条件，页，行，总行，排序的列，排序的方式）
		map.put("tableName", tableName);
		map.put("qualification",qualification);
		map.put("page",page);
		map.put("rows", rows);
		map.put("rowsTotal",rowsTotal );
		map.put("orderColumn","net_value_code" );
		map.put("orderStyle","asc" );
		//调用查询净值统计表数据的方法
		netValueDao.selectNetValues(map);
		map.get("netValueList");
		return map;
	}

	@Override
	public int deleteNetValue(NetValue netValue) {
		// TODO Auto-generated method stub
		return netValueDao.deleteNetValue(netValue);
	}
	@Override
	public List<NetValue> selectSecurityDetail(NetValue netValue) {
		//得到行情录入日期
		String enteringDate=netValue.getEnteringDate();
		//得到业务日期
		String businessDate=netValue.getBusinessDate();
		//定义一个标志
		boolean flag=true;
		//定义一个变量用来接收股票、债券详细信息的数据
		List<NetValue> detailsList=null;
		try {
			while(flag){
				//调用查询股票、债券详细信息的方法
				detailsList=netValueDao.selectSecurityDetail(netValue); 
				//判断集合是否有数据
				if(detailsList.size()!=0){
					//跳出循环
					flag=false;
					break;
				}else{
					//调用得到前一天日期的方法
					enteringDate=AllUtil.getStringDate(AllUtil.getDate(enteringDate, -1)); 
					//判断如果循环了7天还是没有数据，则跳出循环
					if(enteringDate.equals(AllUtil.getStringDate(AllUtil.getDate(businessDate,-7)))){
						//跳出循环
						flag=false;
						break;
					}
					//反之，继续循环
					flag=true;	
					//将得到的最新行情数据的业务日期放到实体类
					netValue.setEnteringDate(enteringDate);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detailsList;
	}



	@Override
	public NetValue selectSecurity(NetValue netValue) {
		//得到行情录入日期
		String enteringDate=netValue.getEnteringDate();
		//得到业务日期
		String businessDate=netValue.getBusinessDate();
		//定义一个标志
		boolean flag=true;
		//定义一个变量用来接收股票、债券头部信息的数据
		NetValue netVlues=null;
		try {
			while(flag){
				//调用查询股票、债券头部信息的方法
				netVlues=netValueDao.selectSecurity(netValue);
				//判断是否有数据
				if(netVlues!=null&&!netVlues.equals("")){
					//跳出循环
					flag=false;
					break;
				}else{
					//调用得到前一天日期的方法
					enteringDate=AllUtil.getStringDate(AllUtil.getDate(enteringDate, -1));
					//判断如果循环了7天还是没有数据，则跳出循环
					if(enteringDate.equals(AllUtil.getStringDate(AllUtil.getDate(businessDate,-7)))){
						//跳出循环
						flag=false;
						break;
					}
					//反之，继续循环
					flag=true;	
					//将得到的最新行情数据的业务日期放到实体类
					netValue.setEnteringDate(enteringDate);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return netVlues;
	}

	@Override
	public NetValue selectSecurityAll(NetValue netValue) {
		//得到行情录入日期
		String enteringDate=netValue.getEnteringDate();
		//得到业务日期
		String businessDate=netValue.getBusinessDate();
		//定义一个标志
		boolean flag=true;
		//定义一个变量用来接收证券的总头部（包括股票+债券）信息
		NetValue netVlues=null;
		try {
			while(flag){
				//调用查询证券总头部（包括股票+债券）信息
				netVlues=netValueDao.selectSecurityAll(netValue);
				//判断是否有数据
				if(netVlues!=null&&!netVlues.equals("")){
					//跳出循环
					flag=false;
					break;
				}else{
					//调用得到前一天日期的方法
					enteringDate=AllUtil.getStringDate(AllUtil.getDate(enteringDate, -1));
					//判断如果循环了7天还是没有数据，则跳出循环
					if(enteringDate.equals(AllUtil.getStringDate(AllUtil.getDate(businessDate,-7)))){
						//跳出循环
						flag=false;
						break;
					}
					//反之，继续循环
					flag=true;	
					//将得到的最新行情数据的业务日期放到实体类
					netValue.setEnteringDate(enteringDate);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return netVlues;
	}

	@Override
	public int insertNetValue(NetValue netValue) {
		// TODO Auto-generated method stub
		return netValueDao.insertNetValue(netValue);
	}

	@Override
	public List<NetValue> selectCashAccount(NetValue netValue) {
		// TODO Auto-generated method stub
		return netValueDao.selectCashAccount(netValue);
	}

	@Override
	public NetValue selectCashAccountDetail(NetValue netValue) {
		//调用查询现金账户的应收应付详情
		NetValue net=netValueDao.selectCashAccountDetail(netValue);
		//判断是否有数据
		if(net!=null){
			//判断业务类型
			if(netValue.getBusinessType()==1){
				net.setProjectName("管理费");
			}else if(netValue.getBusinessType()==2){
				net.setProjectName("托管费");
			}else if(netValue.getBusinessType()==3){
				net.setProjectName("存款利息");
			}else if(netValue.getBusinessType()==4){
				net.setProjectName("TA清算款");
			}
		}
		return net;
	}

	@Override
	public NetValue selectSecurityArapDetail(NetValue netValue) {
		// TODO Auto-generated method stub
		return netValueDao.selectSecurityArapDetail(netValue);
	}

	@Override
	public NetValue selectBondLiXi(NetValue netValue) {
		// TODO Auto-generated method stub
		return netValueDao.selectBondLiXi(netValue);
	}

	@Override
	public Integer selectTaQuantity(NetValue netValue) {
		// TODO Auto-generated method stub
		return netValueDao.selectTaQuantity(netValue);
	}


}
