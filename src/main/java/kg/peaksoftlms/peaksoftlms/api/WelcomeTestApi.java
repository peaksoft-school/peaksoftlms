package kg.peaksoftlms.peaksoftlms.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/")
public class WelcomeTestApi {

    @GetMapping
    public String welcome(){
        return "Welcome to Bilingual Application!!!";
    }
}