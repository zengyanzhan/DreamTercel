package com.yidu.Android.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.Android.dao.NetAssetValueDao;
import com.yidu.Android.domain.Message;
import com.yidu.Android.domain.NetValueEntity;
import com.yidu.Android.domain.SecurityMarket;
import com.yidu.Android.service.NetAssetValueService;
import com.yidu.businessData.domain.PriceData;
import com.yidu.dayEnd.domain.NetValue;
import com.yidu.parameters.domain.Fund;
import com.yidu.parameters.domain.Security;
import com.yidu.stockControl.domain.SecurityStock;
import com.yidu.system.domain.User;
@Service("netAssetValueService")
public class NetAssetValueServiceImpl implements NetAssetValueService{
	@Autowired
	NetAssetValueDao netAssetValueDao;
	@Override
	public List<NetValue> selectNetAssetValue(String fundCode) {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectNetAssetValue(fundCode);
	}

	@Override
	public List<NetValue> selectUnitNet(String fundCode) {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectUnitNet(fundCode);
	}

	@Override
	public List selectStockTrading() {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectStockTrading();
	}

	@Override
	public List selectVolumeStatistics() {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectVolumeStatistics();
	}

	@Override
	public List selectVolumeStatisticsByDate(Map hashMap) {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectVolumeStatisticsByDate(hashMap);
	}

	
	public List selectStockTradingByDate(Map hashMap) {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectStockTradingByDate(hashMap);
	}

	@Override
	public List<Security> selectStockAll() {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectStockAll();
	}

	@Override
	public List<PriceData> selectHangQingChaAll(String id) {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectHangQingChaAll(id);
	}
	@Override
	public List<Security> selectSecurityCode(String name) {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectSecurityCode(name);
	}

	@Override
	public List<NetValue> selectNetValueChaAlls() {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectNetValueChaAlls();
	}

	@Override
	public List<Message> selectAllMessage() {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectAllMessage();
	}

	@Override
	public List<SecurityMarket> selectSecurityMarket() {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectSecurityMarket();
	}

	@Override
	public List<SecurityStock> selectAllSecurity() {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectAllSecurity();
	}

	@Override
	public List<SecurityStock> selectAllSecurityByCode(String code) {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectAllSecurityByCode(code);
	}

	@Override
	public List<PriceData> selectHangQingChaByDateAndId(String id, String date) {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectHangQingChaByDateAndId(id, date);
	}

	@Override
	public List<SecurityStock> selectSecurityMarketByDate(String code, String openDate, String endDate) {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectSecurityMarketByDate(code, openDate, endDate);
	}

	@Override
	public List<PriceData> selectHangQingByDate(String code, String openDate, String endDate) {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectHangQingByDate(code, openDate, endDate);
	}

	@Override
	public List<NetValue> selectNetValueChaAllsByDate(String openDate, String endDate) {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectNetValueChaAllsByDate(openDate, endDate);
	}

	@Override
	public List<Fund> selectFundNameByCode(String code) {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectFundNameByCode(code);
	}

	@Override
	public List<SecurityStock> selectAllSecurityByDate(String openDate, String endDate) {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectAllSecurityByDate(openDate, endDate);
	}

	@Override
	public List<Fund> selectAllFund() {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectAllFund();
	}


	@Override
	public List<User> selectUserByNameAndPwd(String name, String pwd) {
		// TODO Auto-generated method stub
		return this.netAssetValueDao.selectUserByNameAndPwd(name, pwd);
	}
}
