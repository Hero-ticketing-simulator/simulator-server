package termproject.heroticketing.performance.controller;

import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import termproject.heroticketing.performance.dto.PerformanceForm;
import termproject.heroticketing.performance.dto.PerformanceResponse;
import termproject.heroticketing.performance.service.PerformanceService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/performances")
public class PerformanceController {

    private final PerformanceService performanceService;

    @GetMapping("")
    public String showAll(Model model) {
        List<PerformanceResponse> result = performanceService.showAll();
        model.addAttribute("performances", result);
        return "performance";
    }

    @GetMapping("/add")
    public String performanceForm() {
        return "/addPerformace-form";
    }

    @PostMapping("/add")
    public String savePerformance(@ModelAttribute PerformanceForm form) {
        performanceService.savePerformance(form);
        return "redirect:/performances";
    }

    @GetMapping("/{id}")
    public String editPerformanceForm(@PathVariable("id") Long id) {
        return "addPerformance-form";
    }

    @PutMapping("/{id}")
    public String editPerformance(@ModelAttribute PerformanceForm form) {
        PerformanceForm editForm = performanceService.editPerformance(form);
        return "reidrect:/addPerformance-form";
    }

    @DeleteMapping("/{id}")
    public String deletePerformance(@PathVariable("id") Long id) {
        performanceService.deletePerformance(id);
        return "redirect:/performances";
    }
}
