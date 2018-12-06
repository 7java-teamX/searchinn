package model;

import java.io.Serializable;

public class RoomType implements Serializable {
	private int roomTypeId;
	private String roomTypeName;
	private int adultCapacity;
	private int childCapacity;
	private int adultCharge;
	private int childCharge;

	public RoomType() {}

	/**
	 * 登録用
	 * @param roomTypeName
	 * @param adultCapacity
	 * @param childCapacity
	 * @param adultCharge
	 * @param childCharge
	 */
	public RoomType(String roomTypeName, int adultCapacity, int childCapacity, int adultCharge, int childCharge) {
		super();
		this.roomTypeName = roomTypeName;
		this.adultCapacity = adultCapacity;
		this.childCapacity = childCapacity;
		this.adultCharge = adultCharge;
		this.childCharge = childCharge;
	}

	/**
	 * @param roomTypeId
	 * @param roomTypeName
	 * @param adultCapacity
	 * @param childCapacity
	 * @param adultCharge
	 * @param childCharge
	 */
	public RoomType(int roomTypeId, String roomTypeName, int adultCapacity, int childCapacity, int adultCharge,
			int childCharge) {
		super();
		this.roomTypeId = roomTypeId;
		this.roomTypeName = roomTypeName;
		this.adultCapacity = adultCapacity;
		this.childCapacity = childCapacity;
		this.adultCharge = adultCharge;
		this.childCharge = childCharge;
	}

	public int getRoomTypeId() {return roomTypeId;}
	public String getRoomTypeName() {return roomTypeName;}
	public int getAdultCapacity() {return adultCapacity;}
	public int getChildCapacity() {return childCapacity;}
	public int getAdultCharge() {return adultCharge;}
	public int getChildCharge() {return childCharge;}


}
