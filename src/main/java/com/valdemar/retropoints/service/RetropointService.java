package com.valdemar.retropoints.service;

import com.valdemar.retropoints.domain.Retropoint;
import com.valdemar.retropoints.repo.RetropointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RetropointService {

    @Autowired
    private RetropointRepository repository;


    public void addRetropoint(Retropoint retropoint){
        repository.save(retropoint);
    }
}
