import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Offers> Offers= new ArrayList<>();
        Scanner Prepaid_scanner= new Scanner(new File("prepaid.txt"));
        Scanner Sub_scanner= new Scanner(new File("subscriptions.txt"));
        Scanner line_scanner;

        String Provider;
        String Name;
        String Price;
        String Minutes;
        String Texts;
        String Internet;
        String Student;
        String Discount;
        boolean T_carry;
        boolean M_carry;
        boolean I_carry;


        String line;
        while(Sub_scanner.hasNextLine())
        {
            line= Sub_scanner.nextLine();
            line_scanner= new Scanner(line);
            line_scanner.useDelimiter(", ");

            Provider=line_scanner.next();
            Name=line_scanner.next();
            Price=line_scanner.next();
            Minutes=line_scanner.next();
            Texts=line_scanner.next();
            Internet=line_scanner.next();

            if(line_scanner.hasNext())
            {
                Student = line_scanner.next();
                Discount = line_scanner.next();
                Offers.add(new Subscription(Provider, Name, Price, Minutes, Texts, Internet,  Student, Discount));
                Student= "0";
                Discount= "0";
            }
            else
            {
                Offers.add(new Subscription(Provider, Name, Price, Minutes, Texts, Internet,  "0", "0"));
            }
        }

        while(Prepaid_scanner.hasNextLine())
        {
            line= Prepaid_scanner.nextLine();
            line_scanner= new Scanner(line);
            line_scanner.useDelimiter(", ");

            Provider=line_scanner.next();
            Name=line_scanner.next();
            Price=line_scanner.next();
            Minutes=line_scanner.next();
            Texts=line_scanner.next();
            Internet=line_scanner.next();
            T_carry=Boolean.valueOf(line_scanner.next());
            M_carry=Boolean.valueOf(line_scanner.next());
            I_carry=Boolean.valueOf(line_scanner.next());


            if(line_scanner.hasNext())
            {
                Student = line_scanner.next();
                Discount = line_scanner.next();
                Offers.add(new Prepaid(Provider, Name, Price, Minutes, Texts, Internet, M_carry, T_carry, I_carry, Student, Discount));
                Student= "0";
                Discount= "0";
            }
            else
            {
                Offers.add(new Prepaid(Provider, Name, Price, Minutes, Texts, Internet,M_carry, T_carry, I_carry, "0", "0"));
            }
        }

        Scanner user_scanner= new Scanner(System.in);
        boolean enabled=true;
        String input;

        while(enabled)
        {
            System.out.println("Please make your choice:\n" +
                    "1 – Show all subscriptions and prepaid formulas\n" +
                    "2 – Filter subscriptions and prepaid formulas\n" +
                    "3 – Write to file\n" +
                    "4 – Stop the program");
            input= user_scanner.nextLine();

            switch(input)
            {
                case "1":
                    for (Offers offer: Offers) {
                        System.out.println(offer.toString());
                    }
                    break;
                case "2":
                    String choice= user_scanner.nextLine();
                    if(choice.equals("Subscription")) {
                        List<Offers> result= Offers.stream().filter(x-> x instanceof Subscription).collect(Collectors.toList());
                        System.out.println(result);

                    }
                    else if(choice.equals("Prepaid")) {
                        List<Offers> result= Offers.stream().filter(x-> x instanceof Prepaid).collect(Collectors.toList());
                        System.out.println(result);
                    }
                    else
                        System.out.println("No such offer");
                    break;
                case "3":
                    //System.out.println("Not implemented yet");
                    File file= new File("test.txt");
                    FileWriter fileWriter= new FileWriter(file);
                    for(Offers o: Offers)
                    {
                        fileWriter.write(o+"\n");
                    }
                    fileWriter.close();
                    break;
                case "4":
                    enabled= false;
                    break;
            }
        }
    }
}
