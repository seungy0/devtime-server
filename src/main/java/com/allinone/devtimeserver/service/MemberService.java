package com.allinone.devtimeserver.service;

import com.allinone.devtimeserver.domain.Member;
import com.allinone.devtimeserver.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
            this.memberRepository = memberRepository;
    }

    public Member join(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
