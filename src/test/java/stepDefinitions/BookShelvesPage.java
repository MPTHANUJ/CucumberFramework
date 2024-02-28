package stepDefinitions;

import java.io.IOException;
import java.util.Map;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BookShelves;
import pageObjects.GiftCards;
import pageObjects.Living;
import pageObjects.UrbanLadderHomePage;

public class BookShelvesPage {
	
	BookShelves BS;
	
	UrbanLadderHomePage UP;
	
	Living LV;
	
	GiftCards GC;

	@Given("the user is directed to the UrbanLadder homepage")
	public void the_user_is_directed_to_the_urban_ladder_homepage() {
	    
		UP = new UrbanLadderHomePage(BaseClass.getDriver());
	}

	@Given("the user searches for {string}")
	public void the_user_searches_for(String string) {
	    
		UP.search_BookShelves(string);
		BaseClass.getLogger().info("The user searches for BookShelves");
	}

	@Then("the user should be able to see BookShelves products")
	public void the_user_should_be_able_to_see_book_shelves_products() {
	    
		BS = new BookShelves(BaseClass.getDriver());
		BS.clickPopUp();
		BaseClass.getLogger().info("The PopUp is closed");
	}

	@Then("the user must select KidsBookshelves in the dropdown")
	public void the_user_must_select_kids_bookshelves_in_the_dropdown() {
	   
		BS.selectCategory();
		BS.selectBookShelves();
		BaseClass.getLogger().info("The user selects KidsBookShelves from category");
		
	}

	@Then("the user must select the Price range of the products")
	public void the_user_must_select_the_price_range_of_the_products() {
	    
		BS.selectPrice();
		BS.selectPriceRange();
		BaseClass.getLogger().info("The user selects the Price Range");
	}

	@Then("the user must select Exclude Out of Box")
	public void the_user_must_select_exclude_out_of_box() {
	    
		BS.selectoutOfStock();
		BaseClass.getLogger().info("The user selects Out of Stock option");
	}

	@When("the user selects the product range from Recommended")
	public void the_user_selects_the_product_range_from_recommended() {
	    
		BS.selectRecommended();
		BS.selectOrder();
		BaseClass.getLogger().info("The user selects the Order range");
	}

	@Then("the user prints the first three products available")
	public void the_user_prints_the_first_three_products_available() throws InterruptedException, IOException {
	    
		Thread.sleep(3000);
		BS.printProductInfo();
		BaseClass.getLogger().info("The user prints the details of first Three products");
	}

	@When("the user moves to Living Sub Menu")
	public void the_user_moves_to_living_sub_menu() {
	    
		LV = new Living(BaseClass.getDriver());
		LV.scrollUp();
		LV.moveToLiving();
		BaseClass.getLogger().info("The user moves to Living sub Menu");
		
	}

	@Then("the user prints all the options available in Living")
	public void the_user_prints_all_the_options_available_in_living() throws IOException {
	    
		LV.printSeatingChairs();
		LV.printTables();
		LV.printLivingStorage();
		BaseClass.getLogger().info("The user prints the options available in Living menu");
		
	}
	
	@Then("the user scrolls up and clicks on the Gift Card options")
	public void the_user_scrolls_up_and_clicks_on_the_gift_card_options() {
	    
		LV.clickGiftCards();
		BaseClass.getLogger().info("The user selects the GiftCard option");
	}
	@Given("the user is navigated to Gift Card page")
	public void the_user_is_navigated_to_gift_card_page() {
	    
		GC = new GiftCards(BaseClass.getDriver());
		GC.scrollToBirthday();
		BaseClass.getLogger().info("The user scrolls to Birthday Gift card");
	}

	@Then("the user selects Birthday Gift Card")
	public void the_user_selects_birthday_gift_card() {
	    
		GC.clickBirthday();
		BaseClass.getLogger().info("The user chooses the Birthday Gift Card");
	}

	@Then("the user selects the Price")
	public void the_user_selects_the_price() {
	    
		GC.clickPrice();
		BaseClass.getLogger().info("The user selects the Price of the Gift Card");
	}

	@Then("the user selects the date")
	public void the_user_selects_the_date() {
	    
		GC.Customize();
		BaseClass.getLogger().info("The user selects the date of the Gift Card");
	}

	@Then("the user selects Next")
	public void the_user_selects_next() {
	    
		GC.clickNext();
		BaseClass.getLogger().info("The user selects on the Next option");
	}

	@Then("the user enters the details of To and From")
	public void the_user_enters_the_details_of_to_and_from(DataTable dataTable) {
	    
		Map<String,String> dataMap = dataTable.asMap(String.class,String.class);
		
		//To's details
		GC.EnterRecipientName(dataMap.get("rName"));
		GC.EnterRecipientEmail(dataMap.get("rEmail"));
		GC.EnterRecipientMobilenum(dataMap.get("rMobile"));
		
		BaseClass.getLogger().info("The user enters the details of To's details");
		
		//From's details
		GC.EnterSenderName(dataMap.get("sName"));
		GC.EnterSenderEmail(dataMap.get("sEmail"));
		GC.EnterSenderMobile(dataMap.get("sMobile"));
		GC.EnterSenderAddress(dataMap.get("sAddress"));
		GC.EnterSenderPincode(dataMap.get("sPincode"));
		
		BaseClass.getLogger().info("The user enters the details of From's details");
	}

	@Then("the user clicks on the Confirm details")
	public void the_user_clicks_on_the_confirm_details() throws InterruptedException {
	    
		Thread.sleep(3000);
		GC.clickConfirm();
		BaseClass.getLogger().info("The user validates the deatails and clicks on Confirm");
	}
}
