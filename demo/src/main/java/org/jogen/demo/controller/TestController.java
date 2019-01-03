package org.jogen.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jogen
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("get")
    public ResponseEntity<?> get(@RequestParam String id){
        System.out.println(id);
        return ResponseEntity.ok(id);
    }
}
