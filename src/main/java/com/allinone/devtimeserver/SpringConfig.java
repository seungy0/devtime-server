package com.allinone.devtimeserver;

import com.allinone.devtimeserver.repository.CalendarRepository;
import com.allinone.devtimeserver.repository.MemberRepository;
import com.allinone.devtimeserver.repository.ProjectRepository;
import com.allinone.devtimeserver.service.CalendarService;
import com.allinone.devtimeserver.service.MemberService;
import com.allinone.devtimeserver.service.ProjectService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final CalendarRepository calendarRepository;
    private final MemberRepository memberRepository;
    private final ProjectRepository projectRepository;


    public SpringConfig(CalendarRepository calendarRepository, MemberRepository memberRepository, ProjectRepository projectRepository) {
        this.calendarRepository = calendarRepository;
        this.memberRepository = memberRepository;
        this.projectRepository = projectRepository;
    }

    @Bean
    public CalendarService calendarService() {
        return new CalendarService(calendarRepository);
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    @Bean
    public ProjectService projectService() {
        return new ProjectService(projectRepository);
    }


}
