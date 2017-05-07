package com.valdemar.retropoints.endpoint;

import com.valdemar.retropoints.domain.Retropoint;
import com.valdemar.retropoints.service.RetropointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RetropointController {

    @Autowired
    RetropointService retropointService;

    @RequestMapping("/")
    public String healthCheck(){
        return "I'm Alive";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody Retropoint retropoint){
        retropointService.addRetropoint(retropoint);
        return ResponseEntity.noContent().build();
    }
}
