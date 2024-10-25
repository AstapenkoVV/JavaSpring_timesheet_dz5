package ru.gb.timesheet.page;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.timesheet.service.TimesheetPageService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/home/timesheets")
@RequiredArgsConstructor
public class TimesheetPageController {
    public final TimesheetPageService service;

    @GetMapping
    public String getAllTimesheets(Model model) {
        List<TimesheetPageDto> timesheets = service.findAll();
        model.addAttribute("timesheets", timesheets);
        return "timesheets-page.html";
    }

    @GetMapping("/{id}")
    public String getTimesheetPage(@PathVariable Long id, Model model) {
        Optional<TimesheetPageDto> timesheetOpt = service.findById(id);
        if (timesheetOpt.isEmpty()){
            throw new NoSuchElementException();
        }
        model.addAttribute("timesheet", timesheetOpt.get());
        return "timesheet-page.html";
    }

    @GetMapping("/project/{id}")
    public String getProjectPage(@PathVariable Long id, Model model) {
        Optional<TimesheetPageDto> projectOpt = service.findById(id);
        if (projectOpt.isEmpty()){
            throw new NoSuchElementException();
        }
        model.addAttribute("project", projectOpt.get());
        return "project-page.html";
    }
}
