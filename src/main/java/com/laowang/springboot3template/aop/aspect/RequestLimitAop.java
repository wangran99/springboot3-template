package com.laowang.springboot3template.aop.aspect;


import com.laowang.springboot3template.aop.annotation.RequestLimit;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
@Slf4j
public class RequestLimitAop {

    @Autowired
    private RedisTemplate redisTemplate;

//    @Pointcut("@annotation(com.chinasoft.example.annotation.RequestLimit)")
//    private void pointCut(){ }
//
//    @Before("pointCut() && @annotation(limit)")
//    public void before(JoinPoint joinPoint,RequestLimit limit)  {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//        String key = "req_limit_".concat(request.getRequestURI()).concat("_").concat(Constants.AUTH_CODE);
//        boolean checkResult = checkWithRedis(limit, key);
//        if (!checkResult) {
//            throw new RequestLimitException();
//        }
//    }

    /**
     * 以redis实现请求记录
     *
     * @param limit
     * @param key
     * @return
     */
    private boolean checkWithRedis(RequestLimit limit, String key) {
        long count = redisTemplate.opsForValue().increment(key, 1);
        if (count == 1) {
            redisTemplate.expire(key, limit.timeout(), TimeUnit.SECONDS);
        }
        if (count > limit.maxCount()) {
            return false;
        }
        return true;
    }
}
