package com.example.demo.service;

import com.example.demo.dto.ActorDto;
import com.example.demo.entity.Actor;
import com.example.demo.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public ActorDto findActorId(Integer id) {
        Actor actor = actorRepository.findById(id).get();
        return new ActorDto().builder()
                .id(actor.getId())
                .name(actor.getName())
                .age(actor.getAge())
                .build();
    }
}
