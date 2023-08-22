package com.allinone.devtimeserver.service;

import com.allinone.devtimeserver.domain.Calendar;
import com.allinone.devtimeserver.repository.CalendarRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public class CalendarService {

    private final CalendarRepository calendarRepository;

    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public Calendar create(Calendar Calendar) {
        return calendarRepository.save(Calendar);
    }

    public List<Calendar> findAll() {
        return calendarRepository.findAll();
    }

    public Calendar updateEndDate(Long id, Date date) {
        Calendar calendar = calendarRepository.findById(id).get();
        calendar.setEndDate(date);
        return calendarRepository.save(calendar);
    }

    public List<Calendar> findAllByMemberIdAndStartDateBeforeAndEndDateAfter(Long memberId, Date startDate, Date endDate) {
        return calendarRepository.findByMemberIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(memberId, startDate, endDate);
    }
}
