package com.asap.server.controller.dto.request;

import com.asap.server.domain.enums.TimeSlot;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMeetingTimeSaveRequestDto {

    @NotNull
    private DateDto date;

    @NotNull
    private List<ScheduleDto> schedule;
    private class DateDto{

        @Pattern(regexp = "\\d{2}", message = "날짜 형식이 맞지 않습니다.")
        private String month;


        @Pattern(regexp = "\\d{2}", message = "날짜 형식이 맞지 않습니다.")
        private String day;


        @Pattern(regexp = "[\\uAC00-\\uD7A3]", message = "날짜 형식이 맞지 않습니다.")
        private String dayOfWeek;
    }
    private class ScheduleDto{
        private TimeSlot startTime;
        private TimeSlot endTime;
        private int priority;
    }
}