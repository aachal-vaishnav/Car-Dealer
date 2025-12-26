package com.example.CarDealer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class CarDealerApplication {

	public static void main(String[] args) {
        SpringApplication.run(CarDealerApplication.class, args);
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Scanner input = new Scanner(System.in);
        String ans = "y";
        do {
            System.out.println("""
                    Choose from below:
                    1. Family Car
                    2. Sports Car
                    3. Cyber Truck Car
                    """);

            if (!input.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                input.next(); // clear invalid input
                continue;
            }

            int userSelect = input.nextInt();
            String beanId;

            switch (userSelect) {
                case 1 -> beanId = "FamilyCar";
                case 2 -> beanId = "SportsCar";
                case 3 -> beanId = "CyberTruckCar";
                default -> {
                    System.out.println("Invalid selection");
                    continue;
                }
            }
            Car car = (Car) context.getBean(beanId);
            car.showCarDetails();
            System.out.println("Do You want to continue?(y/n)");
            ans = input.next().toLowerCase();
        }while(ans.equals("y"));
        input.close();
        context.close();
    }
}


