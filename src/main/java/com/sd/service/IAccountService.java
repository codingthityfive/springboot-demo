package com.sd.service;

import com.sd.model.Account;

public interface IAccountService {

     Account getAccountByMs(String agentCode);

     Account getAccountByOc(String agentCode);

     Account getAccountByPg(String agentCode);
}
