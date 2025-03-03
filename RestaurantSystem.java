package java2;
import java.util.Scanner;
public class RestaurantSystem {

	public static void main(String[] args) {

		Scanner input=new Scanner(System.in);

		
System.out.print("Enter Customer ID: ");
String customerId = input.nextLine();
System.out.print("Enter Customer Name: ");
String customerName = input.nextLine();
Customer customer = new Customer(customerId, customerName, 10); // Max 10 orders

while (true) {
	System.out.println("\nMain Menu:");
    System.out.println("1. New Order");
    System.out.println("2. Cancel Order");
System.out.println("3. View previous requests");
    System.out.println("4. Exit");
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
            case 2:
            	System.out.println("\nDrink Options:");
                System.out.println("1. Soft Drink");
                System.out.println("2. Fresh Juice");
                System.out.print("Choose an option: ");
                int drinkChoice = input.nextInt();
                MenuItem drink = null;
                if (drinkChoice == 1) {
                	System.out.println("1. 7UP");
                    System.out.println("2. Pepsi");
                    System.out.println("3. Diet Pepsi");
                    System.out.println("4. Mountain Dew");
                    System.out.print("Your choice: ");
                    String sodaChoice = input.next();
                    System.out.print("Enter size (1: Small, 2: Medium, 3: Large): ");
                    String size = input.next();
                    double price = (size.equals("1")) ? 5 : (size.equals("2")) ? 7 : 10;
                     drink = new softDrinks(200,"Soft Drink", price,size,sodaChoice);
                    order.addItem(drink);

                } else if (drinkChoice == 2) {
                	System.out.println("1. Orange Juice");
                    System.out.println("2. Mango Juice");
                    System.out.println("3. Strawberry Juice");
                    System.out.print("Your choice: ");
                    String juiceChoice = input.next();
                    System.out.print("Enter size (1: Small, 2: Medium, 3: Large): ");
                    String size = input.next();
                    double price = (size.equals("1")) ? 7 : (size.equals("2")) ? 10 : 13;
                    MenuItem juice = new Juices(150,"Natural Juice", price,size,juiceChoice);
                    order.addItem(juice);
                }
                break;
		case 3:
            	System.out.println("\nAvailable Ice Cream: Vanilla, Chocolate, Strawberry - 12 SAR");
            	String IceCream=input.next();
            	DessertItem sweetItem = new DessertItem(350,"Ice Cream", 12,IceCream);
            	break;
	        case 4:
            	System.out.println("\nValue Meals:");
                System.out.println("1. Beef Burger Meal - 22 SAR");
                System.out.println("2. Chicken Burger Meal - 20 SAR");
                System.out.println("3. Cheese Burger Meal - 18 SAR");
                System.out.print("Choose a meal: ");
                int mealChoice = input.nextInt();



		break;
		case 5:
            	 ordering = false;
                 break;	    
            }//switch (orderChoice)
            
    	}//while(ordering )
	  customer.placeOrder(order);
        System.out.println("\nOrder Completed. Here is your receipt:");
       order.displayOrder();
	    
    }//if(choice==1)
	 else if (choice == 2) {
        System.out.println("Order Canceled.");
        order.clearOrder();
   else if(choice==3){
	System.out.println(customer.toString());
   }
	else if (choice == 3) {
        System.out.println("Exiting Program. Goodbye!");
        break;
}//while (true)
input.close();

	}

}
