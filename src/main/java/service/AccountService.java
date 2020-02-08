package service;

import dao.AccountRepository;
import dao.UserRepository;
import model.BankingAccount;
import model.BankingUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    public double getAccountBalance(String userName){
        BankingUser bankingUser = userRepository.findByUsername(userName);
        System.out.println("In accountservice...userName passed is : "+userName +" , and id obtained is : "+bankingUser.getId());
        BankingAccount bankingAccount =  accountRepository.findAccountBalanceById(bankingUser.getId());
        System.out.println("In accountservice...balance : "+bankingAccount.getAccountBalance());
        return bankingAccount.getAccountBalance();
    }

}
