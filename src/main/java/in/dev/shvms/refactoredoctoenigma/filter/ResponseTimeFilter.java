package in.dev.shvms.refactoredoctoenigma.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;


@Component
@Order(2)
public class ResponseTimeFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(ResponseTimeFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ZonedDateTime startTimeInMillis = ZonedDateTime.now();
        filterChain.doFilter(servletRequest, servletResponse);
        long responseTime = ChronoUnit.MILLIS.between(startTimeInMillis, ZonedDateTime.now());
        logger.info("Time took to process this request: {}ms", responseTime);
    }
}
