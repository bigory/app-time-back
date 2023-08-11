package com.example.demo.service;

import com.example.demo.dto.TimeDto;
import com.example.demo.entity.Time;
import com.example.demo.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeService {

    private final TimeRepository timeRepository;

    @Autowired
    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    public TimeDto save(TimeDto timeDto) {
        Time time = Time.builder()
                .time(timeDto.getTime())
                .build();
        Time save = timeRepository.save(time);
        timeDto.setId(save.getId());
        return timeDto;
    }

    public TimeDto delete(Integer id) {
        Time time = timeRepository.findById(id).get();
        timeRepository.delete(time);
        return TimeDto.builder()
                .affectedRows(true)
                .time(time.getTime())
                .id(id)
                .build();
    }

    public TimeDto findByTimeId(Integer id) {
        Time time = timeRepository.findById(id).get();
        return TimeDto.builder()
                .id(time.getId())
                .time(time.getTime())
                .build();
    }

    public List<TimeDto> findAllTime() {
        List<TimeDto> timeDtoList = new ArrayList<>();
        for (Time time : timeRepository.findAll()) {
            timeDtoList.add(TimeDto.builder()
                    .time(time.getTime())
                    .id(time.getId())
                    .build());
        }
        return timeDtoList;
    }

}
