
import com.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Driver {

    public static void main(String[] args) {



        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        Student student = new Student();
        student.setName("Derick");
        student.setTeacher("Mr. Walker");
        student.setGradeLevel(6);

        entitymanager.persist(student);
        entitymanager.getTransaction().commit();

        entitymanager.close();
        emfactory.close();
    }
}



