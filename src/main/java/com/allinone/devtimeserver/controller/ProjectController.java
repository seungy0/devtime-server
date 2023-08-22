package com.allinone.devtimeserver.controller;

import com.allinone.devtimeserver.domain.Project;
import com.allinone.devtimeserver.service.MemberService;
import com.allinone.devtimeserver.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProjectController {

    private final MemberService memberService;
    private final ProjectService projectService;

    public ProjectController(MemberService memberService, ProjectService projectService) {
        this.memberService = memberService;
        this.projectService = projectService;
    }

    @PostMapping("/projects/new")
    @ResponseBody
    public Project create(@RequestBody ProjectForm form) {
        Project project = new Project();
        memberService.findOne(form.getMemberId())
                .ifPresent(
                        m -> {
                            project.setName(form.getName());
                            project.setMember(m);
                            projectService.create(project);
                        });
        return project;
    }
}
