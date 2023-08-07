package org.sid.secservice;

import org.sid.secservice.entities.AppRole;
import org.sid.secservice.entities.AppUser;
import org.sid.secservice.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;

@SpringBootApplication
@EnableAsync
public class SecServiceApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(SecServiceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

/*    @Bean
   CommandLineRunner start(AccountService accountService){
        return args ->{
          accountService.addNewRole(new AppRole(null,"RH_SEGMENT",null));
           accountService.addNewRole(new AppRole(null,"ADMIN",null));
         accountService.addNewRole(new AppRole(null,"CHEF_SEGMENT",null));
           accountService.addNewRole(new AppRole(null,"RESPONSABLE_TRANSPORT",null));

           accountService.addNewUser(new AppUser(null,"null","user1",null,null,null,null,null,null,"8080",new ArrayList<>()));
           accountService.addNewUser(new AppUser(null,"null","admin",null,null,null,null,null,null,"8080",new ArrayList<>()));
        accountService.addNewUser(new AppUser(null,"null","user2",null,null,null,null,null,null,"8080",new ArrayList<>()));
           accountService.addNewUser(new AppUser(null,"null","user3",null,null,null,null,null,null,"8080",new ArrayList<>()));
         //  accountService.addNewUser(new AppUser(null,"null","user4",null,null,null,null,null,"8080",new ArrayList<>()));
           accountService.addRoleToUser("user1","RH_SEGMENT");
           accountService.addRoleToUser("admin","ADMIN");
        accountService.addRoleToUser("user2","CHEF_SEGMENT");
          accountService.addRoleToUser("admin","CUSTOMMER_MANAGER");
       accountService.addRoleToUser("user3","RESPONSABLE_TRANSPORT");
        accountService.addRoleToUser("user3","PRODUCT_MANAGER");
    //      accountService.addRoleToUser("user4","USER");
        //   accountService.addRoleToUser("user4","BILLS_MANAGER");

       };
}*/
}
