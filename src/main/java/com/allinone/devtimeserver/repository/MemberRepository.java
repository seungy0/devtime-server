package com.allinone.devtimeserver.repository;

import com.allinone.devtimeserver.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member user);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
