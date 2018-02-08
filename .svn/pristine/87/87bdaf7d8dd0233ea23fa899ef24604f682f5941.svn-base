package com.yidu.parameters.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.parameters.domain.Fund;
import com.yidu.parameters.domain.Trustee;

/**
* @author YiWenQi 
* @version 创建时间：2017年11月22日 下午1:49:44
* 托管人的Dao类
*/
@Repository
public interface TrusteeDao {
	/**
	 * 分页查询
	 * @param map
	 */
	public void selectTrusteeRow(Map<String, Object> map);
	/**
	 * 新增的托管人
	 * @param trustee 托管人的实体类
	 * @return
	 */
	public int insertTrustee(Trustee trustee);
	/**
	 * 修改的托管人
	 * @param trustee 托管人的实体类
	 * @return
	 */
	public int updateTrustee(Trustee trustee);
	/**
	 * 删除的托管人
	 * @param trustee 托管人的实体类
	 * @return
	 */
	public int deleteTrustee(Trustee trustee);
	/**
	 * 通过编号查询数据
	 * @param trustee 托管人的实体类
	 * @return
	 */
	public Trustee selectTrusteeByCode(Trustee trustee);
}
