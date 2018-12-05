package model;

public class Hotel {
	private int hotelId;
	private String hotelName;
	private String hotelAddress;
	private String hotelTel;
	private String hotelMail;
	private String hotelImage;
	private String hotelDetail;

	public Hotel() {}

	/**
	 * 全部入り
	 * @param hotelId
	 * @param hotelName
	 * @param hotelAddress
	 * @param hotelTel
	 * @param hotelMail
	 * @param hotelImage
	 * @param hotelDetail
	 */
	public Hotel(int hotelId, String hotelName, String hotelAddress, String hotelTel, String hotelMail,
			String hotelImage, String hotelDetail) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		this.hotelTel = hotelTel;
		this.hotelMail = hotelMail;
		this.hotelImage = hotelImage;
		this.hotelDetail = hotelDetail;
	}

/**
 * getter
 * @return
 */
	public int getHotelId() {return hotelId;}
	public String getHotelName() {return hotelName;}
	public String getHotelAddress() {return hotelAddress;}
	public String getHotelTel() {return hotelTel;}
	public String getHotelMail() {return hotelMail;}
	public String getHotelImage() {return hotelImage;}
	public String getHotelDetail() {return hotelDetail;}
}
