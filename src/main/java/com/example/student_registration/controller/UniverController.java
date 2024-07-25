package com.example.student_registration.controller;

import com.example.student_registration.DTO.UniverDto;
import com.example.student_registration.service.UniverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UniverController {

    public final UniverService univerService;

    @GetMapping("/univers")
    public String univers(Model model){
        model.addAttribute("univers", univerService.getUnivers());
        return "univer/univer-main";
    }

    @GetMapping("/univer/{id}")
    public String univerInfo(@PathVariable Long id, Model model){
        model.addAttribute("univer", univerService.getUniverById(id));
        return "univer/univer-info";
    }

    @PostMapping("/univer/create")
    public String createUniver(UniverDto univerDto){
        univerService.addUniver(univerDto);
        return "redirect:/univers";
    }

    @PostMapping("/univer/delete/{id}")
    public String deleteUniver(@PathVariable Long id){
        univerService.deleteUniver(id);
        return "redirect:/";
    }

    @GetMapping("univer/univer/update/{id}")
    public String updateUniverForm(@PathVariable Long id, Model model){
        model.addAttribute("univer", univerService.getUniverById(id));
        return "univer/univer-update";
    }

    @PostMapping("univer/univer/update/{id}")
    public String updateUniver(@PathVariable Long id, UniverDto univerDto){
        univerService.updateUniver(id, univerDto);
        return "redirect:/";
    }

}
