package HW7.controllers;

import HW7.dto.StudentDto;
import HW7.entity.Student;
import HW7.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;


@Controller
//@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public StudentDto findById(@PathVariable Integer id) {
        return studentService.findStudentDtoById(id).orElseThrow(() -> new RuntimeException("Student not found!!!"));
    }

    @GetMapping("/addform")
    public String getSaveStudent(Model model){
        model.addAttribute("student", new Student());
        return "add_student";
    }

    @PostMapping("/addstudent")
    public String saveStudent(Student student) {
        studentService.save(student);
        return "redirect:/api/v1/students/addform";
    }

    @GetMapping("/updform")
    public String getUpdateStudent(Model model){
        model.addAttribute("student", new Student());
        return "update_student";
    }

    @PostMapping("/updatestudent")
    public String updateStudent(Student student) {
        studentService.save(student);
        return "redirect:/api/v1/students/updform";
    }

//    @PutMapping
//    public Student updateStudent(@RequestBody Student student) {
//        return studentService.save(student);
//    }

    @PostMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable Integer id) {
        studentService.deleteById(id);
        return "redirect:/api/v1/students";
    }

    @GetMapping
    public String findAllProducts(Model model,
                                  @RequestParam MultiValueMap<String, String> params,
                                  @RequestParam(name = "p", defaultValue = "1") Integer page
    ) {
        if (page < 1) {
            page = 1;
        }
        model.addAttribute("students", studentService.findAll(page, 30));
        return "index";
    }
}
