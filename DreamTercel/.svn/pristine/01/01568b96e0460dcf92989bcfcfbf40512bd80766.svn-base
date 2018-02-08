package com.yidu.parameters.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.parameters.dao.BondDao;
import com.yidu.parameters.domain.Bond;
import com.yidu.parameters.service.BondService;

/**
 * 债劵信息数据库业务逻辑操作抽象接口实现类
 * @author 杨丽
 * @date 2017年11月14日	
 * @time 下午3:33:12
 *
 */
@Transactional
@Service
public class BondServiceImpl implements BondService{
	@Autowired
	BondDao bondDao;

	@Override
	public HashMap<String, Object> selectBonds(String tableName, String qualification, Integer page, Integer rows,
			Integer rowsTotal, String orderColumn, String orderStyle) {
		// TODO Auto-generated method stub
		//new一个map
		HashMap<String,Object> map=new HashMap<String,Object>();
		//sql语句
		tableName="( select * from bond bod join security sec on bod.BOND_CODE=sec.SECURITY_CODE )";
		map.put("tableName",tableName);	//表名
		map.put("qualification",qualification);	//
		map.put("page",page);	//页
		map.put("rows",rows);	//行
		map.put("rowsTotal",rowsTotal);
		map.put("orderColumn","bond_code");	//债劵id
		map.put("orderStyle",orderStyle);
		//调用查询的方法
		bondDao.selectBonds(map);
		map.get("bondList");
		
		return map; 
	}
	@Override
	public String bufferWhere(Bond bond) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer("");
		//判断债劵编号是否为空
		if(bond.getBondCode()!=null && !bond.getBondCode().equals("")){
			buffer=buffer.append(" and bond_code = "+bond.getBondCode());
		}
		//判断计息起始日是否为空
		if(bond.getStrInterestStarDate()!=null && !bond.getStrInterestStarDate().equals("")){
			buffer=buffer.append(" and interest_star_date = to_date('"+bond.getStrInterestStarDate()+"','yyyy-mm-dd')");
		}
		String flag=buffer.toString();
		return flag;
	}
	
	@Override
	public int deleteBondByBondIds(String bondCode) {
		// TODO Auto-generated method stub
		//定义一个数组
		String[] split=bondCode.split(",");
		//定义变量
		int size=0;
		//循环遍历数组大小
		for(int i=0;i<split.length;i++){
			//调用通过id删除的方法
			size=bondDao.deleteBondByBondIds(split[i]);
			++size;
		}
		return size;
	}
	
	@Override
	public int insertBond(Bond bond) {
		// TODO Auto-generated method stub
		//调用债劵增加的方法
		int size=bondDao.insertBond(bond);
		return size;
	}
	@Override
	public void updateBond(Bond bond) {
		// TODO Auto-generated method stub
		//调用修改债劵的方法
		bondDao.updateBond(bond);
	}
	@Override
	public Bond selectBondByIds(String bondCode) {
		// TODO Auto-generated method stub
		//调用通过id查询的方法
		Bond bond=bondDao.selectBondByIds(bondCode);
		return bond;
	}
	@Override
	public List<Bond> selectSecurityTypes(Integer securityType) {
		// TODO Auto-generated method stub
		//调用通过类型查询的方法 加入集合
		List list=bondDao.selectSecurityTypes(securityType);
		System.out.println(list);
		return list;
	}
	
	

}
