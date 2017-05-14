package com.valdemar.retropoints.service;

import com.valdemar.retropoints.domain.Retropoint;
import com.valdemar.retropoints.repo.RetropointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RetropointService {

    @Autowired
    private RetropointRepository repository;


    public Retropoint addRetropoint(Retropoint retropoint){
        return repository.save(retropoint);
    }

    public Retropoint getRetropoint(Integer id) {
        return repository.findOne(id);
    }
}
