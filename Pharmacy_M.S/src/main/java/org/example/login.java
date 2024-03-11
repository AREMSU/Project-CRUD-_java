package org.example;
import java.util.Scanner;

public class login {
    public static void main(String[] args) {

        String admin_user = "admin";
        String admin_pw = "password";
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your user name: ");
        String userName = sc.nextLine();

        System.out.println("Enter your user password: ");
        String userPw = sc.nextLine();

        if (userName.equals(admin_user)) {

            if (userPw.equals(admin_pw)) {

                System.out.println("Welcome user!");

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
