import java.util.ArrayList;
import java.util.Scanner;

public class FlowerShopArrayList {
    private static ArrayList<Flower> flowerList = new ArrayList<>();

    private static class Flower {
        private String flowerName;
        private double price;
        private int quantity;

        // constructor for flower
        public Flower(String flowerName, double price, int quantity) {
            this.flowerName = flowerName;
            this.price = price;
            this.quantity = quantity;
        }

        // getters and setters for Flower atttributes
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

    // method to display the system menu
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

    // method to Input new flower data to the System
    public static void inputFlower(String flowerName, double price, int quantity) {
        Flower flower = new Flower(flowerName, price, quantity);
        flowerList.add(flower);
        }

    // method to view the flower list
    public static void viewFlowerList() {
        System.out.println("Flower Table");
        String columns[] = {"Name", "Price", "Quantity"};
        int size[] = {18, 18, 18};
        utility.Table table = new utility.Table(3, columns, size);

        table.printTop();

        flowerList.forEach(flower -> {
            String row[] = {
                    flower.getFlowerName(),
                    String.valueOf(flower.getPrice()),
                    String.valueOf(flower.getQuantity())
            };

            table.printRows(row);
        });
    }

    // method to view the details of a specific flower
    public static void viewFlowerDetails(String flowerName) {
        boolean flowerFound = false;

        for (Flower flower : flowerList) {
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

    // method to update the details of a specific flower
    public static void updateFlowerDetails(String flowerName, double newPrice, int newQuantity) {
        Flower foundFlower = null;
        for (Flower flower : flowerList) {
            if (flower.getFlowerName().equalsIgnoreCase(flowerName)) {
                foundFlower = flower;
                break;
            }
        }

        if (foundFlower == null) {
            System.out.println("Flower not found: " + flowerName);
        } else {
            // update the flower's price if a valid new price is provided
            if (newPrice > 0) {
                foundFlower.setPrice(newPrice);
            }
            // update the flower's quantity if a valid new quantity is provided
            if (newQuantity >= 0) {
                foundFlower.setQuantity(newQuantity);
            }
        }
    }

    // method to remove a flower from the list
    public static void removeFlower(String flowerName) {
        for (int i = flowerList.size() - 1; i >= 0; i--) {
            Flower flower = flowerList.get(i);
            if (flower.getFlowerName().equals(flowerName)) {
                flowerList.remove(i);
                return;
            }
        }
        System.out.println("Flower not found in the system.");
    }

    // method to search for a flower by name
    public static void searchFlowerByName(String searchFlower) {
        boolean flowerFound = false;

        for (Flower flower : flowerList) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int command = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (command) {
                case 1:
                    // input flower
                    System.out.println("\nMenu: Input Flower\n");
                    System.out.print("Enter the flower name: ");
                    String flowerName = scanner.nextLine();
                    System.out.print("Enter the flower price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter the flower quantity: ");
                    int quantity = scanner.nextInt();
                    inputFlower(flowerName, price, quantity);
                    break;

                case 2:
                    // view flower
                    System.out.println("\nMenu: View Flower List\n");
                    viewFlowerList();
                    break;

                case 3:
                    // view flower details
                    System.out.println("\nMenu: View Flower Details\n");
                    System.out.print("Enter the flower name: ");
                    String flowerNameDetails = scanner.nextLine();
                    viewFlowerDetails(flowerNameDetails);
                    break;

                case 4:
                    // update flower details
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

                case 5:
                    // remove flower
                    System.out.println("\nMenu: Remove Flower\n");
                    System.out.print("Enter the flower name to remove: ");
                    String flowerToRemove = scanner.nextLine();
                    removeFlower(flowerToRemove);
                    break;

                case 6:
                    // search the flower
                    System.out.println("\nMenu: Search Flower\n");
                    System.out.print("Enter the flower name to search: ");
                    String flowerToSearch = scanner.nextLine();
                    searchFlowerByName(flowerToSearch);
                    break;

                case 7:
                    // quit
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
