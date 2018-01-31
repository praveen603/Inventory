package inventory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class InventoryList {
	private float profit;
	private float total_value;
	Set<Inventory> set;
	
	InventoryList(){
		this.profit = 0;
		this.total_value = 0;
		set = new HashSet<Inventory>();
	}
	
	Inventory getItem(String itemName) {
	
		for (Iterator<Inventory> it = set.iterator(); it.hasNext(); ) {
			   Inventory i = it.next();
			   if (i.nameOfInventory.equals(itemName))
			        return i;
		}
		
		return null;
	}
	
	
	void resetValues() {
		this.profit = 0;
	}
	
	void create(Inventory inv) {
		if(!set.contains(inv)){
			set.add(inv);
		}
	}
	void delete(Inventory inv) {
		if(set.contains(inv)) {
			
			this.profit = this.profit - (inv.costPrice * inv.totalItems);
			this.total_value = this.total_value - (inv.costPrice * inv.totalItems);
			set.remove(inv);
		}	
	}
	void updateBuy(Inventory inv,int buyItems) {
		
		inv.totalItems = inv.totalItems + buyItems;
		this.total_value = this.total_value + (inv.costPrice * buyItems );
	}
	void updateSell(Inventory inv,int soldItems) {
		
		inv.totalItems = inv.totalItems - soldItems;
		this.total_value = this.total_value - (inv.costPrice * soldItems);
		this.profit = this.profit + ((inv.sellPrice - inv.costPrice) * soldItems);
	}
	float calculateValue(Inventory inv) {
		return inv.totalItems * inv.costPrice;
	}
	void report() {
		ArrayList<Inventory> tmp = new ArrayList<Inventory>();
		tmp.addAll(set);
		Collections.sort(tmp, new Comparator<Inventory>(){
			   public int compare(Inventory o1, Inventory o2){
			      return o1.nameOfInventory.compareTo(o2.nameOfInventory) ;
			   }
		});
		System.out.println("\t\tINVENTORY REPORT");
		System.out.println("Item name\t\tBought at\t\tSold at\t\tAvailable Qty\t\tValue");
		System.out.println("---------\t\t---------\t\t---------\t-----------------\t---------");
		for (Iterator<Inventory> it = tmp.iterator(); it.hasNext(); ) {
	        Inventory i = it.next();
	        System.out.println(i.nameOfInventory + "\t\t\t" + i.costPrice + "\t\t\t" + i.sellPrice + "\t\t\t" + i.totalItems + "\t\t\t" + calculateValue(i) );
		}
		System.out.println("Total Value" + "\t\t\t\t\t\t\t\t\t\t" + this.total_value);
		System.out.println("Profit since previous report" + "\t\t\t\t\t\t\t\t" + this.profit);
		
		this.resetValues();
	}
}
