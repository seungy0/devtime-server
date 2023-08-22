package com.allinone.devtimeserver.repository;

import com.allinone.devtimeserver.domain.Calendar;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CalendarRepository {
    Calendar save(Calendar calendar);
    Optional<Calendar> findById(Long id);
    Optional<Calendar> findByMemberId(Long memberId);
    Optional<Calendar> findByProjectId(Long projectId);
    Optional<Calendar> findByLanguage(String language);
    List<Calendar> findAll();
    List<Calendar> findByMemberIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(Long memberId, Date startDate, Date endDate);
}
