package bbs.xqdxc.security.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/testcontroller")
public class TestController {
    @GetMapping("/{id}")
    public Object getPost(@PathVariable String id) {

        return "test/id" + id ;
    }

}
