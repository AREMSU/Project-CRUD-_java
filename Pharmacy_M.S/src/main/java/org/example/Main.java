package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import org.example.models.drugs;
import org.example.models.homescreen;
import org.example.models.cart;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String admin_user = "Aarnav";
        String admin_pw = "password";
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your user name: ");
        String userName = sc.nextLine();

        System.out.println("Enter your user password: ");
        String userPw = sc.nextLine();

        if (userName.equals(admin_user)) {

            if (userPw.equals(admin_pw)) {

                homescreen pharmacy = new homescreen();

                pharmacy.addDrug(new drugs("Paracetamol", "Ya Meds", 10,5.99));
                pharmacy.addDrug(new drugs("Amoxicillin", "Drugs", 7,7.50));
                pharmacy.addDrug(new drugs("Aspirin", "NaA", 5,3.25));

                List<drugs> drugList = pharmacy.getDrugList();
                System.out.println("Pharmacy Drug List:");
                for (drugs drug : drugList) {
                    System.out.println(drug);
                }

                cart cart = new cart();
                String choice;
                do {
                    System.out.print("\nEnter the name of the drug you want to purchase (or type 'done' to finish): ");
                    choice = scanner.nextLine();
                    if (!choice.equalsIgnoreCase("done")) {
                        drugs selectedDrug = pharmacy.searchDrugByName(choice);
                        if (selectedDrug != null) {
                            cart.addToCart(selectedDrug);
                            System.out.println("Added " + selectedDrug.getName() + " to cart.");
                        } else {
                            System.out.println("Drug not found in the pharmacy.");
                        }
                    }
                } while (!choice.equalsIgnoreCase("done"));

                System.out.println("\nYour Bill:");
                for (drugs drug : cart.getcartItems()) {
                    System.out.println(drug);
                }
                System.out.println("Total: $" + cart.calculateTotal()+"\r\n" +
                        "----------------------------------------------------------");


                StringBuilder itemsBuilder = new StringBuilder();
                for (drugs drug : cart.getcartItems()) {
                    itemsBuilder.append(drug.getName()).append(", ");
                }

                String name = admin_user;
                String items = itemsBuilder.toString().replaceAll(", $", "");
                int price = (int) cart.calculateTotal();

                String url = "jdbc:sqlite:CustomerList.sqlite";
                String createStatementSqlClass = "CREATE TABLE IF NOT EXISTS CustomerList ( id integer PRIMARY KEY NOT NULL ," +
                        "Name text,"+
                        "Drug text," +
                        "Quantity integer," +
                        "Price integer )";

                String insertStatement = "INSERT INTO CustomerList (Name,Drug,Quantity,Price) values (?,?,?,?)";

                try{

                    Connection connection = DriverManager.getConnection(url);
                    Statement stm = connection.createStatement();
                    stm.execute(createStatementSqlClass);


                    PreparedStatement ptm = connection.prepareStatement(insertStatement);
                    ptm.setString(1,name);
                    ptm.setString(2,items);
                    ptm.setInt(3,1);
                    ptm.setInt(4,price);
                    ptm.execute();
                    System.out.println("Executed");


                    connection.close();
                }

                catch ( Exception e){

                    System.out.println("Error");
                    e.printStackTrace();
                }

            }

            else{

                System.out.println("Invalid password.");

            }


        }
        else {
            System.out.println("Wrong username.");
        }







    }
}