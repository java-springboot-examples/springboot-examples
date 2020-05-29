package springboot.examples.keycloak.springsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import springboot.examples.keycloak.springsecurity.model.Account;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private List<Account> accounts = Arrays.asList(
            new Account(1, "Account A"),
            new Account(2, "Account B"),
            new Account(3, "Account C")
    );

    @GetMapping
    public List<Account> getAccounts() {
        return accounts;
    }

    @GetMapping(path = "/{id}")
    public Account getProduct(@PathVariable int id) {
        return accounts.stream()
                .filter(account -> account.getId() == id).findFirst()
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND, String.format("Account with id: %d not found", id))
                );
    }
}
