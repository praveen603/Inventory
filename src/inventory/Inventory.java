package inventory;

public class Inventory {
	String nameOfInventory;
	float costPrice;
	float sellPrice;
	int totalItems;
	Inventory(String name,float cP,float sP){
		this.nameOfInventory = name;
		this.costPrice = cP;
		this.sellPrice = sP;
		this.totalItems = 0;
	}
	void updateItems(int noOfItems){
		this.totalItems = noOfItems;
	}
	
}
