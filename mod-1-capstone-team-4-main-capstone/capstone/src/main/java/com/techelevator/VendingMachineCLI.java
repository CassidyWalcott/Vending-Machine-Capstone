package com.techelevator;

import com.techelevator.view.Menu;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	private static final String SUB_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String SUB_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String SUB_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] SUB_MENU_OPTIONS = {SUB_MENU_OPTION_FEED_MONEY, SUB_MENU_OPTION_SELECT_PRODUCT, SUB_MENU_OPTION_FINISH_TRANSACTION};
	private static final String FEED_MONEY_OPTION_ONE_DOLLAR = "1 dollar";
	private static final String FEED_MONEY_OPTION_TWO_DOLLARS = "2 dollars";
	private static final String FEED_MONEY_OPTION_FIVE_DOLLARS = "5 dollars";
	private static final String FEED_MONEY_OPTION_TEN_DOLLARS = "10 dollars";
	private static final String[] FEED_MONEY_OPTIONS = {FEED_MONEY_OPTION_ONE_DOLLAR,FEED_MONEY_OPTION_TWO_DOLLARS, FEED_MONEY_OPTION_FIVE_DOLLARS, FEED_MONEY_OPTION_TEN_DOLLARS};

	private static VendingMachine vmDisplay = null;
	private Menu menu;


	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				vmDisplay.displayItemsInStock();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while (true) {
					String purchaseChoice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
					if (purchaseChoice.equals(SUB_MENU_OPTION_FEED_MONEY)) {
						String feedMoneyOption = (String) menu.getChoiceFromOptions(FEED_MONEY_OPTIONS);
						if (feedMoneyOption.equals(FEED_MONEY_OPTION_ONE_DOLLAR)) {
							vmDisplay.feedMoney(1);
						} else if (feedMoneyOption.equals(FEED_MONEY_OPTION_TWO_DOLLARS)) {
							vmDisplay.feedMoney(2);
						} else if (feedMoneyOption.equals(FEED_MONEY_OPTION_FIVE_DOLLARS)) {
							vmDisplay.feedMoney(3);
						} else if (feedMoneyOption.equals(FEED_MONEY_OPTION_TEN_DOLLARS)) {
							vmDisplay.feedMoney(4);
						}


					} else if (purchaseChoice.equals(SUB_MENU_OPTION_SELECT_PRODUCT)) {
						vmDisplay.displayItemsInStock();
						System.out.println("Please select your item");
						Scanner selectItem = new Scanner(System.in);
						String userChoice = selectItem.nextLine();
						vmDisplay.purchase(userChoice);

					} else if (purchaseChoice.equals(SUB_MENU_OPTION_FINISH_TRANSACTION)) {
						vmDisplay.endTransaction();
						System.exit(1);
					}


				}
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		vmDisplay = new VendingMachine(new Inventory().fileInventory());
		cli.run();
	}
}
