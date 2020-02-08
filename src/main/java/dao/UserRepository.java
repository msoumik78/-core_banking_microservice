package dao;

import model.BankingUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<BankingUser, Long> {
    BankingUser findByUsername(String username);
    int findIdByUsername(String userName);
}
