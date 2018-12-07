package beans;

public class Area {
	private int areaId;
	private String areaName;

	public Area() {}

	/**
	 * @param areaId
	 * @param areaName
	 */
	public Area(int areaId, String areaName) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
	}
	/**
	 * getter
	 * @return
	 */
	public int getAreaId() {return areaId;}
	public String getAreaName() {return areaName;}
}
