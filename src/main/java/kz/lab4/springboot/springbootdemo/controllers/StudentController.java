package kz.lab4.springboot.springbootdemo.controllers;


import kz.lab4.springboot.springbootdemo.models.Student;
import kz.lab4.springboot.springbootdemo.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    private final StudentService studentService;

    //omdat addStudentMark niet static is:
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add-student"; //
    }

    @PostMapping("/add")
    public String addStudent(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "surname") String surname,
            @RequestParam(name = "exam") int exam) {
        Student s = new Student();
        s.setName(name);
        s.setSurname(surname);
        s.setExam(exam);

        studentService.addStudent(s);



        return "redirect:/"; //terug naar vorige pagina, lijst dus

    }
}
