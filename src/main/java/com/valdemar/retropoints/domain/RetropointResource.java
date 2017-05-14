package com.valdemar.retropoints.domain;

import com.valdemar.retropoints.endpoint.RetropointController;
import org.springframework.data.annotation.Id;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.time.LocalDate;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


public class RetropointResource extends ResourceSupport {

    private Retropoint retropoint;

    public RetropointResource() {
    }

    public RetropointResource(Retropoint retropoint){
        this.retropoint = retropoint;
        this.add(linkTo(methodOn(RetropointController.class).get(retropoint.getId())).withSelfRel());
    }

    public Retropoint getRetropoint() {
        return retropoint;
    }
}
