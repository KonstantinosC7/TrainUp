package TraineeshipApplication.config;

import TraineeshipApplication.dao.CompanyDAORepository;
import TraineeshipApplication.dao.ProfessorDAORepository;
import TraineeshipApplication.dao.StudentDAORepository;
import TraineeshipApplication.dao.UserDAORepository;
import TraineeshipApplication.model.Company;
import TraineeshipApplication.model.Professor;
import TraineeshipApplication.model.Role;
import TraineeshipApplication.model.Student;
import TraineeshipApplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private UserDAORepository userRepository;
    
    @Autowired
    private StudentDAORepository studentRepository;
    @Autowired
    private CompanyDAORepository companyRepository;
    @Autowired
    private ProfessorDAORepository professorRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
    	if (userRepository.findByUsername("committee").isEmpty()) {
            User committeeUser = new User();
            committeeUser.setUsername("committee");
            committeeUser.setEmail("committee@trainup.com");  // Προσθήκη email για μοναδικότητα
            committeeUser.setPassword(passwordEncoder.encode("Committee1!"));
            committeeUser.setRole(Role.TRAINEESHIP_COMMITTEE); // Χρήση Enum αντί String
            committeeUser.setEmailVerified(true); // Προαιρετικά το ορίζουμε ως verified
            userRepository.save(committeeUser);
        }
        if (userRepository.findByUsername("cs04491").isEmpty()) {
            User stdUser = new User();
            stdUser.setUsername("cs04491");
            stdUser.setEmail("student@trainup.com");  // Προσθήκη email για μοναδικότητα
            stdUser.setPassword(passwordEncoder.encode("B!ll2000"));
            stdUser.setRole(Role.STUDENT); // Χρήση Enum αντί String
            stdUser.setEmailVerified(true); // Προαιρετικά το ορίζουμε ως verified
            userRepository.save(stdUser);
            Student std = new Student();
            std.setUser(stdUser);
            studentRepository.save(std);
        }
        if (userRepository.findByUsername("cs04733").isEmpty()) {
            User compUser = new User();
            compUser.setUsername("cs04733");
            compUser.setEmail("company@trainup.com");  // Προσθήκη email για μοναδικότητα
            compUser.setPassword(passwordEncoder.encode("B!ll2000"));
            compUser.setRole(Role.COMPANY); // Χρήση Enum αντί String
            compUser.setEmailVerified(true); // Προαιρετικά το ορίζουμε ως verified
            userRepository.save(compUser);
            Company cmp = new Company();
            cmp.setUser(compUser);
            companyRepository.save(cmp);
        }
        
        if (userRepository.findByUsername("cs04650").isEmpty()) {
            User profUser = new User();
            profUser.setUsername("cs04650");
            profUser.setEmail("professor@trainup.com");  // Προσθήκη email για μοναδικότητα
            profUser.setPassword(passwordEncoder.encode("B!ll2000"));
            profUser.setRole(Role.PROFESSOR); // Χρήση Enum αντί String
            profUser.setEmailVerified(true); // Προαιρετικά το ορίζουμε ως verified
            userRepository.save(profUser);
            Professor prof = new Professor();
            prof.setUser(profUser);
            professorRepository.save(prof);
        }
    }
}
