/**
 * This is a password generating program.
 * 
 * @Ruthie Dignan
 * @11/26/2020
 */
import java.util.Scanner;
import java.util.Random;
public class SecretPasscode

{
    public static void main(String[] args) 
    {
        //initialize scanner
        Scanner in = new Scanner(System.in);
        
        //declare and initialize variables
        Random random = new Random();
        String menuSelect = "0";
        String passWord;
        int passLength;
        int charCode = 0;
        boolean validChoice;

        while (!menuSelect.equals("5")){
        //password generator menu
        System.out.println("Password Generator");
        System.out.println("==============================================================");
        System.out.println("  [1] Only lowercase Letters    ");
        System.out.println("  [2] Lowercase & Uppercase Letters     ");
        System.out.println("  [3] Lowercase,Uppercase Letters & Numbers  ");          
        System.out.println("  [4] Lowercase,Uppercase Letters & Numbers & Punctuation ");      
        System.out.println("  [5] Quit                      ");
        System.out.println("==============================================================");
     
        //Prompt for a menu selection
        System.out.println("Enter Selection (1-5): ");
        menuSelect = in.next();
        
        if (!menuSelect.equals("5") && (menuSelect.equals("1") || menuSelect.equals("2") || menuSelect.equals("3") || menuSelect.equals("4")))
        {
            System.out.println();
            passLength = 0;
            
            while (passLength > 14 || passLength < 6)
            {
                System.out.println("Password Length (6-14): ");
                passLength = Integer.parseInt(in.next());
                if (passLength > 14 || passLength < 6)
                {
                    System.out.println("Invalid password length. Please enter a length between 6 and 15");
                }
               
            }
            
            passWord = "";
            for (int i = 0; i < passLength; i++)
            {
                if(menuSelect.equals("1"))
                {
                    charCode = random.nextInt(26) + 97;
                }
                else if (menuSelect.equals("2"))
                {
                    charCode = random.nextInt(26) + 65 + (32 * random.nextInt(2));
                }
                else if (menuSelect.equals("3"))
                {
                    charCode = random.nextInt(36);
                    if (charCode >= 10)
                    {
                     charCode += 55 + (32 * random.nextInt(2));   
                    }
                    else 
                    {
                        charCode +=48;
                    }
                }
                else if (menuSelect.equals("4"))
                {
                    charCode = random.nextInt(78) + 48;
                }
                passWord += (char) charCode;
            }
            System.out.println("Thank you for using the Pass Code Generator.");
            System.out.println("");
            System.out.println("Here is your randomly generated pass code: ");
            System.out.println(passWord);
            System.out.println("");
        }
        else if (!menuSelect.equals("5"))
        {
            System.out.println("Invalid menu option, please try again.");
            System.out.println("");
        }
       }
     }
}
