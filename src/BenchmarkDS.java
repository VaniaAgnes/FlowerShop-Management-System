import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class BenchmarkDS {

    // display the menu
    public static void displayMenu() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║        Flower Shop Benchmark          ║");
        System.out.println("║              System Menu              ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║       Welcome to our Flower Shop!     ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║ 1. 🌸 Input New Flower                ║");
        System.out.println("║ 2. 🌷 Update Flower Details           ║");
        System.out.println("║ 3. 🌻 Remove Flower                   ║");
        System.out.println("║ 4. 🌹 Search the Flower               ║");
        System.out.println("║ 5. ❌ Quit                            ║");
        System.out.println("╚═══════════════════════════════════════╝");
        System.out.print("\nPlease choose an option: ");
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // declaring variables for benchmarking
        long arrayStart, arrayEnd, stackStart, stackEnd, tmStart, tmEnd, llStart, llEnd, queueStart, queueEnd;
        // var to store user input
        int x;
        // to read flower data from a file
        flowerRead();
        // setting the capacity for data structures based on the number of flowers read
        int cap = Math.min(flowerCount, 500);

        // create an instance of flowerShopArrayList and adding flowers to the Array list
        FlowerShopArrayList arrayList = new FlowerShopArrayList();
        for (int i = 0; i < cap; i++) {
            arrayList.inputFlower(flowerName[i], price[i], quantity[i]);
        }

        // create an instance of flowerShopTreeMap and adding flowers to the Tree Map
        FlowerShopTreeMap tm = new FlowerShopTreeMap();
        for (int i = 0; i < cap; i++) {
            tm.inputFlower(flowerName[i], price[i], quantity[i]);
        }

        // create an instance of flowerShopLinkedList and adding flowers to the Linked List
        FlowerShopLinkedList ll = new FlowerShopLinkedList();
        for (int i = 0; i < cap; i++) {
            ll.inputFlower(flowerName[i], price[i], quantity[i]);
        }

        // create an instance of flowerShopStack and adding flowers to the Stack
        FlowerShopStack stack = new FlowerShopStack();
        for (int i = 0; i < cap; i++) {
            stack.inputFlower(flowerName[i], price[i], quantity[i]);
        }

        // create an instance of flowerShopQueue and adding flowers to the Queue
        FlowerShopStack queue = new FlowerShopStack();
        for (int i = 0; i < cap; i++) {
            queue.inputFlower(flowerName[i], price[i], quantity[i]);
        }

        boolean exit = false;
        while (exit == false) {
            displayMenu(); // to display menu
            String choice = input.nextLine();


            switch (choice) {
                // finding the benchmark for the different data structure's for the input flowers
                case "1":
                    Scanner inputRead = new Scanner(System.in);
                    System.out.println("\nThe Result of the Benchmark for different data structure: ");
                    System.out.print("Enter the number of flowers (x) in the benchmark: ");
                    x = inputRead.nextInt();

                    // Array List (Input Flower BenchMark)
                    System.out.println("\nArray List");
                    System.out.println("============");
                    arrayStart = System.nanoTime();

                    for (int i = 0; i < x && x <= flowerCount; i++) {
                        arrayList.inputFlower(flowerName[i], price[i], quantity[i]);
                    }

                    arrayEnd = System.nanoTime();
                    get_Time(arrayStart, arrayEnd);

                    // Stack (Input Flower Benchmark)
                    System.out.println("\nStack");
                    System.out.println("============");
                    stackStart = System.nanoTime();

                    for (int j = 0; j < x && x <= flowerCount; j++) {
                        stack.inputFlower(flowerName[j], price[j], quantity[j]);
                    }

                    stackEnd = System.nanoTime();
                    get_Time(stackStart, stackEnd);

                    // Tree Map (Input Flower Benchmark)
                    System.out.println("\nTree Map ");
                    System.out.println("============");
                    tmStart = System.nanoTime();

                    for (int j = 0; j < x && x <= flowerCount; j++) {
                        tm.inputFlower(flowerName[j], price[j], quantity[j]);
                    }

                    tmEnd = System.nanoTime();
                    get_Time(tmStart, tmEnd);

                    // Linked List (Input Flower Benchmark)
                    System.out.println("\nLinked List ");
                    System.out.println("============");
                    llStart = System.nanoTime();

                    for (int j = 0; j < x && x <= flowerCount; j++) {
                        ll.inputFlower(flowerName[j], price[j], quantity[j]);
                    }

                    llEnd = System.nanoTime();
                    get_Time(llStart, llEnd);

                    // Queue (Input Flower BenchMark)
                    System.out.println("\nQueue ");
                    System.out.println("============");
                    queueStart = System.nanoTime();

                    for (int j = 0; j < x && x <= flowerCount; j++) {
                        queue.inputFlower(flowerName[j], price[j], quantity[j]);
                    }

                    queueEnd = System.nanoTime();
                    get_Time(queueStart, queueEnd);


                    break;

                // finding the benchmark for the different data structure's for the update flowers
                case "2":
                    Scanner updateRead = new Scanner(System.in);
                    System.out.println("\nThe Result of the Benchmark for different data structure: ");
                    System.out.print("Enter the number of flowers (x) in the benchmark: ");
                    x = updateRead.nextInt();

                    // ArrayList
                    System.out.println("\nArray List");
                    System.out.println("============");

                    arrayStart = System.nanoTime();
                    for (int i = 0; i < x && x <= flowerCount; i++) {
                        arrayList.updateFlowerDetails("Rose", 98, 7);
                    }
                    arrayEnd = System.nanoTime();
                    get_Time(arrayStart, arrayEnd);

                    // Stack
                    System.out.println("\nStack");
                    System.out.println("============");

                    stackStart = System.nanoTime();
                    for (int i = 0; i < x && x <= flowerCount; i++) {
                        stack.updateFlowerDetails("Rose", 98, 7);
                    }
                    stackEnd = System.nanoTime();
                    get_Time(stackStart, stackEnd);

                    // TreeMap
                    System.out.println("\nTreeMap");
                    System.out.println("============");
                    tmStart = System.nanoTime();
                    for (int i = 0; i < x && x <= flowerCount; i++) {
                        tm.updateFlowerDetails("Rose", 98, 7);

                    }
                    tmEnd = System.nanoTime();
                    get_Time(tmStart, tmEnd);

                    // Linked List
                    System.out.println("\nLinked List");
                    System.out.println("============");
                    llStart = System.nanoTime();
                    for (int i = 0; i < x && x <= flowerCount; i++) {
                        ll.updateFlowerDetails("Rose", 98, 7);
                    }
                    llEnd = System.nanoTime();
                    get_Time(llStart, llEnd);

                    // Queue
                    System.out.println("\nQueue");
                    System.out.println("============");
                    queueStart = System.nanoTime();
                    for (int i = 0; i < x && x <= flowerCount; i++) {
                        queue.updateFlowerDetails("Rose", 98, 7);
                    }
                    queueEnd = System.nanoTime();
                    get_Time(queueStart, queueEnd);

                    break;

                // finding the benchmark for the different data structure's for the remove flowers
                case "3":
                    Scanner removeRead = new Scanner(System.in);
                    System.out.println("\nThe Result of the Benchmark for different data structure: ");
                    System.out.print("Enter the number of flowers (x) in the benchmark: ");
                    x = removeRead.nextInt();

                    // Array List (Remove Flower BenchMark)
                    System.out.println("\nArray List");
                    System.out.println("============");
                    arrayStart = System.nanoTime();

                    for (int i = 0; i < x && x <= flowerCount; i++) {
                        arrayList.removeFlower(flowerName[i]);
                    }

                    arrayEnd = System.nanoTime();
                    get_Time(arrayStart, arrayEnd);

                    // Stack (Remove Flower BenchMark)
                    System.out.println("\nStack");
                    System.out.println("============");
                    stackStart = System.nanoTime();

                    for (int i = 0; i < x && x <= flowerCount; i++) {
                        stack.removeFlower(flowerName[i]);
                    }

                    stackEnd = System.nanoTime();
                    get_Time(stackStart, stackEnd);

                    // Tree Map (Remove Flower BenchMark)
                    System.out.println("\nTreeMap");
                    System.out.println("============");
                    tmStart = System.nanoTime();

                    for (int i = 0; i < x && x <= flowerCount; i++) {
                        tm.removeFlower(flowerName[i]);
                    }

                    tmEnd = System.nanoTime();
                    get_Time(tmStart, tmEnd);

                    // Linked List (Remove Flower BenchMark)
                    System.out.println("\nLinked List");
                    System.out.println("============");
                    llStart = System.nanoTime();

                    for (int i = 0; i < x && x <= flowerCount; i++) {
                        ll.removeFlower(flowerName[i]);
                    }

                    llEnd = System.nanoTime();
                    get_Time(llStart, llEnd);

                    // Queue (Remove Flower BenchMark)
                    System.out.println("\nQueue");
                    System.out.println("============");
                    queueStart = System.nanoTime();

                    for (int i = 0; i < x && x <= flowerCount; i++) {
                        queue.removeFlower(flowerName[i]);
                    }

                    queueEnd = System.nanoTime();
                    get_Time(queueStart, queueEnd);

                    break;

                // finding the benchmark for the different data structure's for the search flowers
                case "4":
                    System.out.println("\nThe Result of the Benchmark for different data structure: ");
                    //Array List (Search BenchMark)
                    System.out.println("\nArray List");
                    System.out.println("============");
                    arrayStart = System.nanoTime();
                    arrayList.searchFlowerByName("Rose");
                    arrayEnd = System.nanoTime();
                    get_Time(arrayStart, arrayEnd);

                    //Tree Map (Search BenchMark)
                    System.out.println("\nTree Map");
                    System.out.println("============");
                    tmStart = System.nanoTime();
                    tm.searchFlowerByName("Rose");
                    tmEnd = System.nanoTime();
                    get_Time(tmStart, tmEnd);

                    //Stack (Search BenchMark)
                    System.out.println("\nStack");
                    System.out.println("============");
                    stackStart = System.nanoTime();
                    stack.searchFlowerByName("Rose");
                    stackEnd = System.nanoTime();
                    get_Time(stackStart, stackEnd);

                    //Linked List (Search BenchMark)
                    System.out.println("\nLinked List");
                    System.out.println("============");
                    llStart = System.nanoTime();
                    ll.searchFlowerByName("Rose");
                    llEnd = System.nanoTime();
                    get_Time(llStart, llEnd);

                    //Queue (Search BenchMark)
                    System.out.println("\nQueue");
                    System.out.println("============");
                    queueStart = System.nanoTime();
                    queue.searchFlowerByName("Rose");
                    queueEnd = System.nanoTime();
                    get_Time(queueStart, queueEnd);
                    break;

                case "5" :
                    System.out.println("Closing the System ... ");
                    System.exit(0);


            }

        }

    }

    // initialize variable to 0
    private static int flowerCount = 0;

    // creating arrays with the size of 500
    static String[] flowerName = new String[500];
    static double[] price = new double[500];
    static int[] quantity = new int[500];

    // method to calculate and display benchmark time
     static void get_Time(long timeStart, long timeEnd) {
        double elapsedTime = (timeEnd - timeStart) / 1_000.0;  //convert from nanoseconds to milliseconds
        System.out.println("Benchmark time: " +elapsedTime + " ms");
    }

    // to read the .txt file in the system to get the data necessary for the program
    public static void flowerRead() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/FlowerData.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String name = parts[0];
                String fprice = parts[1];
                String fquantity = parts[2];
                flowerName[flowerCount] = name;
                price[flowerCount] = Double.parseDouble(fprice);
                quantity[flowerCount] = Integer.parseInt(fquantity);
                flowerCount++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }


}