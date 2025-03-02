package java2;
import java.util.Scanner;
public class RestaurantSystem {

	public static void main(String[] args) {

		Scanner input=new Scanner(system.in);

		
System.out.print("Enter Customer ID: ");
String customerId = input.nextLine();
System.out.print("Enter Customer Name: ");
String customerName = input.nextLine();
Customer customer = new Customer(customerId, customerName, 10); // Max 10 orders

while (true) {
	System.out.println("\nMain Menu:");
    System.out.println("1. New Order");
    System.out.println("2. Cancel Order");
    System.out.println("3. Exit");
    System.out.print("Choose an option: ");
    
    int choice = input.nextInt();
    if(choice==1) {
        Order order = new Order();

    	boolean ordering = true;
    	while(ordering) {
    		System.out.println("\nOrder Menu:");
            System.out.println("1. Food Item");
            System.out.println("2. Drink Item");
            System.out.println("3. Sweet Item");
            System.out.println("4. Value Meals");
            System.out.println("5. Finish Order");
            System.out.print("Choose an option: ");
            
            int orderChoice = input.nextInt();
            input.nextLine(); 
            
            switch (orderChoice) {
            case 1:System.out.println("\nAvailable Burgers:");
            System.out.println("1. Double Beef Burger - 20 SAR");
            System.out.println("2. Double Chicken Burger - 18 SAR");
            System.out.println("3. Cheese Burger - 15 SAR");
            System.out.print("Choose a burger: ");
            int burgerChoice = input.nextInt();
            input.nextLine();
            MenuItem burger = null;
            if (burgerChoice == 1) burger = new FoodItem(850,"Double Beef Burger", 20);
            else if (burgerChoice == 2) burger = new FoodItem(750,"Double Chicken Burger", 18);
            else if (burgerChoice == 3) burger = new FoodItem(600,"Cheese Burger", 15);
            
            if (burger != null) {
            	System.out.print("Do you want to add extra ingredients? y/n): ");
                char addExtras = input.next().charAt(0);
                if(addExtras=='y') {
                	System.out.println("Available Extras: Cheese, Mayo, Lettuce, Special Sauce");
                    System.out.print("Enter extra ingredient: ");
                    String extra = input.nextLine();
                  ((FoodItem) burger).addIngredient(new Ingredient(extra));
                    input.nextLine();
                }
                order.addItem(burger);

            }
            break;
            
            }//switch (orderChoice)
            
    	}//while(ordering )
    }//if(choice==1)
    	
}//while (true)


	}

}
