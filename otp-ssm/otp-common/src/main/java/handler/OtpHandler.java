package handler;

import config.OtpConstant;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import utils.StringUtils;

import java.util.Date;

/**
 * 业务辅助生成器
 */
@Repository
public class OtpHandler {
    public String getOrderIndexCode(Long userId,Date date,Long id){
        String tempUserId=StringUtils.str2NBitStr(userId,"0",8);
        String auth=OtpConstant.AUTH;
        Long timeStamp=date.getTime();
        String tempId=StringUtils.str2NBitStr(id,"0",8);
        return auth+tempUserId+timeStamp+tempId;
    }
}
