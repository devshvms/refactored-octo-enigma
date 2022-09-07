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
     * @endpoint annotation will let you expose jmx endpoint as well.
     * @Readoperation specifies that this is a http GET method
     * @return String
     */
    @ReadOperation
    public String getMsg() {
        return this.message;
    }

    @WriteOperation
    public String postMsg(String msg) {
        this.message = msg;
        return "success!";
    }
}
