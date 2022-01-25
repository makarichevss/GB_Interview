package HW5;

import HW5.dao.StudentDao;
import HW5.entity.Student;

public class Main {

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();

        for (int i = 0; i < 1000; i++) {
            String name = "student_" + i;
            int mark = (int) ((Math.random() * 50) + 50);
            Student student = new Student(name, mark);
            studentDao.saveStudent(student);
        }

        Student student1 = new Student(4, "stud_11", 67);
        studentDao.updateStudent(student1);
        studentDao.deleteByID(2);
        studentDao.findByID(1).ifPresent(System.out::println);
        studentDao.findAllStudents().forEach(System.out::println);
    }
}
