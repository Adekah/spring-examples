package com.adekah.repository;

import com.adekah.entity.User;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface UserRepository extends ElasticsearchRepository<User, String> {
    @Query("{\"bool\":{\"must\":[{\"match\":{\"name \":\"?0\"}}]}}")
    List<User> getByCustomQuery(String search);

    List<User> findByNameLikeOrSurnameLike(String name, String surname); // ---> Spring Data format
}
