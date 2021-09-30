package be.technobel.arlon2021mvc;

import be.technobel.arlon2021mvc.entities.User;
import be.technobel.arlon2021mvc.service.ServiceUser;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DbPopulator implements InitializingBean {
    private ServiceUser serviceUser;

    public DbPopulator(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        User user = new User();
        user.setId(0L);
        user.setUsername("ngaboGoss");
        user.setPassword("secret123!");
        User user2 = new User();
        user2.setId(0L);
        user2.setUsername("passy14");
        user2.setPassword("pwd123!");
        serviceUser.insert(user);
        serviceUser.insert(user2);
    }
}
