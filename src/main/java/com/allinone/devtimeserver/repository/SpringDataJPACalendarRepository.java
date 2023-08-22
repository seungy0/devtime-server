package com.allinone.devtimeserver.repository;

import com.allinone.devtimeserver.domain.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJPACalendarRepository extends JpaRepository<Calendar, Long>, CalendarRepository {

}
