package in.dev.shvms.refactoredoctoenigma.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppHealthController {

    @GetMapping("/")
    public String index() {
        return "Hit success!";
    }

    @GetMapping("/ping/{pingString}")
    public String ping(@PathVariable String pingString) {
        return pingString+" successful";
    }

}
