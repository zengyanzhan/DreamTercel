package com.yidu.reportManagement.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.yidu.reportManagement.domain.FundInvestBlockReport;

/**
 * 基金投资板块表的链接数据库的操作类
 * @author 杨丽
 * @date 2017年12月7日	
 * @time 上午11:27:07
 *
 *
 */
@Repository
public interface FundInvestBlockReportDao {
	/**
	 * 查询基金投资板块表的数据
	 * @param map
	 */
	@Select("select  sb.stock_block_name as stockBlockName,sum(ss.security_quantity) as assecurityQuantity, sum(pd.pd_closingPrice*ss.security_quantity) as marketValue, avg(nvl((pd.pd_closingPrice*ss.security_quantity)/nv.PROJECT_CODE,0)) as marketValuePercentage  from (select * from security ) se  join (select * from stock_block) sb on sb.stock_block_father_code=se.stock_plate_code join (select * from security_stock)ss on se.security_code=ss.security_code join (select * from priceData) pd  on pd.pd_securityCode=ss.security_code join (select * from net_value where project_name='资产净值') nv on ss.fund_code=nv.fund_code and ss.security_statistics_date=nv.statistic_date and ss.fund_code=nv.fund_code where  nv.fund_code='${fundCode}'  and  pd.pd_enteringDate=to_date('${statisticDateWhere}','yyyy-mm-dd')  group by sb.stock_block_name")
	public List<FundInvestBlockReport> selectFundInvestBlocks(@Param("fundCode")String fundCode,@Param("statisticDateWhere")String statisticDateWhere);
	
}
