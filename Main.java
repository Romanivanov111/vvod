import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static String[] products = {"Хлеб", "Яблоки", "Молоко"};
    static int[] prices = {100, 200, 300};

    static File saveFile = new File("basket.txt");

    public static void main(String[] args) throws FileNotFoundException {

        Basket basket = null;
        if (saveFile.exists()) {
            basket = Basket.loadFromTxtFile(saveFile);
        } else {
            basket = new Basket(products, prices);
        }

    //    int[] sum = {0, 0, 0};
    //    System.out.println("Список возможных товаров для покупки:");
    //    for (int i = 0; i < products.length; i++) {
    //        System.out.println(products[i] + " " + prices[i] + " руб/шт");
    //    }
    //    int[] productCnt = new int[3];
    //    int sumProducts = 0;
        while (true) {
            showPrice();
            System.out.println("Выберите товар и его количество через пробел или введите end");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;

                    }
            String[] parts = input.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1;
            int productCount = Integer.parseInt(parts[1]);
            int currentPrice = prices[productNumber];
            basket.addToCart(productNumber, productCount);
            basket.saveTxt(saveFile);
                }
        basket.printCart();

            }

            public static void showPrice() {
                System.out.println("Список возможных товаров для покупки:");
                for (int i = 0; i < products.length; i++) {
                    System.out.println(products[i] + " " + prices[i] + " руб/шт");
                }
            }

  //  private String input;
  //  String[] parts = input.split(" ");
    //        int productNumber = Integer.parseInt(parts[0]) - 1;
    //        int productCount = Integer.parseInt(parts[1]);
    //        int currentPrice = prices[productNumber];
    //        sumProducts += productCount * currentPrice;
    //        productCnt[productNumber] += currentPrice * productCount;
    //        sum[productNumber] = productCount * prices[productNumber];
    //        basket.addToCart(productNumber, productCount);
    //        Basket.printCart();
        }
