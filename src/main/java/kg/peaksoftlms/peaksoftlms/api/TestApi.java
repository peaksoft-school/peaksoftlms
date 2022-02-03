package kg.peaksoftlms.peaksoftlms.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
@Tag(name = "Testing Token")
public class TestApi {

    @Operation(summary = "Token Test Request", description = "Testing token")
    @GetMapping("/test")
    public String test() {
        return "your token is working";
    }
}
