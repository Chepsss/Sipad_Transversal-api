package it.almaviva.difesa.sipad.shared.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class ExceptionLoggerAspect {

    @AfterThrowing(pointcut = "execution(public * it.almaviva.difesa.sipad.ageLimits.service..*.*(..)) || " +
            "execution(public * it.almaviva.difesa.sipad.desk.service..*.*(..)) || " +
            "execution(public * it.almaviva.difesa.sipad.docattdocumento.service..*.*(..)) || " +
            "execution(public * it.almaviva.difesa.sipad.employee.service..*.*(..)) || " +
            "execution(public * it.almaviva.difesa.sipad.hierarchy.service..*.*(..)) || " +
            "execution(public * it.almaviva.difesa.sipad.proceeding.service..*.*(..)) || " +
            "execution(public * it.almaviva.difesa.sipad.registrosegnatura.service..*.*(..)) || " +
            "execution(public * it.almaviva.difesa.sipad.stoaoo.service..*.*(..)) || " +
            "execution(public * it.almaviva.difesa.sipad.struarubricaaoo.service..*.*(..)) || " +
            "execution(public * it.almaviva.difesa.sipad.titolario.service..*.*(..))" , throwing = "ex")
    public void logError(JoinPoint joinPoint, Exception ex) {

        String infoStart = String.format ( "Exception Logger => CATCH INTO SERVICE NAME START : %1$s" , joinPoint.toShortString() );
        log.info ( infoStart );

        log.error( ex.getStackTrace()[0].getClassName() );
        log.error(String.valueOf(ex.getStackTrace()[0].getLineNumber()));
        log.error( ex.getStackTrace()[0].getMethodName() );
        log.error( ex.getCause() == null ? ex.getMessage() : ex.getCause().getMessage() );

        String infoEnd = String.format ( "Exception Logger => CATCH INTO SERVICE NAME END   :  %1$s" , joinPoint.toShortString() );
        log.info ( infoEnd );

    }
}
