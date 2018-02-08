package com.yidu.dayEnd.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yidu.dayEnd.dao.TwoCostDao;
import com.yidu.dayEnd.domain.TwoCost;
import com.yidu.dayEnd.service.TwoCostService;
/**
 * 两费实现类
 * @author 邓涛
 * @date 2017年12月5日
 * @time 上午12:26:18
 */
@Service
public class TwoCostServiceImpl implements TwoCostService{
	@Autowired
	TwoCostDao twoCostDao;
	/**
	 * 查询的方法
	 */
	@Override
	public List selectTwoCost(TwoCost twoCost) {
		//创建一个变量 用于接收拼接条件
		StringBuffer buffer=new StringBuffer("");
		//如果日期不等于空 且不等于空字符串
		if(twoCost.getBusinessDateWhere()!=null && ! twoCost.getBusinessDateWhere().equals("")){
			//拼接条件
			buffer.append(" and statistic_date=  to_date('"+twoCost.getStatisticDate()+"','yyyy-MM-dd')");
		}
		//创建map
		Map<Object, Object> map=new HashMap<>();
		//条件
		map.put("sqlWhere", buffer.toString());
		//调用查询两费的方法
		return twoCostDao.selectTwoCost(map);
	}
	/**
	 * 调用通过id查询的方法
	 */
	@Override
	public List<TwoCostDao> selectByIdTwoCost(String cashAccountCode) {
		//创建map
		Map<String,Object> map=new HashMap<String,Object>();
		//放的是现金账户
		map.put("cashAccountCode", cashAccountCode);
		//调用通过id查询的方法
		return twoCostDao.selectByIdTwoCost(map);
	}
}
