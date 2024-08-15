package com.sparta.springPersonalProject.controller;

import com.sparta.springPersonalProject.dto.scheduleDto.ScheduleRequestDto;
import com.sparta.springPersonalProject.dto.scheduleDto.ScheduleResponseDto;
import com.sparta.springPersonalProject.entity.Schedule;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    @PostMapping("/schedule") //일정 생성
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        //requestdto -> entity
        Schedule schedule = new Schedule(requestDto);

        //schedule Max Id 찾기
        long maxId = scheduleList.size() > 0 ? Collections.max(scheduleList.keySet()) + 1 : 1;
        schedule.setScheduleId(maxId);

        //db 저장
        scheduleList.put(schedule.getScheduleId(), schedule);

        //entity -> reponseDto
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);

        return scheduleResponseDto;
    }

    @GetMapping("/schedule/{id}") //단건조회
    public ScheduleRequestDto getOneSchedule(@PathVariable long id,@RequestBody ScheduleRequestDto requestDto) {
        if (scheduleList.containsKey(id)) {
            Schedule schedule = scheduleList.get(id);

            return requestDto;
        } else {
            throw new IllegalArgumentException("선택한 일정은 존재하지 않습니다.");
        }

    }

    @GetMapping("/schedule") //스케줄 조회
    public List<ScheduleResponseDto> getSchedule() {
        // map to list
        List<ScheduleResponseDto> responseList = scheduleList.values().stream()
                .map(ScheduleResponseDto::new).toList();

        return responseList;
    }

    @PutMapping("/schedule/{id}")
    public Long updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        // 해당 스케줄 확인
        if (scheduleList.containsKey(id)) {
            //해당 일정 가져오기
            Schedule schedule = scheduleList.get(id);
            //일정 수정
            schedule.update(requestDto);

            return schedule.getScheduleId();

        } else {
            throw new IllegalArgumentException("선택한 일정은 존재하지 않습니다.");
        }
    }

    @DeleteMapping("/schedule/{id}")
    public Long deleteSchedule(@PathVariable Long id) {
        //해당 일정 존재하는지 확인
        if (scheduleList.containsKey(id)) {
            //해당 일정 삭제
            scheduleList.remove(id);
            return id;
        } else {
            throw new IllegalArgumentException("선택한 일정은 존재하지 않습니다.");
        }
    }
}
