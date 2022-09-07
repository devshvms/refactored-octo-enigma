package in.dev.shvms.refactoredoctoenigma.customActuatorEndpoint;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * ActuatorInfoAddon component is used to add application related information
 * in /actuator/info endpoint if exposed.
 * By default, it returns empty json.
 * To add we can implement InfoContributor in our class and override contribute method.
 */
@Component
public class ActuatorInfoAddon implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        Map<String,Object> infoMap = new HashMap<>();
        infoMap.put("name", "RefactoredOctoEnigma");
        infoMap.put("version", "v1.0.0");
        infoMap.put("server_timestamp", ZonedDateTime.now());
        builder.withDetails(infoMap);
    }
}
