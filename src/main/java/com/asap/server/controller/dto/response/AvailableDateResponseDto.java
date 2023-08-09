package com.asap.server.controller.dto.response;

import com.asap.server.common.utils.DayOfWeekConverter;
import com.asap.server.domain.AvailableDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class AvailableDateResponseDto {
    private String month;
    private String day;
    private String dayOfWeek;
    private List<TimeBlockResponseDto> timeSlots;

    public static AvailableDateResponseDto of(LocalDate date, List<TimeBlockResponseDto> timeBlocks) {
        return new AvailableDateResponseDto(
                String.valueOf(date.getMonthValue()),
                String.valueOf(date.getDayOfMonth()),
                DayOfWeekConverter.convertDayOfWeekEnToKo(date.getDayOfWeek()),
                timeBlocks);
    }
}
