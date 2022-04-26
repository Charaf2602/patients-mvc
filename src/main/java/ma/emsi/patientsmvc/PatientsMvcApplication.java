package ma.emsi.patientsmvc;

import ma.emsi.patientsmvc.entities.Patient;
import ma.emsi.patientsmvc.repositories.PatientRepository;
import ma.emsi.patientsmvc.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {

        SpringApplication.run(PatientsMvcApplication.class, args);
        
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {

            patientRepository.save(
                    new Patient(null,"Hassan",new Date(),false,100));
            patientRepository.save(
                    new Patient(null,"Mohammed",new Date(),true,120));
            patientRepository.save(
                    new Patient(null,"Amine",new Date(),true,250));
            patientRepository.save(
                    new Patient(null,"Mouad",new Date(),false,340));

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };

    }
    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
           /* securityService.saveNewUser("anas","1234","1234");
            securityService.saveNewUser("hamza","1234","1234");
            securityService.saveNewUser("zakaria","1234","1234");
            securityService.saveNewUser("amine","1234","1234");
            */


           /* securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");*/

            /*securityService.addRoleToUser("anas","ADMIN");
            securityService.addRoleToUser("anas","USER");
            securityService.addRoleToUser("hamza","USER");
            securityService.addRoleToUser("zakaria","USER");
            securityService.addRoleToUser("amine","USER");
*/


        };

    };
}
