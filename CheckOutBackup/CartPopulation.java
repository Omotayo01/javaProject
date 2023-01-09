package CheckOutBackup;

import java.util.ArrayList;
import java.util.Scanner;

public class CartPopulation {

    public String nameOfCustomer;
    private ArrayList<String> productBought;

    private ArrayList<Integer> numberOfPieces;

    private ArrayList<Double> price;

    public String nameOfCashier;

    private double discount;

    private final double VAT = 17.50;

    private double amountPaidByCustomer;


    Scanner collector = new Scanner(System.in);


    public void keepShopping() {


        System.out.println("What is the Customer's Name");
        nameOfCustomer = collector.nextLine();

        String stopShopping = "yes";

        productBought = new ArrayList<>();
        numberOfPieces = new ArrayList<>();
        price = new ArrayList<>();

        while (stopShopping.equalsIgnoreCase("yes")) {


            System.out.println("What did you buy? ");
            productBought.add(collector.next());

            System.out.println("How many pieces? ");
            numberOfPieces.add(Integer.parseInt(collector.next()));

            System.out.println("How much per unit? ");
            price.add(Double.parseDouble(collector.next()));

            System.out.println("add more Items? ");
            stopShopping = collector.next();
        }

        System.out.println("What is your name? ");
        nameOfCashier = collector.next();

        System.out.println("How much discount will he/she get? ");
        discount = Double.parseDouble(collector.next());

    }

    public ArrayList<Double> totalOfEachItem(){

        ArrayList<Integer> numberOfItemBought = getNumberOfPieces();

        ArrayList<Double> priceOfItemBought = getPrice();

        ArrayList<Double> totalPriceForEachItemWithNumberOfPiecesFactoredIn = new ArrayList<>();

        for (int eachItem = 0; eachItem < numberOfItemBought.size(); eachItem = eachItem +1){
            totalPriceForEachItemWithNumberOfPiecesFactoredIn.add(numberOfItemBought.get(eachItem)
                    * priceOfItemBought.get(eachItem));
        }
        return totalPriceForEachItemWithNumberOfPiecesFactoredIn;
    }

    public double subTotal(){
        totalOfEachItem();

        double subSumOfTotalOfAllItems = 0.0;

        for (double totalPriceForEachItemWithNumberOfPiecesFactoredIn : totalOfEachItem()){

            subSumOfTotalOfAllItems = subSumOfTotalOfAllItems + totalPriceForEachItemWithNumberOfPiecesFactoredIn;
        }

        return subSumOfTotalOfAllItems;
    }
    public ArrayList<String> getProductBought(){
        return productBought;
    }
    public ArrayList<Double> getPrice() {
        return price;
    }

    public ArrayList<Integer> getNumberOfPieces() {

        return numberOfPieces;
    }


    public double calculatedDiscount(){

    return ((discount/100)  * subTotal());
    }

    public double calculatedVAT(){
        return ((VAT/100) * subTotal());
    }

    public double totalBill(){

        return ((subTotal() - calculatedDiscount()) + calculatedVAT());
    }

    public void displayItemBoughtQuantityAndPriceOnTheReceipt(){

        for (int piecesPurchased = 0 ; piecesPurchased < numberOfPieces.size(); piecesPurchased = piecesPurchased + 1){
            System.out.printf("%9s%10d%12.2f%13.2f\n",getProductBought().get(piecesPurchased)
                    ,getNumberOfPieces().get(piecesPurchased),
                    getPrice().get(piecesPurchased),totalOfEachItem().get(piecesPurchased));
        }
    }

        public void displayFirstReceiptWithoutCalculatedChange(){

            System.out.println();
            System.out.println("SEMICOLON STORES\n" + "MAIN BRANCH\n"
                + "Location: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.\n" +
                "TEL: 03293828343\n" + "Date : 18-Dec-22 8:48:11 pm\n"
                + "Cashier: " + nameOfCashier + "\n" + "Customer Name: " + nameOfCustomer);
        System.out.print("===================================================\n");
        System.out.print("          " + "ITEM" + "   QTY" + "   PRICE" + "   TOTAL(NGN)\n");
        System.out.print("---------------------------------------------------\n");

        displayItemBoughtQuantityAndPriceOnTheReceipt();
        System.out.print("---------------------------------------------------\n");

            System.out.println("        " + "Sub Total:" + "             " + subTotal());
            System.out.println("        " + " Discount:" + "             " + calculatedDiscount());
            System.out.printf("%18s%19.2f\n","VAT @ 17.50%:",calculatedVAT());

            System.out.print("===================================================\n");

            System.out.println("       " + "Bill Total:" + "             " + totalBill());
            System.out.print("===================================================\n");
            System.out.print("THIS IS NOT A RECEIPT KINDLY PAY  " + totalBill() + "\n");
            System.out.print("===================================================\n");

            System.out.println("How much did the customer give you? ");
            amountPaidByCustomer = collector.nextDouble();
    }


    public double calculateBalanceIfThereIsAnyAfterCustomerPaidCash(){
        double balance = 0.0;
        if (amountPaidByCustomer < totalBill() ){
            System.out.print("===================================================\n");
            System.out.print("You have provided insufficient cash \n");
            System.out.print("your bill is " + totalBill() + "\n");
            System.out.print("Kindly provide the stated amount to have your carted goods\n");
            System.out.print("===================================================\n");

        }
        else
            balance = (amountPaidByCustomer - totalBill());

        return balance;
    }

    public void displayFinalReceiptAfterChangeHaveBeenCalculated(){

        System.out.println();
        System.out.println("SEMICOLON STORES\n" + "MAIN BRANCH\n"
                + "Location: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.\n" +
                "TEL: 03293828343\n" + "Date : 18-Dec-22 8:48:11 pm\n"
                + "Cashier: " + nameOfCashier + "\n" + "Customer Name: " + nameOfCustomer);
        System.out.print("===================================================\n");
        System.out.print("          " + "ITEM" + "   QTY" + "   PRICE" + "   TOTAL(NGN)\n");
        System.out.print("---------------------------------------------------\n");

        displayItemBoughtQuantityAndPriceOnTheReceipt();
        System.out.print("---------------------------------------------------\n");

        System.out.println("        " + "Sub Total:" + "             " + subTotal());
        System.out.println("        " + " Discount:" + "             " + calculatedDiscount());
        System.out.printf("%18s%19.2f\n","VAT @ 17.50%:",calculatedVAT());

        System.out.print("===================================================\n");

        System.out.printf("%18s%19.2f\n","Bill Total:",totalBill());

        System.out.printf("%18s%19.2f\n","Amount Paid:",amountPaidByCustomer);

        System.out.printf("%18s%19.2f\n","Balance:",calculateBalanceIfThereIsAnyAfterCustomerPaidCash());

        System.out.print("===================================================\n");

        System.out.print("THANK YOU FOR YOUR PATRONAGE\n");

        System.out.print("===================================================\n");
    }

}


