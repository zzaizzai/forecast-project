package com.junsai.forecast_project.aspect;

import com.junsai.forecast_project.entity.Log;
import com.junsai.forecast_project.repository.LogRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

import java.time.LocalDateTime;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    private final HttpServletRequest request;

    @Autowired
    private LogRepository logRepository;

    public LoggingAspect(HttpServletRequest request) {
        this.request = request;
    }

    @Pointcut("execution(* com.junsai.forecast_project.service.*.*(..))")
    public void servicePointcut() {
    }

    @Pointcut("execution(* com.junsai.forecast_project.controller.*.*(..))")
    public void controllerPointcut() {
    }

    @Around("servicePointcut() || controllerPointcut()")
    public Object logExecutionTime(org.aspectj.lang.ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;

        String clientIpAddress = this.getClientIpAddress();
        LocalDateTime timestamp = LocalDateTime.now();

        Log log = new Log("no user name", clientIpAddress, joinPoint.getSignature().toShortString(), "Executed in " + executionTime + "ms", timestamp);
        logRepository.save(log);
        logger.info(" {} executed in {}ms", joinPoint.getSignature(), executionTime);

        return proceed;
    }

    private String getClientIpAddress() {

        if (RequestContextHolder.getRequestAttributes() == null) {
            return "batch";
        }

        if (request == null) {
            return "unknown";
        }

        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }

}
