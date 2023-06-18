import java.util.Scanner;
import java.util.Stack;

public class FlowerShopStack {
    private static Stack<Flower> flowerStack = new Stack<>();

    private static class Flower {
        private String flowerName;
        private double price;
        private int quantity;


        //initializing the object of this code
        public Flower(String flowerName, double price, int quantity) {
            this.flowerName = flowerName;
            this.price = price;
            this.quantity = quantity;
        }

        //getter and setter method
        public String getFlowerName() {
            return flowerName;
        }

        public void setFlowerName(String flowerName) {
            this.flowerName = flowerName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    // print the menu of the "Flower Shop Management"
    public static void displayMenu() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║        Flower Shop Management         ║");
        System.out.println("║              System Menu              ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║       Welcome to our Flower Shop!     ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║ 1. 🌸 Input New Flower                ║");
        System.out.println("║ 2. 🌼 View Flower List                ║");
        System.out.println("║ 3. 🌺 View Flower Details             ║");
        System.out.println("║ 4. 🌷 Update Flower Details           ║");
        System.out.println("║ 5. 🌻 Remove Flower                   ║");
        System.out.println("║ 6. 🌹 Search the Flower               ║");
        System.out.println("║ 7. ❌ Quit                            ║");
        System.out.println("╚═══════════════════════════════════════╝");
        System.out.print("\nPlease choose an option: ");
    }

    // method for the first feature "Input New Flower"
    public static void inputFlower(String flowerName, double price, int quantity) {
        Flower flower = new Flower(flowerName, price, quantity);
        flowerStack.push(flower);
    }

    // method for the second feature "View Flower List"
    public static void viewFlowerList() {
        System.out.println("Flower Table");
        String columns[] = {"Name", "Price", "Quantity"};
        int size[] = {18, 18, 18};
        utility.Table table = new utility.Table(3, columns, size);

        table.printTop();

        for (FlowerShopStack.Flower flower : flowerStack) {
            String row[] = {
                    flower.getFlowerName(),
                    String.valueOf(flower.getPrice()),
                    String.valueOf(flower.getQuantity())
            };

            table.printRows(row);
        }
    }

    // method for the third feature "View Flower Details"
    public static void viewFlowerDetails(String flowerName) {
        boolean flowerFound = false;

        for (Flower flower : flowerStack) {
            if (flower.getFlowerName().equalsIgnoreCase(flowerName)) {
                System.out.println("Flower Details:");
                System.out.println("Name: " + flower.getFlowerName());
                System.out.println("Price: $" + flower.getPrice());
                System.out.println("Quantity: " + flower.getQuantity());

                flowerFound = true;
                break;
            }
        }

        if (!flowerFound) {
            System.out.println("Flower not found: " + flowerName);
        }
    }

    // method for the fourth feature "Update Flower Details"
    public static void updateFlowerDetails(String flowerName, double newPrice, int newQuantity) {
        Flower foundFlower = null;
        for (Flower flower : flowerStack) {
            if (flower.getFlowerName().equalsIgnoreCase(flowerName)) {
                foundFlower = flower;
                break;
            }
        }

        if (foundFlower == null) {
            System.out.println("Flower not found: " + flowerName);
        } else {

            if (newPrice > 0) {
                foundFlower.setPrice(newPrice);
            }

            if (newQuantity >= 0) {
                foundFlower.setQuantity(newQuantity);
            }
        }
    }

    // method for the fifth feature "Remove Flower"
    public static void removeFlower(String flowerName) {
        boolean flowerRemoved = false;

        Stack<Flower> tempStack = new Stack<>();
        while (!flowerStack.isEmpty()) {
            Flower flower = flowerStack.pop();
            if (flower.getFlowerName().equalsIgnoreCase(flowerName)) {
                flowerRemoved = true;
                break;
            } else {
                tempStack.push(flower);
            }
        }

        while (!tempStack.isEmpty()) {
            flowerStack.push(tempStack.pop());
        }

        if (flowerRemoved) {
        } else {
            System.out.println("Flower not found in the system.");
        }
    }

    // method for the sixth feature "Search Flower"
    public static void searchFlowerByName(String searchFlower) {
        boolean flowerFound = false;

        for (Flower flower : flowerStack) {
            if (flower.getFlowerName().equalsIgnoreCase(searchFlower)) {
                System.out.println("Flower found:");
                System.out.println("Name: " + flower.getFlowerName());
                System.out.println("Price: $" + flower.getPrice());
                System.out.println("Quantity: " + flower.getQuantity());
                flowerFound = true;
                break;
            }
        }

        if (!flowerFound) {
            System.out.println("Flower not found: " + searchFlower);
        }
    }

    // the main code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int command = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (command) {
                // input flower
                case 1:
                    System.out.println("\nMenu: Input Flower\n");
                    System.out.print("Enter the flower name: ");
                    String flowerName = scanner.nextLine();
                    System.out.print("Enter the flower price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter the flower quantity: ");
                    int quantity = scanner.nextInt();
                    inputFlower(flowerName, price, quantity);
                    break;
                // view flower list
                case 2:
                    System.out.println("\nMenu: View Flower List\n");
                    viewFlowerList();
                    break;
                //view flower details by name
                case 3:
                    System.out.println("\nMenu: View Flower Details\n");
                    System.out.print("Enter the flower name: ");
                    String flowerNameDetails = scanner.nextLine();
                    viewFlowerDetails(flowerNameDetails);
                    break;
                //update flowers
                case 4:
                    System.out.println("\nMenu: Update Flower\n");
                    System.out.print("Enter the flower name: ");
                    String flowerToUpdate = scanner.nextLine();
                    System.out.print("Enter new price [Press ENTER to skip]: ");
                    String priceInput = scanner.nextLine();
                    double newPrice = (!priceInput.isEmpty()) ? Double.parseDouble(priceInput) : -1;
                    System.out.print("Enter new quantity [Press ENTER to skip]: ");
                    String quantityInput = scanner.nextLine();
                    int newQuantity = (!quantityInput.isEmpty()) ? Integer.parseInt(quantityInput) : -1;
                    updateFlowerDetails(flowerToUpdate, newPrice, newQuantity);
                    break;
                // remove flowers
                case 5:
                    System.out.println("\nMenu: Remove Flower\n");
                    System.out.print("Enter the flower name to remove: ");
                    String flowerToRemove = scanner.nextLine();
                    removeFlower(flowerToRemove);
                    break;
                // search flowers
                case 6:
                    System.out.println("\nMenu: Search Flower\n");
                    System.out.print("Enter the flower name to search: ");
                    String flowerToSearch = scanner.nextLine();
                    searchFlowerByName(flowerToSearch);
                    break;
                // exit
                case 7:
                    exit = true;
                    System.out.println("\nThank you for using the Flower Shop Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid command! Please try again.");
                    break;
            }
        }
    }
}

