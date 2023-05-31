package com.example.demo.service;

import com.example.demo.dto.MemberDto;
import com.example.demo.mapper.MemberMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Resource
    MemberMapper memberMapper;

    public List<MemberDto> selectMemberList() throws Exception{
        return memberMapper.selectMemberList();
    }
}
