package com.yidu.reportManagement.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.reportManagement.dao.DealSetterReportDao;
import com.yidu.reportManagement.domain.DealSettleAccounts;
import com.yidu.reportManagement.service.DealSettleAccountsService;
import com.yidu.util.AllUtil;

/**
 * 成交清算日报表服务实现类
 * @author Wang
 * @date 2017年12月7日
 * @time 下午6:45:22
 */
@Service
public class DealSettleAccountsServiceImpl implements DealSettleAccountsService{
	@Autowired
	DealSetterReportDao dealSetterReportDao;
	@Override
	public Map<String, Object> selectDealSettleAccounts(DealSettleAccounts dealSettleAccounts,String fundCode) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("fundCode", fundCode);
		map.put("dealDate", dealSettleAccounts.getStrDealDate());
		List<DealSettleAccounts> settleAccountList= dealSetterReportDao.selectDealSettleAccounts(map);
		//得到交易费率数据的集合
		for (DealSettleAccounts settleAccounts:settleAccountList) {
			String dealLeixing="";
			Integer dealType=settleAccounts.getDealType();
			Integer securityType=settleAccounts.getSecurityType();
			if(dealType==1){
				dealLeixing=dealLeixing+"买入";
			}else if(dealType==2){
				dealLeixing=dealLeixing+"卖出";
			}else if(dealType==3){
				dealLeixing=dealLeixing+"分红";
			}else if(dealType==4){
				dealLeixing=dealLeixing+"送股";
			}
			if(securityType==1){
				dealLeixing=dealLeixing+"股票";
			}else if(securityType==2){
				dealLeixing=dealLeixing+"债券";
			}else{
				dealLeixing=dealLeixing+"";
			}
			settleAccounts.setDealLeixing(dealLeixing);
		}
		System.out.println("ssa"+settleAccountList.size());
		if(settleAccountList.size()!=0){
			//计算流入流出金额
			//流出合计实体类
			DealSettleAccounts lcAccounts=null;
			DealSettleAccounts lrAccounts=null;
			Iterator<DealSettleAccounts> iterator=settleAccountList.iterator();
			Double realCollectFee=0d;
			double lrRealCollectFee=0d;
			while(iterator.hasNext()){
				DealSettleAccounts settleAccounts= iterator.next();
				Integer dealType=settleAccounts.getDealType();
				if(dealType==1){
					realCollectFee=realCollectFee+settleAccounts.getRealCollectFee();
				}else if(dealType==2){
					lrRealCollectFee=lrRealCollectFee+settleAccounts.getRealCollectFee();
				}else if(dealType==3){
					lrRealCollectFee=lrRealCollectFee+settleAccounts.getRealCollectFee();
				}
				lcAccounts=new DealSettleAccounts(null, "流出合计", null, null,null , null, null, null, null, null, null, AllUtil.getRoundUp(realCollectFee), null);
				lrAccounts=new DealSettleAccounts(null, "流入合计", null, null,null , null, null, null, null, null, null, AllUtil.getRoundUp(lrRealCollectFee), null);
			}
			settleAccountList.add(lrAccounts);
			settleAccountList.add(lcAccounts);
			//计算合计金额
			DealSettleAccounts heJiAccounts=null;
			double lcMoney=0d;  
			double lrMoney=0d;
			for (int i = 0; i < settleAccountList.size(); i++) {
				if(settleAccountList.get(i).getSecurityName().equals("流出合计")){
					System.out.println(settleAccountList.get(i).getSecurityName());
					lcMoney=settleAccountList.get(i).getRealCollectFee();
				}else if(settleAccountList.get(i).getSecurityName().equals("流入合计")){
					System.out.println(settleAccountList.get(i).getSecurityName());
					lrMoney=settleAccountList.get(i).getRealCollectFee();
				}
				heJiAccounts=new DealSettleAccounts(null, "清算合计", null, null,null , null, null, null, null, null, null, AllUtil.getRoundUp(lrMoney-lcMoney), null);
			}
			settleAccountList.add(heJiAccounts);
		}
		//得到查询总条数
		int rowsTotal=dealSetterReportDao.selectCount(map);
		//分页集合map
		Map<String, Object> settleAccountMap=new HashMap<String, Object>();
		settleAccountMap.put("total", rowsTotal);
		settleAccountMap.put("rows", settleAccountList);
		return settleAccountMap;
	}

}
