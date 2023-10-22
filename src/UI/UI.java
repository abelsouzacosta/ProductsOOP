package UI;

import domain.exceptions.ArrayListFullException;
import domain.services.ProductService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UI {
    private final ProductService service;

    private UI(ProductService instance) {
        this.service = instance;
    }
    public static void bootstrap() throws ArrayListFullException, ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Registering Products\n\n\n");
        System.out.println("Please, enter the amount of items that you want to register: ");
        int max = scanner.nextInt();
        ProductService instance = ProductService.getInstance(max);
        UI ui = new UI(instance);

        for (int counter = 0; counter < max; counter += 1) {
            System.out.println("Which type is of the item " + (counter + 1) + "[i/u]: ");
            char response = scanner.next().charAt(0);
            if (String.valueOf(response).equals("i")) {
                ui.createImportedProduct();
            } else {
                ui.createUsedProduct();
            }
        }

        System.out.println("Listing all instances");
        ui.listAllProducts();
    }

    public void createImportedProduct() throws ArrayListFullException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the price of the product: ");
        double price = scanner.nextDouble();
        System.out.println("Enter the custom fee: ");
        double customsFee = scanner.nextDouble();
        this.service.create(name, price, customsFee);
    }

    public void createUsedProduct() throws ParseException, ArrayListFullException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the price of the product: ");
        double price = scanner.nextDouble();
        System.out.println("Enter the manufacture date (dd/MM/yyyy format): ");
        String dateString = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date manufactureDate = dateFormat.parse(dateString);
        this.service.create(name,
                price,
                manufactureDate);
    }

    public void listAllProducts() {
        this.service.list();
    }
}
