/*
//КОД КОНТРОЛЛЕРА

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
}

//HOME.HTML
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Home</title>
</head>
<body>
<h1>Hello World!</h1>
</body>
</html>

//LOGIN.HTML
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Login</title>
</head>
<body>
<h1>Login</h1>
<form method="post" action="/login">
<div>
<label for="username">Username:</label>
<input type="text" id="username" name="username" />
</div>
<div>
<label for="password">Password:</label>
<input type="password" id="password" name="password" />
</div>
<button type="submit">Login</button>
</form>
</body>
</html>

//SECURITY CONFIG
        import org.springframework.context.annotation.Configuration;
        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
        import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessURL("/")
                .permitAll();
    }
}*/
