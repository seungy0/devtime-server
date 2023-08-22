package com.allinone.devtimeserver.controller;

import com.allinone.devtimeserver.domain.Member;
import com.allinone.devtimeserver.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/members/new")
    @ResponseBody
    public Member create(@RequestBody MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        member.setIsWorking(false);

        log.info("member name={}", form.getName());

        return memberService.join(member);
    }

    @GetMapping("/members")
    @ResponseBody
    public List<Member> list() {
        return memberService.findMembers();
    }
}
