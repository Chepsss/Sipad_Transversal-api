package it.almaviva.difesa.sipad.shared.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Aspect
@Slf4j
@Component
public class PerformanceServicesAspect {

    @Around( "publicServicesMethods()" )
    public Object logServicesPerformance ( ProceedingJoinPoint joinPoint ) throws Throwable {

        Object result = joinPoint.proceed ();

        if(log.isDebugEnabled()) {
            long startTime = Calendar.getInstance().getTimeInMillis();
            long endTime = Calendar.getInstance().getTimeInMillis();

            long time = endTime - startTime;
            String info = String.format("Performance Service Indicator => SERVICE EXECUTION TIME : %1$s = %2$s " +
                    "(milliseconds)", joinPoint.getSignature().toShortString(), time);
            log.debug(info);
        }
        return result;
    }

    @Before( "publicServicesMethods()" )
    public void logBeforeServices ( JoinPoint joinPoint ) {

        if(log.isDebugEnabled()) {
            String info = String.format("Performance Service Indicator => SERVICE NAME START : %1$s",
                    joinPoint.getSignature().toShortString());
            log.debug(info);
        }
    }

    @After( "publicServicesMethods()" )
    public void logAfterServices ( JoinPoint joinPoint ) {

        if(log.isDebugEnabled()) {
            String info = String.format("Performance Service Indicator => SERVICE NAME END : %1$s",
                    joinPoint.getSignature().toShortString());
            log.debug(info);
        }
    }

    @Pointcut(
                "execution(public * it.almaviva.difesa.sipad.ageLimits.service..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.desk.service..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.docattdocumento.service..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.employee.service..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.hierarchy.service..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.proceeding.service..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.registrosegnatura.service..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.stoaoo.service..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.struarubricaaoo.service..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.titolario.service..*.*(..))" )
    public void publicServicesMethods () {

    }
}
