package bean;

import java.util.Date;
import java.util.List;

public class Oder {		//订单
	
	private int Oid;				//订单号
	
	private int OdertoUserid;		//标识订单是哪个用户的
	
	private List<Goods> Allgoodsid;	//一个订单内的goods编号
	
	private Date Odertime;			//下单日期

	public int getOid() {
		return Oid;
	}

	public void setOid(int oid) {
		Oid = oid;
	}

	public int getOdertoUserid() {
		return OdertoUserid;
	}

	public void setOdertoUserid(int odertoUserid) {
		OdertoUserid = odertoUserid;
	}

	public List<Goods> getAllgoodsid() {
		return Allgoodsid;
	}

	public void setAllgoodsid(List<Goods> allgoodsid) {
		Allgoodsid = allgoodsid;
	}

	public Date getOdertime() {
		return Odertime;
	}

	public void setOdertime(Date odertime) {
		Odertime = odertime;
	}
	
	
}
