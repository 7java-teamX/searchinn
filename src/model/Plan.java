/**
 *
 */
package model;

import java.io.Serializable;

/**
 * @author kentaro
 *
 */
public class Plan implements Serializable {
	private int planId;
	private String planName;
	private int numRoom;
	private String planImage;
	private String planDetail;
	private int roomTypeId;
	private String roomTypeName;
	private int adultCapacity;
	private int childCapacity;
	private int adultCharge;
	private int childCharge;
	private int hotelId;
	private String hotelName;
	private String hotelAddress;
	private String hotelTel;
	private String hotelmail;
	private String hotelImage;
	private String hotelDetail;

	public Plan() {}
	/**
	 * @param planId
	 * @param planName
	 * @param numRoom
	 * @param planImage
	 * @param planDetail
	 * @param roomTypeId
	 * @param roomTypeName
	 * @param adultCapacity
	 * @param childCapacity
	 * @param adultCharge
	 * @param childCharge
	 * @param hotelId
	 * @param hotelName
	 * @param hotelAddress
	 * @param hotelTel
	 * @param hotelmail
	 * @param hotelImage
	 * @param hotelDetail
	 */
	public Plan(int planId, String planName, int numRoom, String planImage, String planDetail, int roomTypeId,
			String roomTypeName, int adultCapacity, int childCapacity, int adultCharge, int childCharge, int hotelId,
			String hotelName, String hotelAddress, String hotelTel, String hotelmail, String hotelImage,
			String hotelDetail) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.numRoom = numRoom;
		this.planImage = planImage;
		this.planDetail = planDetail;
		this.roomTypeId = roomTypeId;
		this.roomTypeName = roomTypeName;
		this.adultCapacity = adultCapacity;
		this.childCapacity = childCapacity;
		this.adultCharge = adultCharge;
		this.childCharge = childCharge;
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		this.hotelTel = hotelTel;
		this.hotelmail = hotelmail;
		this.hotelImage = hotelImage;
		this.hotelDetail = hotelDetail;
	}

	public int getPlanId() {
		return planId;
	}
	public String getPlanName() {
		return planName;
	}
	public int getNumRoom() {
		return numRoom;
	}
	public String getPlanImage() {
		return planImage;
	}
	public String getPlanDetail() {
		return planDetail;
	}
	public int getRoomTypeId() {
		return roomTypeId;
	}
	public String getRoomTypeName() {
		return roomTypeName;
	}
	public int getAdultCapacity() {
		return adultCapacity;
	}
	public int getChildCapacity() {
		return childCapacity;
	}
	public int getAdultCharge() {
		return adultCharge;
	}
	public int getChildCharge() {
		return childCharge;
	}
	public int getHotelId() {
		return hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public String getHotelAddress() {
		return hotelAddress;
	}
	public String getHotelTel() {
		return hotelTel;
	}
	public String getHotelmail() {
		return hotelmail;
	}
	public String getHotelImage() {
		return hotelImage;
	}
	public String getHotelDetail() {
		return hotelDetail;
	}
}
