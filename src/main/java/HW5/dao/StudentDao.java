package HW5.dao;

import HW5.entity.Student;
import HW5.util.SessionFactoryClass;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class StudentDao {

    private EntityManager em = SessionFactoryClass.entityManagerFactory().createEntityManager();

    public Optional<Student> findByID(Integer id){
        return Optional.ofNullable(em.find(Student.class, id));
    }

    public List<Student> findAllStudents() {
        Query query = em.createQuery("SELECT s FROM Student s");
        return query.getResultList();
    }

    public void updateStudent(Student student) {
        if (student.getId() != null){
            Optional<Student> optional = findByID(student.getId());
            if (optional.isPresent()){
                try {
                    em.getTransaction().begin();
                    em.merge(student);
                    em.getTransaction().commit();
                } catch (Exception e){
                    em.getTransaction().rollback();
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void saveStudent(Student student){
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }

    public void deleteByID(Integer id){
        Optional<Student> student = findByID(id);
        if (student.isPresent()){
            em.getTransaction().begin();
            em.remove(student.get());
            em.getTransaction().commit();
        }
    }

}
