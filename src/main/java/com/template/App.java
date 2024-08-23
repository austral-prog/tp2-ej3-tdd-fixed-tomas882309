package com.template;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class App {


    public static Map<String, Integer> deposit(Map<String, Integer> accounts, String account, int amount) {


        if (accounts.containsKey(account) && amount > 0) {
            int value = accounts.get(account);
            accounts.put(account,value + amount);
            return accounts;
        }
        else {
            return accounts;
        }
    }

    public static Map<String, Integer> retirar(Map<String, Integer> accounts, String account, int amount){
        if (accounts.containsKey(account) && amount > 0 && accounts.get(account) > 0 && amount <= accounts.get(account)) {
            int value = accounts.get(account);
            accounts.put(account, value - amount);
            return accounts;
        }
        else {
            return accounts;
        }
    }

    public static Map<String, Integer> transferencia(Map<String, Integer> accounts, String account1, String account2, int amount) {
        if (accounts.containsKey(account1) && accounts.containsKey(account2) && amount > 0 && accounts.get(account1) > 0 && account1 != account2 && amount <= accounts.get(account1)) {
            int value1 = accounts.get(account1);
            int value2 = accounts.get(account2);
            accounts.put(account1, value1 - amount);
            accounts.put(account2, value2 + amount);
            return accounts;
        }
        else {
            return accounts;
        }
    }

}