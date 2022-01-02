package Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends Baseclass {
	
	@FindBy(id="location")
	private WebElement clonLocation;
	@FindBy(id="hotels")
	private WebElement clonHotels;
	@FindBy(id="room_type")
	private WebElement clonRoomtype;
	@FindBy(id="room_nos")
	private WebElement clonNoofrooms;
	@FindBy(id="datepick_in")
	private WebElement clonCheckindate;
	@FindBy(id="datepick_out")
	private WebElement clonCheckoutdate;
	@FindBy(id="adult_room")
	private WebElement clonAdults;
	@FindBy(id="child_room")
	private WebElement clonChild;
	@FindBy(id="Submit")
	private WebElement btnSearch;
	
	
	public WebElement getClonLocation() {
		return clonLocation;
	}
	public WebElement getClonHotels() {
		return clonHotels;
	}
	public WebElement getClonRoomtype() {
		return clonRoomtype;
	}
	public WebElement getClonNoofrooms() {
		return clonNoofrooms;
	}
	public WebElement getClonCheckindate() {
		return clonCheckindate;
	}
	public WebElement getClonCheckoutdate() {
		return clonCheckoutdate;
	}
	public WebElement getClonAdults() {
		return clonAdults;
	}
	public WebElement getClonChild() {
		return clonChild;
	}
	public WebElement getBtnSearch() {
		return btnSearch;
	}
	
	
	public void seachHotel(String location, String hotels, String roomType, String noofRooms, String checkIn, String checkOut,
			String adults, String childs) {
		select(getClonLocation(), "Text", location);
		select(getClonHotels(), "Text", hotels);
		select(getClonRoomtype(), "Text", roomType);
		select(getClonNoofrooms(), "Text", noofRooms);
		
		sendKeys(getClonCheckindate(), checkIn);
		sendKeys(getClonCheckoutdate(), checkOut);
		
		select(getClonAdults(), "Text", adults);
		select(getClonChild(), "Text", childs);
		click(btnSearch);
	}
	
	public SelectHotelPage(){
		PageFactory.initElements(driver, this);
	}

}
