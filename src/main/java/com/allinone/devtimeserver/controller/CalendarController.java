package com.allinone.devtimeserver.controller;

import com.allinone.devtimeserver.domain.Calendar;
import com.allinone.devtimeserver.service.CalendarService;
import com.allinone.devtimeserver.service.MemberService;
import com.allinone.devtimeserver.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class CalendarController {

    private final CalendarService calendarService;
    private final MemberService memberService;
    private final ProjectService projectService;

    public CalendarController(CalendarService calendarService, MemberService memberService, ProjectService projectService) {
        this.calendarService = calendarService;
        this.memberService = memberService;
        this.projectService = projectService;
    }

    @PostMapping("/calendar/new")
    @ResponseBody
    public Calendar create(@RequestBody CalendarForm form) {
        Calendar calendar = new Calendar();
        memberService.findOne(form.getMemberId())
                .ifPresent(
                        m -> {
                            calendar.setMember(m);
                        });
        projectService.findOne(form.getProjectId())
                .ifPresent(
                        p -> {
                            calendar.setProject(p);
                        });
        calendar.setStartDate(form.getDate());
        calendar.setLanguage(form.getLanguage());

        if (calendar.getMember()!=null && calendar.getProject()!=null) {
            return calendarService.create(calendar);
        } else {
            return null;
        }
    }

    @GetMapping("/calendars")
    @ResponseBody
    public List<Calendar> list() {
        return calendarService.findAll();
    }

    @PostMapping("/calendar/end")
    @ResponseBody
    public Calendar end(@RequestBody CalendarForm form) {
        return calendarService.updateEndDate(form.getId(), form.getDate());
    }

    @GetMapping("/calendar/bydate")
    @ResponseBody
    public List<Calendar> listByDate(@RequestBody CalendarForm form) {
        Date tomorrow = new Date(form.getDate().getTime() + (1000 * 60 * 60 * 24));
        return calendarService.findAllByMemberIdAndStartDateBeforeAndEndDateAfter(form.getMemberId(), tomorrow, form.getDate());
    }
}
