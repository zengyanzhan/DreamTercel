package com.yidu.taManagement.dao;

import java.util.Map;
import org.springframework.stereotype.Repository;
import com.yidu.taManagement.domain.TaTradData;
@Repository
public interface TaTradDataDao {
		/**
		 * 查询
		 * @param map 封装所有条件
		 */
		public void selectTaTradData(Map<String, Object> map);
		/**
		 * 条件拼接
		 * @param taStock ta库存对象
		 * @return 封装好的条件
		 */
		public String bufferWhere(TaTradData taTradData);
		/**
		 * 删除
		 * @param taTradDataCode Ta交易数据的ID
		 * @return
		 */
		public int deleteTaTradDataByTaTradDataId(String taTradDataCode);
		/**
		 * 修改
		 * @param taTradData
		 * @return
		 */
		public int updateTaTradData(TaTradData taTradData);
		
		/**
		 * 增加
		 * @param taTradData
		 * @return
		 */
		public int insertTaTradData(TaTradData taTradData);
		/**
		 * 根据Id查询
		 * @param taTradDataCode
		 * @return
		 */
		public TaTradData selectTaTradDataById(String taTradDataCode);
		/**
		 *修改 ta交易数据结算
		 * @param TaTradDataCode
		 * @return
		 */
		public int updateStatus(TaTradData taTradData);
}
