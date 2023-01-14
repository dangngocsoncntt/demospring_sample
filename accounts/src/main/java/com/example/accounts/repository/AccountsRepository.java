package com.example.accounts.repository;

import com.example.accounts.model.AccountsDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class AccountsRepository {

    private List<AccountsDto> accountList = new ArrayList<>();

    public void save(AccountsDto accountsDto){
        accountList.add(accountsDto);
    }

    public void saveAll(Collection<AccountsDto> accountsDtos){
        accountList.addAll(accountsDtos);
    }

}
