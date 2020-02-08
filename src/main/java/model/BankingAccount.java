package model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "BankingAccount")
@Data
public class BankingAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int accountId;
    @Column
    private String accountType;
    @Column
    private double accountBalance;
}
