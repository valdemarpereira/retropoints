package com.valdemar.retropoints.repo;

import com.valdemar.retropoints.domain.Retropoint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "retropoint", path = "retropoint")
public interface RetropointRepository extends MongoRepository<Retropoint, Integer>{

}
