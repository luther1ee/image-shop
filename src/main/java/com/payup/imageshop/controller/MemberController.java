package com.payup.imageshop.controller;

import com.payup.imageshop.domain.Member;
import com.payup.imageshop.dto.CodeLabelValue;
import com.payup.imageshop.service.CodeService;
import com.payup.imageshop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class MemberController {
    @Autowired
    private MemberService service;

    @Autowired
    private CodeService codeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public void registerForm(Member member, Model model) throws Exception {
        String classCode = "A01";
        List<CodeLabelValue> jobList = codeService.getCodeList(classCode);

        model.addAttribute("jobList", jobList);
    }

}
