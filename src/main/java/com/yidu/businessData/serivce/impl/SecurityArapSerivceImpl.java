package com.yidu.businessData.serivce.impl;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yidu.businessData.dao.SecurityArapDao;
import com.yidu.businessData.domain.SecurityArap;
import com.yidu.businessData.service.SecurityArapService;
/**
 * 证券应收应付实现类
 * @author 邓涛
 * @date 2017年11月17日
 * @time 下午2:17:29
 */
@Service
public class SecurityArapSerivceImpl implements SecurityArapService{
	@Autowired
	SecurityArapDao securityArapDao;
	/**
	 * 增加的方法
	 */
	@Override
	public int insertSecurityArap(SecurityArap securityArap) {
		// TODO Auto-generated method stub
		return securityArapDao.insertSecurityArap(securityArap);
	}
	/**
	 * 删除的方法
	 */
	@Override
	public int deleteSecurityArap(SecurityArap securityArap) {
		// TODO Auto-generated method stub
		return securityArapDao.deleteSecurityArap(securityArap);
	}
	/**
	 * 修改的方法
	 */
	@Override
	public int updateSecurityArap(SecurityArap securityArap) {
		// TODO Auto-generated method stub
		return securityArapDao.updateSecurityArap(securityArap);
	}
	/**
	 * 查询的方法
	 */
	@Override
	public Map<String, Object> selectSecurityArap(SecurityArap securityArap) {
		//得到证券应收应付的基金
		String fundCode=securityArap.getFundCode();
		//这里需要对条件进行拼接 使用缓冲字符串
		StringBuffer buffwhere=new StringBuffer("  and fund_code='"+fundCode+"'");
		//如果得到的日期不等于空 且不等于空字符串
		if(securityArap.getStrDateWhere()!=null && !securityArap.getStrDateWhere().equals("")){
			//追加
			buffwhere.append(" and business_date=  to_date(' "+securityArap.getStrDateWhere()+"','yyyy-MM-dd')");
		}
		//如果得到的类型不等于空 且不等于0
		if(securityArap.getSecurityArapType() != null && securityArap.getSecurityArapType()!=0){
			//追加
			buffwhere.append("  and security_arap_type ="+securityArap.getSecurityArapType());
		}
		//创建map集合
		HashMap<String, Object> map=new HashMap<String, Object>();//创建一个map
		//表名
		map.put("tabName", "security_arap");
		//条件
		map.put("qualification", buffwhere.toString());
		//页
		map.put("page",securityArap.getPage());
		//行
		map.put("rows",securityArap.getRows());
		//排序的列
		map.put("orderColumn","security_arap_code");
		//排序方式
		map.put("orderStyle",securityArap.getOrderStyle());
		//查询的方法
		securityArapDao.selectSecurityArap(map);
		return map;
	}
	/**
	 * 通过code查询的方法
	 */
	@Override
	public SecurityArap selectSecurityArapById(String securityArapCode) {
		// TODO Auto-generated method stub
		return securityArapDao.selectSecurityArapById(securityArapCode);
	}
	/**
	 * 通过4个条件进行删除的方法
	 */
	@Override
	public int deleteSqlWhereSecurityArap(String cashAccountCode, Date businessDate, String fundCode,
			Integer securityArapType) {
		// TODO Auto-generated method stub
		return securityArapDao.deleteSqlWhereSecurityArap(cashAccountCode, businessDate, fundCode, securityArapType);
	}
}
