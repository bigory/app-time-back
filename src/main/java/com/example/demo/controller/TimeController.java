package com.example.demo.controller;

import com.example.demo.dto.TimeDto;
import com.example.demo.service.TimeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TimeController {

    private final TimeService currentTimeService;

    @Autowired
    public TimeController(TimeService currentTimeService) {
        this.currentTimeService = currentTimeService;
    }

    @SneakyThrows
    @PostMapping(value = "/save-time", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody TimeDto saveCurrentTime(@RequestBody String timeCurrent) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        TimeDto timeDto = objectMapper.readValue(timeCurrent, TimeDto.class);
        return currentTimeService.save(timeDto);
    }

    @SneakyThrows
    @DeleteMapping(value = "/delete-time/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody TimeDto deleteCurrentTime(@PathVariable(name = "id") Integer id) {
        return currentTimeService.delete(id);
    }

    @SneakyThrows
    @GetMapping(value = "/times", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<TimeDto> findAllTimes() {
        return currentTimeService.findAllTime();
    }
}