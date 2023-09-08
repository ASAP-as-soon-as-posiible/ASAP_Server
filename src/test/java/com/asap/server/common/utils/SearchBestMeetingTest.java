package com.asap.server.common.utils;

import com.asap.server.service.vo.AvailableDateVo;
import com.asap.server.service.vo.BestMeetingTimeVo;
import com.asap.server.service.vo.TimeBlockVo;
import com.asap.server.service.vo.UserVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static com.asap.server.domain.enums.TimeSlot.SLOT_11_00;
import static com.asap.server.domain.enums.TimeSlot.SLOT_11_30;
import static com.asap.server.domain.enums.TimeSlot.SLOT_12_00;
import static com.asap.server.domain.enums.TimeSlot.SLOT_12_30;
import static com.asap.server.domain.enums.TimeSlot.SLOT_13_00;
import static com.asap.server.domain.enums.TimeSlot.SLOT_13_30;
import static com.asap.server.domain.enums.TimeSlot.SLOT_14_00;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchBestMeetingTest {
    private BestMeetingUtil bestMeetingUtil;

    @BeforeEach
    void setUp() {
        bestMeetingUtil = new BestMeetingUtil();
    }

    @Test
    @DisplayName("모든 유저들이 특정 날짜에 회의 시간이 가능할 경우")
    public void getBestMeetingTime() {
        // given
        LocalDate meetingDate = LocalDate.of(2023, 9, 8);
        AvailableDateVo availableDate = new AvailableDateVo(1L, meetingDate);

        UserVo kwy = new UserVo(1L, "KWY");
        UserVo dsy = new UserVo(1L, "DSY");
        List<UserVo> users = List.of(kwy, dsy);

        TimeBlockVo timeBlock = new TimeBlockVo(1L, 0, availableDate, SLOT_11_00, users);
        TimeBlockVo timeBlock2 = new TimeBlockVo(1L, 0, availableDate, SLOT_11_30, users);
        TimeBlockVo timeBlock3 = new TimeBlockVo(1L, 0, availableDate, SLOT_12_00, users);
        TimeBlockVo timeBlock4 = new TimeBlockVo(1L, 0, availableDate, SLOT_12_30, users);
        TimeBlockVo timeBlock5 = new TimeBlockVo(1L, 0, availableDate, SLOT_13_00, users);
        TimeBlockVo timeBlock6 = new TimeBlockVo(1L, 0, availableDate, SLOT_13_30, users);
        TimeBlockVo timeBlock7 = new TimeBlockVo(1L, 0, availableDate, SLOT_14_00, users);
        List<TimeBlockVo> timeBlocks = List.of(timeBlock, timeBlock2, timeBlock3, timeBlock4, timeBlock5, timeBlock6, timeBlock7);

        BestMeetingTimeVo bestMeetingTime = new BestMeetingTimeVo(SLOT_11_00, SLOT_13_00, users);
        BestMeetingTimeVo bestMeetingTime2 = new BestMeetingTimeVo(SLOT_11_30, SLOT_13_30, users);
        BestMeetingTimeVo bestMeetingTime3 = new BestMeetingTimeVo(SLOT_12_00, SLOT_14_00, users);
        List<BestMeetingTimeVo> bestMeetingTimes = List.of(bestMeetingTime, bestMeetingTime2, bestMeetingTime3);

        // when
        List<BestMeetingTimeVo> result = bestMeetingUtil.getBestMeetingTime(timeBlocks);

        // then
        assertThat(result).isEqualTo(bestMeetingTimes);
    }
}
