package in.dev.shvms.refactoredoctoenigma.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
@Order(1)
public class ReqResLogFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(ReqResLogFilter.class);

    /**
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        logger.info(String.format(
                "Start processing ReqResLog Filter. Request IP: {}, Request endpoint: {}"),
                req.getRemoteAddr(),
                req.getRequestURL());
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info(String
                .format("Done processing transaction for endpoint: {}, with response status code: {}"),
                req.getRequestURI(),
                res.getStatus());
    }

}
