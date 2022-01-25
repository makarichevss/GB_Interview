package HW7.service;

import HW7.dto.StudentDto;
import HW7.entity.Student;
import HW7.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    public Optional<StudentDto> findStudentDtoById(Integer id) {
        return findById(id).map(StudentDto::new);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    public Page<StudentDto> findAll(int page, int pageSize) {
        return studentRepository.findAll(PageRequest.of(page - 1, pageSize)).map(StudentDto::new);
    }
}
