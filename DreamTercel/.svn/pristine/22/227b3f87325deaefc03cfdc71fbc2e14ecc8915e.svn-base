package com.yidu.parameters.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.parameters.dao.BroketDao;
import com.yidu.parameters.dao.SeatDao;
import com.yidu.parameters.domain.Broket;
import com.yidu.parameters.domain.Seat;
import com.yidu.parameters.service.SeatService;

/**
 * 交易席位业务逻辑处理实现类
 * @author Wang
 * @date 2017年11月16日
 * @time 下午6:28:00
 */
@Service
public class SeatServiceiImpl implements SeatService{
	@Autowired
	SeatDao seatDao;
	@Autowired
	BroketDao broketDao;
	@Override
	public Map<String, Object> selectSeat(Seat seat) {
		//条件拼接
		StringBuffer qualification=new StringBuffer("");
		//根据交易所名称模糊查询
		if(seat.getSeatType()!=null&&!seat.equals("")){
			qualification.append("  and seat_type  = "+seat.getSeatType());
		}
		//根据费率类型查询
		String seatName=null;
		try {
			seatName=new String(seat.getSeatName().getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(seatName!=null&&!seatName.equals("")){
			qualification.append("  and seat_name   like '%"+seatName+"%'");
		}
		System.out.println("ssddd"+qualification.toString()+","+seat.getSortOrder());
		System.out.println(seat.getPage());
		System.out.println(seat.getRows());
		//分页查询条件map
		Map<String, Object> map=new HashMap<String, Object>();
		//分页条件查询的条件
		map.put("tableName", "trade_seat");
		map.put("qualification", qualification.toString());
		map.put("page", seat.getPage());
		map.put("rows", seat.getRows());
		map.put("orderColumn", "trade_seat_code");
		map.put("orderStyle",seat.getSortOrder());
		//执行查询方法
		seatDao.selectSeat(map);
		//得到交易费率数据的集合
		List<Seat> seatList=(List<Seat>) map.get("cursor");
		for (int i = 0; i <seatList.size(); i++) {
			seat=seatList.get(i);
			List<Broket> broketList=broketDao.selectBroketById(seat.getBrokerCode());
			for (int j = 0; j < broketList.size(); j++) {
				Broket broket=broketList.get(j);
				seat.setBrokerCode(broket.getBrokerName());
			}
		}
		//得到查询总条数
		int rowsTotal=(int) map.get("rowsTotal");
		//分页集合map
		Map<String, Object> seatMap=new HashMap<String, Object>();
		seatMap.put("total", rowsTotal);
		seatMap.put("rows", seatList);
		return seatMap;
	}

	@Override
	public int insertSeat(Seat seat) {
		// TODO Auto-generated method stub
		return seatDao.insertSeat(seat);
	}

	@Override
	public int updateSeat(Seat seat) {
		// TODO Auto-generated method stub
		return seatDao.updateSeat(seat);
	}

	@Override
	public int deleteSeat(Seat seat) {
		// TODO Auto-generated method stub
		return seatDao.deleteSeat(seat);
	}

	@Override
	public List<Seat> selectSeatById(String seatCode) {
		// TODO Auto-generated method stub
		return seatDao.selectSeatById(seatCode);
	}
}
