package beans;

import java.io.Serializable;

public class SalesInfo implements Serializable {
	private int areaId;
	private String areaName;
	private int hotelId;
	private String hotelName;
	private int sales;

	public SalesInfo() {}
	/**
	 * hotelSales用
	 * @param areaId
	 * @param areaName
	 * @param hotelId
	 * @param hotelName
	 * @param sales
	 */
	public SalesInfo(int areaId, String areaName, int hotelId, String hotelName, int sales) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.sales = sales;
	}
	/**
	 * areaSales用
	 * @param areaId
	 * @param areaName
	 * @param sales
	 */
	public SalesInfo(int areaId, String areaName, int sales) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
		this.sales = sales;
	}
	/**
	 * totalSales用
	 * @param sales
	 */
	public SalesInfo(int sales) {
		super();
		this.sales = sales;
	}
	/**
	 * getter
	 */
	public int getAreaId() {
		return areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public int getHotelId() {
		return hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public int getSales() {
		return sales;
	}

}
