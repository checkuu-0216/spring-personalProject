package com.sparta.springPersonalProject.entity;

import com.sparta.springPersonalProject.dto.scheduleDto.ScheduleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Schedule {
    private Long scheduleId;
    private String contents;
    private String managerName;
    private String password;
    private LocalDateTime resistDate;
    private LocalDateTime editDate;

    public Schedule(ScheduleRequestDto requestDto) {
        this.contents = requestDto.getContents();
        this.managerName = requestDto.getManagerName();
        this.password = requestDto.getPassword();
        this.resistDate = requestDto.getResistDate();
    }

    public void update(ScheduleRequestDto requestDto) {
        this.contents = requestDto.getContents();
        this.managerName = requestDto.getManagerName();
        this.password = requestDto.getPassword();
        this.editDate = requestDto.getEditDate();
    }
}
