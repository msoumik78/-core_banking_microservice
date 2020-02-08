package dao;

import model.BankingAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<BankingAccount, Long> {
    BankingAccount findAccountBalanceById(int accountId);
}
