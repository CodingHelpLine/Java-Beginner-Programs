import java.util.Scanner;

/**
 * Temperature conversion Program. 
 * 
 * @author Programmer
 */
public class TempatureConvertion {

    private static final double ABS_ZERO = 273.15;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        
        int choice; 
        double input;
        double result; 
        
        do {
            // ask for menu option
            choice = menu(keyboard);
            System.out.println();
            
            // Read input temperature
            System.out.print("Please enter temperature to convert: ");
            input = keyboard.nextDouble();
            
            if(choice == 1) { // C to F
                result = cToF(input); 
                System.out.printf("%.2f Celsius to Fahrenheit is %.2f%n", 
                        input, result);
            } else if(choice == 2) { // F to C
                result = fToC(input); 
                System.out.printf("%.2f Fahrenheit to Celsius is %.2f%n", 
                        input, result);
            } else if(choice == 3) { // C to K
                result = cToK(input); 
                System.out.printf("%.2f Celsius to Kelvin is %.2f%n", 
                        input, result);
            } else if(choice == 4) { // K to C
                result = kToC(input); 
                System.out.printf("%.2f Kelvin to Celsius is %.2f%n", 
                        input, result);
            } else if(choice == 5) { // F to K
                result = fToK(input); 
                System.out.printf("%.2f Fahrenheit to Kelvin is %.2f%n", 
                        input, result);
            } else if(choice == 6) { // K to F
                result = kToF(input); 
                System.out.printf("%.2f Kelvin to Fahrenheit is %.2f%n", 
                        input, result);
            } else {
                System.out.println("GoodBye!...");
            }
            
            
            
            System.out.println();
        } while(choice != 0);
        
        keyboard.close();
    }
    
    /**
     * Function to convert Celsius to Fahrenheit. 
     * 
     * @param celsius temp
     * @return Fahrenheit temp
     */
    private static double cToF(double celsius) {
        return (celsius * 9.0/5.0) + 32;
    }
    
    /**
     * Function to convert Fahrenheit to Celsius. 
     * 
     * @param fahrenheit temp
     * @return Celsius temp
     */
    private static double fToC(double fahrenheit) {
        return (fahrenheit-32) * 5.0/9.0;
    }
    
    /**
     * Celsius to Kelvin
     * 
     * @param celsius temp
     * @return kelvin
     */
    private static double cToK(double celsius) {
        return celsius + ABS_ZERO;
    }
    
    /**
     * Kelvin to Celsius
     * 
     * @param kelvin temp
     * @return Celsius temp
     */
    private static double kToC(double kelvin) {
        return kelvin - ABS_ZERO;
    }
    
    /**
     * Fahrenheit to Kelvin
     * 
     * @param f temperature
     * @return kelvin temperature
     */
    private static double fToK(double f) {
        return cToK(fToC(f));
    }
    
    /**
     * Kelvin to Fahrenheit
     * 
     * @param k
     * @return f
     */
    private static double kToF(double k) {
        return cToF(kToC(k));
    }
    
    /**
     * Menu to show options
     * 
     * @param keyboard
     * @return choice 
     */
    private static int menu(Scanner keyboard) {
        System.out.println("Welcome to Temperature Menu");
        System.out.println("1. Celsius to Farenheit");
        System.out.println("2. Farenheit to Celsius");
        System.out.println("3. Celsius to Kelvin");
        System.out.println("4. Kelvin to Celsius");
        System.out.println("5. Fahrenheit to Kelvin");
        System.out.println("6. Kelvin to Fahrenheit");
        System.out.println("0. Exit");
        int choice;
        
        do {
            System.out.print("Enter choice: ");
            choice = keyboard.nextInt();
            
            if(choice < 0 || choice > 6) {
                System.out.println("Invalid Entry - try again");
            }
            
        }while(choice < 0 || choice > 6);
        
        return choice; 
    }
}
