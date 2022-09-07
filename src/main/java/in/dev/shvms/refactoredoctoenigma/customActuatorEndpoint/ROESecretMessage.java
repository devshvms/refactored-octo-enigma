package in.dev.shvms.refactoredoctoenigma.customActuatorEndpoint;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.context.annotation.Configuration;

@WebEndpoint(id = "secretMsg")
@Configuration("ROESecretMessageBean")
public class ROESecretMessage {

    String message = "Default Message!";

    /**
     * customAppInfoBean bean will expose endpoint /actuator/secretMsg
     * [@]endpoint annotation will let you expose jmx endpoint as well.
     * [@]ReadOperation specifies that this is a http GET method
     *
     * EXAMPLE REQUEST
     * GET /actuator/secretMsg HTTP/1.1
     * Host: localhost:8081
     *
     * @return String
     */
    @ReadOperation
    public String getMsg() {
        return this.message;
    }

    /**
     * [@]WriteOperation needs http POST method to access.
     *
     * HTTP EXAMPLE REQUEST
     *
     * POST /actuator/secretMsg HTTP/1.1
     * Host: localhost:8081
     * Content-Type: application/json
     * Content-Length: 42
     * {"msg": "Its working. Thats the message."}
     *
     * @param msg is input String
     * @return ack string as "success!"
     */
    @WriteOperation
    public String postMsg(String msg) {
        this.message = msg;
        return "success!";
    }
}
