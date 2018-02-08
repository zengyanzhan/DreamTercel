package com.yidu.dayEnd.service;
import java.util.List;
import com.yidu.dayEnd.domain.BondAccrual;
/**
 * 债券计息业务逻辑类
 * @author 邓涛
 * @date 2017年11月26日
 * @time 下午6:27:28
 */
public interface BondAccrualService {
	/**
	 * 查询债券利息
	 * @param bondAccrual 债券利息实体类
	 * @return 集合
	 */
	public List selectBondAccrual(BondAccrual bondAccrual,Integer page,Integer rows);
	/**
	 * 通过债券id进行查询
	 * @param bondCode 债券id
	 * @return
	 */
	public List<BondAccrual> selectByIdBondAccrual(String bondCode);
	/**
	 * 查询总条数的方法
	 * @return
	 */
	public int selectSize();
}
