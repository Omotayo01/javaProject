package CheckOutBackup;


import CheckOutApp.CartPopulation;

public class CustomerDetails {
    public static void main(String[] args) {
        CheckOutApp.CartPopulation checkOut = new CartPopulation();

        checkOut.keepShopping();

        checkOut.displayFirstReceiptWithoutCalculatedChange();

        checkOut.displayFinalReceiptAfterChangeHaveBeenCalculated();
    }
}
