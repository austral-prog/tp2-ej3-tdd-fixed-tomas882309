package com.template;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.template.App.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    Map<String, Integer> accounts = new HashMap<>(){{
        put("mati", 10);
        put("juan", 20);
    }};


    @Test
    void testDeposit1() {
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", 5);
        assertEquals(15, updatedAccounts.get("mati"));
    }

    @Test
    void testDeposit2() {
        Map<String, Integer> updatedAccounts = deposit(accounts, "Jose", 5);
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testDeposit3() {
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", 0);
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testDeposit4() {
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", -4);
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testDeposit5() {
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", 20);
        assertEquals(30, updatedAccounts.get("mati"));
    }



    @Test
    void testRetirar1() {
        Map<String, Integer> updatedAccounts = retirar(accounts, "mati", 5);
        assertEquals(5, updatedAccounts.get("mati"));
    }

    @Test
    void testRetirar2() {
        Map<String, Integer> updatedAccounts = retirar(accounts, "mati", 20);
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testRetirar3() {
        Map<String, Integer> updatedAccounts = retirar(accounts, "mati", -10);
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testRetirar4() {
        Map<String, Integer> updatedAccounts = retirar(accounts, "Jose", 5);
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testRetirar5() {
        Map<String, Integer> updatedAccounts = retirar(accounts, "juan", 5);
        assertEquals(15, updatedAccounts.get("juan"));
    }



    @Test
    void testTransferir1() {
        Map<String, Integer> updatedAccounts = transferencia(accounts, "juan", "mati", 10);
        assertEquals(10, updatedAccounts.get("juan"));
        assertEquals(20, updatedAccounts.get("mati"));
    }

    @Test
    void testTransferir2() {
        Map<String, Integer> updatedAccounts = transferencia(accounts, "mati", "juan", 10);
        assertEquals(30, updatedAccounts.get("juan"));
        assertEquals(0, updatedAccounts.get("mati"));
    }

    @Test
    void testTransferir3() {
        Map<String, Integer> updatedAccounts = transferencia(accounts, "jose", "mati", 10);
        assertEquals(20, updatedAccounts.get("juan"));
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testTransferir4() {
        Map<String, Integer> updatedAccounts = transferencia(accounts, "juan", "mati", -10);
        assertEquals(20, updatedAccounts.get("juan"));
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testTransferir5() {
        Map<String, Integer> updatedAccounts = transferencia(accounts, "juan", "mati", 100);
        assertEquals(20, updatedAccounts.get("juan"));
        assertEquals(10, updatedAccounts.get("mati"));
    }


}
