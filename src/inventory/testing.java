package inventory;


import java.util.Scanner;

public class testing {

	public static void main(String[] args) {
		InventoryList iL = new InventoryList();
		
		Scanner scanner = new Scanner( System.in );
		
		while(scanner.hasNext()){
			String input = scanner.nextLine();
			String[] parts = input.split(" ");
			
			if(parts[0].equals("create") && parts.length == 4) {
				
				Inventory inv = new Inventory(parts[1],Float.parseFloat(parts[2]),Float.parseFloat(parts[3]));
				iL.create(inv);
			}
			else if(parts[0].equals("delete") && parts.length == 2) {
				Inventory temp = iL.getItem(parts[1]);
				iL.delete(temp);
			}
			else if(parts[0].equals("updateBuy") && parts.length == 3) {
				Inventory temp = iL.getItem(parts[1]);
				iL.updateBuy(temp,Integer.parseInt(parts[2]));
			}
			else if(parts[0].equals("updateSell") && parts.length == 3) {
				Inventory temp = iL.getItem(parts[1]);
				iL.updateSell(temp,Integer.parseInt(parts[2]));
			}
			else if(parts[0].equals("report")) {
				iL.report();
			}
		}
		scanner.close();

	}

}
