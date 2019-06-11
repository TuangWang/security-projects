package bbs.xqdxc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/post")
public class PostController {

    @GetMapping("/{id}")
    public Object getPost(@PathVariable String id) {
        return "id" + id ;
    }
}
