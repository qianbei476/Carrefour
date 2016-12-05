package bean;

public class Goods {
	
	private int Goodsid;
	
	private String goodsname;
	
	private int goodsnumber;
	
	private double goodsprice;
	
	private String goodsimgurl;

	public int getGoodsnumber() {
		return goodsnumber;
	}

	public void setGoodsnumber(int goodsnumber) {
		this.goodsnumber = goodsnumber;
	}
	
	public int getGoodsid() {
		return Goodsid;
	}

	public void setGoodsid(int goodsid) {
		Goodsid = goodsid;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public double getGoodsprice() {
		return goodsprice;
	}

	public void setGoodsprice(double goodsprice) {
		this.goodsprice = goodsprice;
	}

	public String getGoodsimgurl() {
		return goodsimgurl;
	}

	public void setGoodsimgurl(String goodsimgurl) {
		this.goodsimgurl = goodsimgurl;
	}
}
