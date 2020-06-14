package com.payup.imageshop.controller;

import com.payup.imageshop.domain.CodeDetail;
import com.payup.imageshop.dto.CodeLabelValue;
import com.payup.imageshop.service.CodeDetailService;
import com.payup.imageshop.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/codedetail")
public class CodeDetailController {

    @Autowired
    private CodeDetailService codeDetailService;

    @Autowired
    private CodeService codeService;

    @GetMapping(value = "/register")
    public void registerForm(Model model) throws Exception {
        CodeDetail codeDetail = new CodeDetail();
        model.addAttribute(codeDetail);

        List<CodeLabelValue> groupCodeList = codeService.getCodeGroupList();
        model.addAttribute("groupCodeList", groupCodeList);
    }

    @PostMapping(value = "/register")
    public String register(CodeDetail codeDetail, RedirectAttributes rttr) throws Exception {
        codeDetailService.register(codeDetail);

        rttr.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/codedetail/list";
    }

    @GetMapping(value = "/list")
    public void list(Model model) throws Exception {
        model.addAttribute("list", codeDetailService.list());
    }

    @PostMapping(value = "/remove")
    public String remove(CodeDetail codeDetail, RedirectAttributes rttr) throws Exception {
        codeDetailService.remove(codeDetail);

        rttr.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/codedetail/list";
    }

    @GetMapping(value = "/modify")
    public void modifyForm(CodeDetail codeDetail, Model model) throws Exception {
        model.addAttribute(codeDetailService.read(codeDetail));

        List<CodeLabelValue> groupCodeList = codeService.getCodeGroupList();
        model.addAttribute("groupCodeList", groupCodeList);
    }

    @PostMapping(value = "/modify")
    public String modify(CodeDetail codeDetail, RedirectAttributes rttr) throws Exception {
        codeDetailService.modify(codeDetail);
        rttr.addFlashAttribute("msg", "SUCCESS");

        return "redirect:/codedetail/list";
    }
}
