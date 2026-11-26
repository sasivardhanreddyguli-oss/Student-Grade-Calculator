package com.example.gradecalculator;

import jakarta.validation.constraints.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GradeController {
    private final StudentResultRepository repository;
    private final GradeService gradeService;

    public GradeController(StudentResultRepository repository, GradeService gradeService) {
        this.repository = repository;
        this.gradeService = gradeService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("results", repository.findAll());
        model.addAttribute("form", new GradeForm());
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@ModelAttribute("form") GradeForm form,
                            BindingResult bindingResult,
                            Model model,
                            RedirectAttributes redirectAttributes) {
        if (form.getStudentName() == null || form.getStudentName().trim().isEmpty()) {
            bindingResult.rejectValue("studentName", "required", "Please enter a student name.");
        }
        validateMark(form.getSubject1(), "subject1", bindingResult);
        validateMark(form.getSubject2(), "subject2", bindingResult);
        validateMark(form.getSubject3(), "subject3", bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("results", repository.findAll());
            return "index";
        }

        StudentResult result = gradeService.createResult(
                form.getStudentName(), form.getSubject1(), form.getSubject2(), form.getSubject3());
        repository.save(result);
        redirectAttributes.addFlashAttribute("savedResult", result);
        return "redirect:/";
    }

    private void validateMark(Double mark, String field, BindingResult errors) {
        if (mark == null || mark < 0 || mark > 100) {
            errors.rejectValue(field, "invalid", "Enter a mark from 0 to 100.");
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }

    public static class GradeForm {
        private String studentName;
        private Double subject1;
        private Double subject2;
        private Double subject3;

        public String getStudentName() { return studentName; }
        public void setStudentName(String studentName) { this.studentName = studentName; }
        public Double getSubject1() { return subject1; }
        public void setSubject1(Double subject1) { this.subject1 = subject1; }
        public Double getSubject2() { return subject2; }
        public void setSubject2(Double subject2) { this.subject2 = subject2; }
        public Double getSubject3() { return subject3; }
        public void setSubject3(Double subject3) { this.subject3 = subject3; }
    }
}
