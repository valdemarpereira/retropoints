package com.valdemar.retropoints.endpoint;

import com.valdemar.retropoints.domain.Retropoint;
import com.valdemar.retropoints.domain.RetropointResource;
import com.valdemar.retropoints.service.RetropointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RetropointController {

    @Autowired
    RetropointService retropointService;

    @RequestMapping(method = RequestMethod.GET, path = "/healthcheck")
    public String healthCheck(){
        return "I'm Alive";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public ResponseEntity<?> add(@RequestBody Retropoint input){
        Retropoint retropoint = retropointService.addRetropoint(input);

        return new ResponseEntity<>(new RetropointResource(retropoint), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id){
        Retropoint retropoint = retropointService.getRetropoint(id);
        return new ResponseEntity<RetropointResource>(new RetropointResource(retropoint), HttpStatus.OK);
    }


}
