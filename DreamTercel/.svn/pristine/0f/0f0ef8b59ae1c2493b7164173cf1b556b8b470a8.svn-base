package com.yidu.businessData.serivce.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.businessData.dao.SaveingBusinessDao;
import com.yidu.businessData.domain.SaveingBusiness;
import com.yidu.businessData.service.SaveingBusinessService;

/**
 * 存款业务的实现类
 * @author ChenJiaLong
 * @date 2017年11月17日
 * @time 下午2:28:33
 *
 */
@Transactional
@Service
public class SaveingBusinessServiceImpl implements SaveingBusinessService{

	@Autowired
	private SaveingBusinessDao saveingBusinessDao;
	/**
	 * 实现类 存款业务的查询方法
	 */
	@Override
	public Map<String, Object> selectSaveingBusiness(SaveingBusiness saveingBusiness) {
		StringBuffer bufferStr = new StringBuffer("");//创建StringBuffer 用于条件拼接

		//使用编号和业务时间来进行条件判断查询
        if(saveingBusiness.getFlag()!=0){
			bufferStr.append(" and saving_flag="+saveingBusiness.getFlag());
		}else if(saveingBusiness.getStrDate()!=null&&!saveingBusiness.getStrDate().equals("")){
			bufferStr.append("  and business_date=to_date('"+saveingBusiness.getStrDate()+"','yyyy-MM-dd') ");
		}else if(saveingBusiness.getStrDateEnd()!=null&&!saveingBusiness.getStrDateEnd().equals("")){
			bufferStr.append("  and saving_end_date=to_date('"+saveingBusiness.getStrDateEnd()+"','yyyy-MM-dd') ");
		}
			
		Map<String, Object> map = new HashMap<String, Object>();//创建HashMap
		map.put("tabName", "saveing_business");//表名
		map.put("qualification",bufferStr.toString());
		map.put("page", saveingBusiness.getPage());//显示的页面
		map.put("rows", saveingBusiness.getRows());//页面所显示的行数
		map.put("orderColumn", saveingBusiness.getSortName());//列字段
		map.put("orderStyle", saveingBusiness.getSortOrder());//表格排列方式
		saveingBusinessDao.selectSaveingBusiness(map);//调用查询存款业务的方法

		return map;//返回map到jsp	
	}
	/**
	 * 实现类 存款业务的新增方法
	 */
	@Override
	public int insertSaveingBusiness(SaveingBusiness saveingBusiness) {
		// TODO Auto-generated method stub
		return saveingBusinessDao.insertSaveingBusiness(saveingBusiness);
	}
	/**
	 * 实现类 存款业务的删除方法
	 */
	@Override
	public int deleteSaveingBusiness(SaveingBusiness saveingBusiness) {
		// TODO Auto-generated method stub
		return saveingBusinessDao.deleteSaveingBusiness(saveingBusiness);
	}
	/**
	 * 实现类 存款业务的修改方法
	 */
	@Override
	public int updateSaveingBusiness(SaveingBusiness saveingBusiness) {
		// TODO Auto-generated method stub
		return saveingBusinessDao.updateSaveingBusiness(saveingBusiness);
	}
	/**
	 * 实现类 根据编号查询一条数据
	 */
	@Override
	public SaveingBusiness selectSaveingBusinessByCode(String SavingCode) {
		// TODO Auto-generated method stub
		return saveingBusinessDao.selectSaveingBusinessByCode(SavingCode);
	}

}
