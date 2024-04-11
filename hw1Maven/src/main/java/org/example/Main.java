package org.example;

import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("Evgheni", "Advahov", 36);
        Gson gson = new Gson();

        String json = gson.toJson(person);
        System.out.println(json);

        Person person1 = gson.fromJson(json, Person.class);
        System.out.println(person1);

    }
}