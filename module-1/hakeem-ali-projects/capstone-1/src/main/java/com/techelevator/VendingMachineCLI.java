package com.techelevator;

import com.techelevator.sale.FeedMoney;
import com.techelevator.sale.FinishSale;
import com.techelevator.sale.Purchase;
import com.techelevator.view.Menu;
import com.techelevator.view.PurchaseMenu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private static final String FEED_ONE_DOLLAR = "Insert $1";
	private static final String FEED_TWO_DOLLARS = "Insert $2";
	private static final String FEED_FIVE_DOLLARS = "Insert $5";
	private static final String FEED_TEN_DOLLARS = "Insert $10";
	private static final String[] FEED_DOLLAR_OPTIONS = {FEED_ONE_DOLLAR, FEED_TWO_DOLLARS, FEED_FIVE_DOLLARS, FEED_TEN_DOLLARS};

	private final Menu menu;
	private final Purchase purchase;
	private final PurchaseMenu purchaseMenu;
	private final FeedMoney feedMoney;

	public VendingMachineCLI(Menu menu, PurchaseMenu purchaseMenu, FeedMoney feedMoney, Purchase purchase) {
		this.menu = menu;
		this.purchase = purchase;
		this.purchaseMenu = purchaseMenu;
		this.feedMoney = feedMoney;
	}

	public void run() {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.createVendingMachine();
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			switch (choice) {
				case MAIN_MENU_OPTION_DISPLAY_ITEMS:
					// display vending machine items
					vendingMachine.displayProducts();
					break;
				case MAIN_MENU_OPTION_PURCHASE:

					boolean isDone = false;
					while (!isDone) {

						// do purchase
						choice = (String) purchaseMenu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
						switch (choice) {
							case PURCHASE_MENU_OPTION_FEED_MONEY:

								choice = (String) feedMoney.getChoiceFromOptions(FEED_DOLLAR_OPTIONS);
								switch (choice) {
									case FEED_ONE_DOLLAR:
									case FEED_TWO_DOLLARS:
									case FEED_FIVE_DOLLARS:
									case FEED_TEN_DOLLARS:
										feedMoney.feedMoney(choice);
										break;
								}
								break;
							case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
								//VendingMachine class display products
								vendingMachine.displayProducts();
								purchase.selectProduct(vendingMachine, feedMoney);
								break;
							case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:
								FinishSale finish = new FinishSale(System.in, System.out);
								finish.calculateChange(purchase);
								isDone = true;
								break;
						}
					}
					break;
				case MAIN_MENU_OPTION_EXIT:
					System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		PurchaseMenu purchaseMenu = new PurchaseMenu(System.in, System.out);
		FeedMoney feedMoney = new FeedMoney(System.in, System.out);
		Purchase purchase = new Purchase(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu, purchaseMenu, feedMoney, purchase);
		cli.run();
	}
}
