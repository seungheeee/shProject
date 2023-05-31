package com.example.demo.mapper;

import com.example.demo.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberDto> selectMemberList();
}
