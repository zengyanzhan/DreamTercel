package com.yidu.dayEnd.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yidu.dayEnd.dao.BondAccrualDao;
import com.yidu.dayEnd.domain.BondAccrual;
import com.yidu.dayEnd.service.BondAccrualService;
/**
 * 债券计息实现类
 * @author 邓涛
 * @date 2017年11月26日
 * @time 下午6:28:41
 */
@Service
public class BondAccrualServiceImpl implements BondAccrualService{
	@Autowired
	BondAccrualDao bondAccrualDao;
	/**
	 * 查询的方法
	 */
	@Override
	public List selectBondAccrual(BondAccrual bondAccrual,Integer page,Integer rows) {
		//创建一个变量 用于接收拼接条件
		StringBuffer buffer=new StringBuffer("");
		//如果日期不等于空 且不等于空字符串
		if(bondAccrual.getBusinessDateWhere() != null && ! bondAccrual.getBusinessDateWhere().equals("")){
			buffer.append(" and security_statistics_date=  to_date(' "+bondAccrual.getBusinessDateWhere()+"','yy-MM-dd')");
		}
		//创建map
		Map<Object, Object> map=new HashMap<>();
		//条件
		map.put("sqlWhere", buffer.toString());
		//页
		map.put("page", page);
		//行
		map.put("rows", rows);
		//调用查询的方法
		return bondAccrualDao.selectBondAccrual(map);
	}
	/**
	 * 通过id查询的方法
	 */
	@Override
	public List<BondAccrual> selectByIdBondAccrual(String bondCode) {
		return bondAccrualDao.selectByIdBondAccrual( bondCode);
	}
	@Override
	public int selectSize() {
		// TODO Auto-generated method stub
		return bondAccrualDao.selectSize();
	}
}
