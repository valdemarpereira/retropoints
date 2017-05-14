package com.valdemar.retropoints.service;

import com.valdemar.retropoints.domain.Retropoint;
import com.valdemar.retropoints.endpoint.SortBy;
import com.valdemar.retropoints.repo.RetropointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

    public List<Retropoint> getAllRetropoints(SortBy sortBy) {
       // repository.

        return null;
    }
}
