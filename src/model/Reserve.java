package model;

import java.io.Serializable;

public class Reserve implements Serializable {
	private String day; //開始日
	private String hotelName;  //ホテルの名前
	private String planName;   //プランの名前
	private String guestName;  //予約者の名前

	private String reserveId;      //予約id
	private String guestId;        //ゲストid
	//private String planId;        //プランid
	private int numOfAdults;    //大人人数
	private int numOfChildren;  //子供人数
	private String checkin;        //宿泊日
	private int numOfNights;      //泊数(int)
	private String reserveDate;    //宿泊期間
	private int charge;            //合計料金
	private String reserveMemo;    //予約時メモ

	private String hotel_address;  //ホテル住所
	private String hotelTel;       //ホテルの電話番号
	private String hotelMail;      //ホテルメールアドレス
	private String hotelImage;     //ホテル画像
	private String hotelDetail;    //ホテル説明文
	//private String hotelId;       //
	//private String roomTypeId;    //

	private int numOfRooms;     //部屋の最大数
	private String planImage;      //プラン画像
	private String planDetail;     //プラン説明文
	private int adultCopacity;     //大人の最大人数
	private int childCopacity;     //子供の最大人数
	private int adultCharge;       //大人料金
	private int childCharge;       //子供料金

	//guestテーブル
	private String guestKana;
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
			String guestId,    //ゲストid
			String guestName,String guestKana, String guestBirthday,
			String guestTel, String guestMail,String guestAddress,
			String reserveId,int numOfAdults, int numOfChildren, String checkin,
			int numOfNights, String reserveDate, int charge, String reserveMemo,
			String planName, String planImage,  String planDetail,
			String hotelName,String hotel_address, String hotelTel,  String hotelMail, String hotelImage,
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
		this.hotel_address = hotel_address;
		this.hotelTel = hotelTel;
		this.hotelMail = hotelMail;
		this.hotelImage = hotelImage;
		this.hotelDetail = hotelDetail;
		//this.numOfRooms = numOfRooms;
		this.planImage = planImage;
		this.planDetail = planDetail;
		this.adultCopacity = adultCopacity;
		this.childCopacity = childCopacity;
		this.adultCharge = adultCharge;
		this.childCharge = childCharge;
		this.guestKana = guestKana;
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

	public String getReserveId() { return reserveId; }
	public int getNumOfAdults() { return numOfAdults; }
	public int getNumOfChildren() { return numOfChildren; }
	public String getCheckin() { return checkin; }
	public int getNumOfNights() { return numOfNights; }
	public String getReserveDate() { return reserveDate;}
	public int getCharge() {return charge; }
	public String getReserveMemo() { return reserveMemo; }

	public String getHotel_address() { return hotel_address; }
	public String getHotelTel() { return hotelTel;}
	public String getHotelMail() { return hotelMail;}
	public String getHotelImage() { return hotelImage;}
	public String getHotelDetail() {	return hotelDetail;}

	public int getNumOfRooms() {return numOfRooms;}
	public String getPlanImage() {return planImage; }
	public String getPlanDetail() {return planDetail; }
	public int getAdultCopacity() {return adultCopacity; }
	public int getChildCopacity() {return childCopacity; }
	public int getAdultCharge() {return adultCharge; }
	public int getChildCharge() { return childCharge; }

	public String getGuestId() { return guestId;}
	public String getGuestName() { return guestName; }
	public String getGuestKana() {return guestKana;}
	public String getGuestBirthday() {return guestBirthday;}
	public String getGuestTel() { return guestTel; }
	public String getGuestMail() { return guestMail; }
	public String getGuestAddress() { return guestAddress; }

}
