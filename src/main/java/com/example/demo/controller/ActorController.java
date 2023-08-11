package com.example.demo.controller;

import com.example.demo.dto.ActorDto;
import com.example.demo.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }


    @GetMapping(value = "/actor")
    public String saveCurrentTime(@RequestParam Integer id) {
        ActorDto actor = actorService.findActorId(id);
        return "actor " + actor.getName();
    }

}
