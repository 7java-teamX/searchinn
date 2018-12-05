package model;

import java.io.Serializable;

public class Reserve implements Serializable {
	//reserve_t
	private int reserveId;      //予約id
	private String day; 			//検索用
	private int numOfAdults;	    //大人人数
	private int numOfChildren;     //子供人数
	private String checkin;        //宿泊日
	private int numOfNights;       //泊数(int)
	private String reserveDate;    //宿泊期間
	private int charge;            //合計料金
	private String reserveMemo;    //予約時メモ
	//plan_t
	private int planId;         //プランid
	private String planName;       //プランの名前
	private int numOfRooms;        //部屋の最大数
	private String planImage;      //プラン画像
	private String planDetail;     //プラン説明文
	//hotel_t
	private int hotelId;        //
	private String hotelName;      //ホテルの名前
	private String hotelTel;       //ホテルの電話番号
	private String hotelAddress;  //ホテル住所
	private String hotelMail;      //ホテルメールアドレス
	private String hotelImage;     //ホテル画像
	private String hotelDetail;    //ホテル説明文
	//room_type_t
	private int roomTypeId;     //
	private String roomTypeName;
	private int adultCopacity;     //大人の最大人数
	private int childCopacity;     //子供の最大人数
	private int adultCharge;       //大人料金
	private int childCharge;       //子供料金
	//guest_t
	private int guestId;        //ゲストid
	private String guestName;      //予約者の名前
	private String guestKana;
	private String guestPass;
	private String guestBirthday;
	private String guestTel;
	private String guestMail;
	private String guestAddress;

	public Reserve(){}

	//予約状況管理時の検索情報保持に使用 インスタンス名
	public Reserve(String day,String hotelName,String planName,String guestName){
		this.day = day;
		this.hotelName = hotelName;
		this.planName = planName;
		this.guestName = guestName;
	}

	//予約状況詳細表示時に情報格納で使用
	public Reserve(
			int guestId,
			String guestName,String guestKana, String guestBirthday,
			String guestTel, String guestMail,String guestAddress,
			int reserveId,int numOfAdults, int numOfChildren, String checkin,
			int numOfNights, String reserveDate, int charge, String reserveMemo,
			String planName, String planImage,  String planDetail,
			String hotelName,String hotelAddress, String hotelTel,  String hotelMail, String hotelImage,
			String hotelDetail,   int adultCopacity,
			int childCopacity,  int adultCharge, int childCharge) {
		this.guestId = guestId;
		this.hotelName = hotelName;
		this.planName = planName;
		this.guestName = guestName;
		this.reserveId = reserveId;
		//this.guestId = guestId;
		this.numOfAdults = numOfAdults;
		this.numOfChildren = numOfChildren;
		this.checkin = checkin;
		this.numOfNights = numOfNights;
		this.reserveDate = reserveDate;
		this.charge = charge;
		this.reserveMemo = reserveMemo;
		this.hotelAddress = hotelAddress;
		this.hotelTel = hotelTel;
		this.hotelMail = hotelMail;
		this.hotelImage = hotelImage;
		this.hotelDetail = hotelDetail;
		//this.numOfRooms = numOfRooms;
		this.planImage = planImage;
		this.planDetail = planDetail;
		this.adultCapacity = adultCopacity;
		this.childCapacity = childCopacity;
	
		this.adultCharge = adultCharge;
		this.childCharge = childCharge;
		this.guestKana = guestKana;
		this.guestBirthday = guestBirthday;
		this.guestTel = guestTel;
		this.guestMail = guestMail;
		this.guestAddress = guestAddress;
	}

/**
 * 予約実行用
 * @param numOfAdults
 * @param numOfChildren
 * @param checkin
 * @param numOfNights
 * @param reserveDate
 * @param charge
 * @param reserveMemo
 * @param planId
 * @param planName
 * @param numOfRooms
 * @param planImage
 * @param planDetail
 * @param hotelId
 * @param hotelName
 * @param hotelTel
 * @param hotelAddress
 * @param hotelMail
 * @param hotelImage
 * @param hotelDetail
 * @param roomTypeId
 * @param roomTypeName
 * @param adultCopacity
 * @param childCopacity
 * @param adultCharge
 * @param childCharge
 * @param guestId
 * @param guestName
 * @param guestKana
 * @param guestPass
 * @param guestBirthday
 * @param guestTel
 * @param guestMail
 * @param guestAddress
 */

	public Reserve(int numOfAdults, int numOfChildren, String checkin, int numOfNights,
			String reserveDate, int charge, String reserveMemo, int planId, String planName, int numOfRooms,
			String planImage, String planDetail, int hotelId, String hotelName, String hotelTel,
			String hotelAddress, String hotelMail, String hotelImage, String hotelDetail, int roomTypeId,
			String roomTypeName, int adultCopacity, int childCopacity, int adultCharge, int childCharge, int guestId,
			String guestName, String guestKana, String guestPass, String guestBirthday, String guestTel,
			String guestMail, String guestAddress) {
//		this.reserveId = reserveId;
		this.numOfAdults = numOfAdults;
		this.numOfChildren = numOfChildren;
		this.checkin = checkin;
		this.numOfNights = numOfNights;
		this.reserveDate = reserveDate;
		this.charge = charge;
		this.reserveMemo = reserveMemo;
		this.planId = planId;
		this.planName = planName;
		this.numOfRooms = numOfRooms;
		this.planImage = planImage;
		this.planDetail = planDetail;
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelTel = hotelTel;
		this.hotelAddress = hotelAddress;
		this.hotelMail = hotelMail;
		this.hotelImage = hotelImage;
		this.hotelDetail = hotelDetail;
		this.roomTypeId = roomTypeId;
		this.roomTypeName = roomTypeName;
		this.adultCopacity = adultCopacity;
		this.childCopacity = childCopacity;
		this.adultCharge = adultCharge;
		this.childCharge = childCharge;
		this.guestId = guestId;
		this.guestName = guestName;
		this.guestKana = guestKana;
		this.guestPass = guestPass;
		this.guestBirthday = guestBirthday;
		this.guestTel = guestTel;
		this.guestMail = guestMail;
		this.guestAddress = guestAddress;
	}

	//getter
	//検索条件で利用
	public String getDay() { return day; }
	public String getHotelName() { return hotelName; }
	public String getPlanName() { return planName; }

	public int getReserveId() { return reserveId; }
	public int getNumOfAdults() { return numOfAdults; }
	public int getNumOfChildren() { return numOfChildren; }
	public String getCheckin() { return checkin; }
	public int getNumOfNights() { return numOfNights; }
	public String getReserveDate() { return reserveDate;}
	public int getCharge() {return charge; }
	public String getReserveMemo() { return reserveMemo; }

	public String getHotelAddress() { return hotelAddress; }
	public String getHotelTel() { return hotelTel;}
	public String getHotelMail() { return hotelMail;}
	public String getHotelImage() { return hotelImage;}
	public String getHotelDetail() {	return hotelDetail;}

	public int getNumOfRooms() {return numOfRooms;}
	public String getPlanImage() {return planImage; }
	public String getPlanDetail() {return planDetail; }
	public int getAdultCapacity() {return adultCapacity; }
	public int getChildCapacity() {return childCapacity; }
	public int getAdultCharge() {return adultCharge; }
	public int getChildCharge() { return childCharge; }
  
	public int getGuestId() { return guestId;}
	public String getGuestName() { return guestName; }
	public String getGuestKana() {return guestKana;}
	public String getGuestBirthday() {return guestBirthday;}
	public String getGuestTel() { return guestTel; }
	public String getGuestMail() { return guestMail; }
	public String getGuestAddress() { return guestAddress; }

	public int getPlanId() {return planId;}
	public int getHotelId() {return hotelId;}
	public int getRoomTypeId() {return roomTypeId;}
	public String getRoomTypeName() {return roomTypeName;}
	public String getGuestPass() {return guestPass;}
  
  public void setNumOfAdults(int numOfAdults) {this.numOfAdults = numOfAdults;}
	public void setNumOfChildren(int numOfChildren) {this.numOfChildren = numOfChildren;}
	public void setCharge(int charge) {this.charge = charge;}
}
