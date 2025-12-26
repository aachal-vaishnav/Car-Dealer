# Spring IoC – Car Dealer Console Application

This project demonstrates **Inversion of Control (IoC)** using Spring Framework with **XML-based configuration**.
It also explains how Spring Boot behaves when using an embedded web server (Tomcat).

---

## Project Structure

```

src/main/java/com/example/CarDealer/
│
├── CarDealerApplication.java
├── Car.java
├── FamilyCar.java
├── SportsCar.java
└── CyberTruckCar.java

src/main/resources/
└── applicationContext.xml

````

---

## Problem Without IoC (Tightly Coupled)

```java
Car car = new SportsCar(); // tightly coupled
````

* Business logic depends on concrete classes
* Changing implementation requires code changes

---

## Solution Using IoC (Loose Coupling)

* Objects are **not created using `new`**
* Spring creates and manages objects (Beans)
* Business logic depends only on interfaces

```java
Car car = (Car) context.getBean(beanId);
```

---

## Bean Configuration (XML Approach)

```xml
<bean id="SportsCar" class="com.example.CarDealer.SportsCar"/>
<bean id="FamilyCar" class="com.example.CarDealer.FamilyCar"/>
<bean id="CyberTruckCar" class="com.example.CarDealer.CyberTruckCar"/>
```

* XML is a **tag-based markup language**
* Uses **XML Schema-based `<bean>` configuration**
* Defined inside `applicationContext.xml`

Reference:
[https://docs.spring.io/spring-framework/docs/4.2.x/spring-framework-reference/html/xsd-configuration.html](https://docs.spring.io/spring-framework/docs/4.2.x/spring-framework-reference/html/xsd-configuration.html)

---

## How Spring Knows Which Object to Create

* Each bean has a unique `id`
* Based on user input, the correct bean is fetched using `getBean(beanId)`
* Spring returns the required object at runtime

---

## Application Flow

1. Spring Boot starts
2. Spring container loads `applicationContext.xml`
3. User selects car type
4. Spring provides the correct bean
5. Car details are displayed

---

## Important Note About Spring Boot & Tomcat

This project uses **Spring Boot Web**, which starts an embedded **Tomcat server**.

Even after the program logic finishes:

* The application keeps running
* Because Tomcat keeps the JVM alive

To stop the application manually:

```java
System.exit(0);
```

---

## Key Concepts Covered

* Inversion of Control (IoC)
* Bean Creation
* XML-based Spring Configuration
* Runtime Bean Selection
* Spring Boot Embedded Tomcat behavior
