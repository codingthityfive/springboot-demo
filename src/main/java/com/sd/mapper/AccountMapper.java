package com.sd.mapper;

import org.apache.ibatis.annotations.*;
import com.sd.model.Account;

/**
 * @program: springboot-demo
 * @description: 用户业务
 * @author: zZ
 * @create: 2018-06-01 15:33
 **/
@Mapper
public interface AccountMapper {

    @Select("select * from account where agent_code = '${agentCode}'")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "agentCode", column = "AGENT_CODE"),
            @Result(property = "createTime", column = "CREATE_TIME"),
            @Result(property = "operateTime", column = "OPERATE_TIME")
    })
    Account getAccountBy(@Param("agentCode") String agentCode);
}
