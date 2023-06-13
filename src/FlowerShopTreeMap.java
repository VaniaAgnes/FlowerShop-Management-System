import java.util.Scanner;
import java.util.TreeMap;

public class FlowerShopTreeMap {
    private static TreeMap<String, Flower> flowerMap = new TreeMap<>();

    private static class Flower {
        private String flowerName;
        private double price;
        private int quantity;

        public Flower(String flowerName, double price, int quantity) {
            this.flowerName = flowerName;
            this.price = price;
            this.quantity = quantity;
        }

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

    public static void displayMenu() {
        System.out.println(" ");
        System.out.println("\n=============================");
        System.out.println("Flower Shop Management System");
        System.out.println("=============================");
        System.out.println("Welcome to our Flower Shop !");
        System.out.println("1. Input New Flower");
        System.out.println("2. View Flower List");
        System.out.println("3. View Flower Details");
        System.out.println("4. Update Flower Details");
        System.out.println("5. Remove Flower");
        System.out.println("6. Search the Flower");
        System.out.println("7. Quit");
        System.out.println("=============================");
        System.out.print("Choose the function: ");
    }

    public static void inputFlower(String flowerName, double price, int quantity) {
        Flower flower = new Flower(flowerName, price, quantity);
        flowerMap.put(flowerName, flower);
    }

    public static void viewFlowerList() {
        System.out.println("Flower Table");
        String columns[] = {"Name", "Price", "Quantity"};
        int size[] = {18, 18, 18};
        utility.Table table = new utility.Table(3, columns, size);

        table.printHeader();

        flowerMap.forEach((flowerName, flower) -> {
            String row[] = {
                    flower.getFlowerName(),
                    String.valueOf(flower.getPrice()),
                    String.valueOf(flower.getQuantity())
            };

            table.printRows(row);
        });
    }

    public static void viewFlowerDetails(String flowerName) {
        Flower flower = flowerMap.get(flowerName);

        if (flower != null) {
            System.out.println("Flower Details:");
            System.out.println("Name: " + flower.getFlowerName());
            System.out.println("Price: $" + flower.getPrice());
            System.out.println("Quantity: " + flower.getQuantity());
        } else {
            System.out.println("Flower not found: " + flowerName);
        }
    }

    public static void updateFlowerDetails(String flowerName, double newPrice, int newQuantity) {
        Flower flower = flowerMap.get(flowerName);

        if (flower != null) {

            if (newPrice > 0) {
                flower.setPrice(newPrice);
            }

            if (newQuantity >= 0) {
                flower.setQuantity(newQuantity);
            }
        } else {
            System.out.println("Flower not found: " + flowerName);
        }
    }

    public static void removeFlower(String flowerName) {
        Flower flower = flowerMap.remove(flowerName);

        if (flower != null) {
        } else {
            System.out.println("Flower not found in the system.");
        }
    }

    public static void searchFlowerByName(String searchFlower) {
        Flower flower = flowerMap.get(searchFlower);

        if (flower != null) {
            System.out.println("Flower found:");
            System.out.println("Name: " + flower.getFlowerName());
            System.out.println("Price: $" + flower.getPrice());
            System.out.println("Quantity: " + flower.getQuantity());
        } else {
            System.out.println("Flower not found: " + searchFlower);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int command = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (command) {
                case 1:
                    System.out.println("\nMenu: Input Flower\n");
                    System.out.print("Enter the flower name: ");
                    String flowerName = scanner.nextLine();
                    System.out.print("Enter the flower price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter the flower quantity: ");
                    int quantity = scanner.nextInt();
                    inputFlower(flowerName, price, quantity);
                    System.out.println("\nYour Flower Has Been Successfully Added !");
                    break;

                case 2:
                    System.out.println("\nMenu: View Flower List\n");
                    viewFlowerList();
                    break;

                case 3:
                    System.out.println("\nMenu: View Flower Details\n");
                    System.out.print("Enter the flower name: ");
                    String flowerNameDetails = scanner.nextLine();
                    viewFlowerDetails(flowerNameDetails);
                    break;

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
                    System.out.println("\nFlower details updated successfully.");
                    break;

                case 5:
                    System.out.println("\nMenu: Remove Flower\n");
                    System.out.print("Enter the flower name to remove: ");
                    String flowerToRemove = scanner.nextLine();
                    removeFlower(flowerToRemove);
                    System.out.println("Successfully removed flower from the system.");
                    break;

                case 6:
                    System.out.println("\nMenu: Search Flower\n");
                    System.out.print("Enter the flower name to search: ");
                    String flowerToSearch = scanner.nextLine();
                    searchFlowerByName(flowerToSearch);
                    break;

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
