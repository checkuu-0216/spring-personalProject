package com.sparta.springPersonalProject.dto.scheduleDto;

import com.sparta.springPersonalProject.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private Long scheduleId;
    private String contents;
    private String managerName;
    private String password;
    private LocalDateTime resistDate;
    private LocalDateTime editDate;

    public ScheduleResponseDto(Schedule schedule) {
        this.scheduleId = schedule.getScheduleId();
        this.contents = schedule.getContents();
        this.managerName = schedule.getManagerName();
        this.password = schedule.getPassword();
        this.resistDate = schedule.getResistDate();
        this.editDate = schedule.getEditDate();
    }
}
