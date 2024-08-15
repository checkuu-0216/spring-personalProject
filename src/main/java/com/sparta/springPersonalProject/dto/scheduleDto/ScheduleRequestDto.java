package com.sparta.springPersonalProject.dto.scheduleDto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleRequestDto {
    private Long scheduleId;
    private String contents;
    private String managerName;
    private String password;
    private LocalDateTime resistDate;
    private LocalDateTime editDate;
}
