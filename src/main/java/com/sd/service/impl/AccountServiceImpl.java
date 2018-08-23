package com.sd.service.impl;

import com.sd.dbconfig.DataSourceType;
import com.sd.dbconfig.SwitchDataSource;
import com.sd.exception.BusinessException;
import com.sd.mapper.AccountMapper;
import com.sd.model.Account;
import com.sd.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: springboot-demo
 * @description: 用户业务
 * @author: zZ
 * @create: 2018-07-06 10:30
 **/
@Service
public class AccountServiceImpl implements IAccountService{

    @SuppressWarnings("all")
    @Autowired
    AccountMapper accountMapper;

    @SwitchDataSource(DataSourceType.Master)
    public Account getAccountByMs(String agentCode){
        Account account = accountMapper.getAccountBy(agentCode);
        if (account == null){
            throw new BusinessException("用户不存在");
        }
        return account;
    }

    @SwitchDataSource(DataSourceType.Slave)
    public Account getAccountByOc(String agentCode){
        Account account = accountMapper.getAccountBy(agentCode);
        if (account == null){
            throw new BusinessException("用户不存在");
        }
        return account;
    }

    @SwitchDataSource(DataSourceType.Pg)
    public Account getAccountByPg(String agentCode){
        Account account = accountMapper.getAccountBy(agentCode);
        if (account == null){
            throw new BusinessException("用户不存在");
        }
        return account;
    }
}
