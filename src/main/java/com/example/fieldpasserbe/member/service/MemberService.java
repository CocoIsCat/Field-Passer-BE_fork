package com.example.fieldpasserbe.member.service;

import com.example.fieldpasserbe.member.entity.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findMemberById(int id);

    Optional<Member> findMemberByEmail(String email);

    Optional<Member> findAdminByEmail(String email) throws Exception;

    boolean updateVisitCount(int id);
}
