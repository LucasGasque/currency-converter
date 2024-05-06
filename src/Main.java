import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.ExchangeRateOperation;
import services.ExchangeRateApi;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static String printmenuSeparatorString() {
        return "=".repeat(10);
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println(printmenuSeparatorString());
            System.out.println("""
                    Welcome to the Exchange Rate Program, plz select a option to continue!
                    1 - Calculate 	Pound Sterling to Euros
                    2 - Calculate 	Euros to Pound Sterling
                    3 - End the program
                    """);
            System.out.println(printmenuSeparatorString());

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (Objects.equals(input, "3")) {
                System.out.println("Thank you for using the Exchange Rate Program!");
                break;
            }

            if (Objects.equals(input, "1") || Objects.equals(input, "2")) {
                System.out.println("Now select the value u want to Exchange:");
                String valueInput = scanner.nextLine();

                String baseCurrency = (Objects.equals(input, "1")) ? "GBP" : "EUR";
                String targetCurrency = (Objects.equals(input, "1")) ? "EUR" : "GBP";

                String result = new ExchangeRateApi().getExchangeRate(
                        baseCurrency,
                        targetCurrency,
                        Float.parseFloat(valueInput));

                Gson gson = new Gson();

                ExchangeRateOperation exchangeRateOperation = gson.fromJson(result, ExchangeRateOperation.class);

                System.out.println(exchangeRateOperation.toString());
            }
        }
    }
}
