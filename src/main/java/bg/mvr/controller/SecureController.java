package bg.mvr.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SecureController {

    @GetMapping
    public String home(Principal principal) {
        return "Hello, " + principal.getName();
    }

    @PreAuthorize("hasAuthority('SCOPE_READ')")
    @GetMapping("/secure")
    public String secure() {
        return "This is secured!";
    }

    @PreAuthorize("hasAuthority('SCOPE_MSKAT')")
    @GetMapping("/kat")
    public String kat() {
        return "This is kat!";
    }

}
