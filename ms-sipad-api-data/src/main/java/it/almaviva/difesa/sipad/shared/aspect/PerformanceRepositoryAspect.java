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
public class PerformanceRepositoryAspect {

    @Around ( "publicRepositoryMethods()" )
    public Object logRepositoryPerformance ( ProceedingJoinPoint joinPoint ) throws Throwable {

        long startTime = Calendar.getInstance ().getTimeInMillis ();
        Object result = joinPoint.proceed ();
        long endTime = Calendar.getInstance ().getTimeInMillis ();
        long time = endTime - startTime;
        String info = String.format ( "Performance Repository Indicator => REPOSITORY EXECUTION TIME : %1$s = %2$s " +
                                              "(milliseconds)", joinPoint.getSignature ().toShortString (), time );
        log.info( info );
        return result;
    }

    @Before ( "publicRepositoryMethods()" )
    public void logBeforeRepository ( JoinPoint joinPoint ) {

        String info = String.format ( "Performance Repository Indicator => REPOSITORY NAME START : %1$s",
                                      joinPoint.getSignature ().toShortString () );
        log.info ( info );
    }

    @After ( "publicRepositoryMethods()" )
    public void logAfterRepository ( JoinPoint joinPoint ) {

        String info = String.format ( "Performance Repository Indicator => REPOSITORY NAME END : %1$s",
                                      joinPoint.getSignature ().toShortString () );
        log.info ( info );
    }

    @Pointcut (
                "execution(public * it.almaviva.difesa.sipad.aadba.ageLimits.repository..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.aadba.desk.repository..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.aadba.docatcdocumento.repository..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.aadba.dosta.repository..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.aadba.dotiptdocumento.repository..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.aadba.employee.repository..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.aadba.hierarchy.repository..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.aadba.proceeding.repository..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.aadba.registrosegnatura.repository..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.shared.repository..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.aadba.stoaoo.repository..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.aadba.struarubricaaoo.repository..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.aadba.struirubricaipa.repository..*.*(..)) || " +
                        "execution(public * it.almaviva.difesa.sipad.aadba.titolario.repository..*.*(..))" )
    public void publicRepositoryMethods () {

    }
}
