package com.example.fieldpasserbe.member.repository;

import com.example.fieldpasserbe.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Entity;
import java.util.Optional;

public interface MemberRepositoryJPA extends JpaRepository<Member, Integer> {

    //id로 유저 찾기
    @Query("select m from Member m left join fetch m.admin where m.memberId = :id AND m.delete = 0")
    Optional<Member> findMemberByMemberId(@Param("id") int id);

    //이메일로 유저 찾기
    @Query("select m from Member m left join fetch m.admin where m.delete = 0 AND m.email = :email")
    Optional<Member> findMemberByEmail(@Param("email") String email);

    //이메일로 관리자 찾기
    @Query("select m from Member m join fetch m.admin where m.privilege = 1 AND m.email = :email")
    Optional<Member> findAdminByEmail(@Param("email") String email);

    //유저 방문 횟수 증가
    @Modifying(clearAutomatically = true)
    @Query("update Member m set m.visitCount = m.visitCount + 1 where m.memberId = :id")
    int updateVisitCount(@Param("id") int id);

    //전체 회원 조회
    @EntityGraph(attributePaths = {"admin"})
    @Query("select m from Member m where m.delete = 0")
    Page<Member> findAllMembers(Pageable pageable);
}