import com.google.gson.Gson;

import java.util.Scanner;

public class Main {


    private final String BASE_API = "https://v6.exchangerate-api.com/v6/";
    private final String API_KEY = "542c57f5386701a5a3e52b1c";
    private String baseCurrency;
    private String finalCurrency;
    private double amount;
    private Gson gson = new Gson();
    private Integer exit = 1;
    private Scanner input = new Scanner(System.in);
    private ConsumeApi consumeApi = new ConsumeApi();

    public void runConde(){
        System.out.println("*** Bienvenido al Conversor de Monedas ***");

        while(exit != 0){
            System.out.println("""
                    Elige la operación a realizar
                    
                    1. Dólar [USD] => Peso Argentino [ARS]
                    2. Peso argentino [ARS] => Dólar [USD]
                    3. Dólar [USD] => Real Brasileño [BRL]
                    4. Real Brasileño [BRL] => Dólar [USD]
                    5. Dólar [USD] => Peso Colombiano [COP]
                    6. Peso Colombiano [COP] => Dólar [USD]
                    7. Salir
                    
                    
                    """);
            Integer option = input.nextInt();
            input.nextLine();

            switch (option){

                case 1:
                    baseCurrency = "USD";
                    finalCurrency = "ARS";
                    fromBasetoFinal(baseCurrency, finalCurrency);
                    break;

                case 2:
                    baseCurrency = "ARS";
                    finalCurrency = "USD";
                    fromBasetoFinal(baseCurrency, finalCurrency);
                    break;

                case 3:
                    baseCurrency = "USD";
                    finalCurrency = "BRL";
                    fromBasetoFinal(baseCurrency, finalCurrency);
                    break;

                case 4:
                    baseCurrency = "BRL";
                    finalCurrency = "USD";
                    fromBasetoFinal(baseCurrency, finalCurrency);
                    break;

                case 5:
                    baseCurrency = "USD";
                    finalCurrency = "COP";
                    fromBasetoFinal(baseCurrency, finalCurrency);
                    break;

                case 6:
                    baseCurrency = "COP";
                    finalCurrency = "USD";
                    fromBasetoFinal(baseCurrency, finalCurrency);
                    break;

                default:
                    exit = 0;
                    System.out.println("Cerrando el programa... Gracias por usar");
            }

        }

    }

    public void fromBasetoFinal(String baseCurrency, String finalCurrency){
        System.out.println("¿Qué cantidad quieres convertir");
        amount = input.nextInt();
        input.nextLine();
        String jsonRequest = consumeApi.getUrl(BASE_API + API_KEY + "/pair/" + baseCurrency + "/" + finalCurrency + "/" + amount);
        Currency cambio = gson.fromJson(jsonRequest, Currency.class);
        System.out.printf("""
                
                La Conversión es:
                %.2f %s son %.2f %s
                
                """, amount, cambio.getBaseCurrency(), cambio.getFinalAmount(), cambio.getFinalCurrecy() );
    }


}
