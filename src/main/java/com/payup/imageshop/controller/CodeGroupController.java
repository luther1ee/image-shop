package com.payup.imageshop.controller;

import com.payup.imageshop.domain.CodeGroup;
import com.payup.imageshop.service.CodeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/codegroup")
public class CodeGroupController {

    @Autowired
    private CodeGroupService service;

    @GetMapping(value = "/register")
    public void registerForm(Model model) throws Exception {
        CodeGroup codeGroup = new CodeGroup();

        model.addAttribute(codeGroup);
    }

    @PostMapping(value = "/register")
    public String register(CodeGroup codeGroup, RedirectAttributes rttr) throws Exception {
        service.register(codeGroup);

        rttr.addFlashAttribute("msg", "SUCCESS");

        return "redirect:/codeGroup/list";
    }

    @GetMapping(value = "/list")
    public void list(Model model) throws Exception {
        model.addAttribute("list", service.list());
    }

    @PostMapping(value = "/remove")
    public String remove(String groupCode, RedirectAttributes rttr) throws Exception {
        service.remove(groupCode);
        rttr.addFlashAttribute("msg", "SUCCESS");

        return "redirect:/codegroup/list";
    }

    @GetMapping(value = "/modify")
    public void modifyForm(String groupCode, Model model) throws Exception {
        model.addAttribute(service.read(groupCode));
    }

    @PostMapping(value = "/modify")
    public String modify(CodeGroup codeGroup, RedirectAttributes rttr) throws Exception {
        service.modify(codeGroup);
        rttr.addFlashAttribute("msg", "SUCCESS");

        return "redirect:/codegroup/list";
    }
}
