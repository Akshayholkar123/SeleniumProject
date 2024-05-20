







package Selenium;

import java.util.UUID;

public class GenrateRandomString {
public static void demo(String[] args) {
	String ranStr=UUID.randomUUID().toString().substring(0,8);
	System.out.println(ranStr);
}
}
