package services;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Optional;

public class LoginServiceImplement implements LoginService {
    @Override
    public Optional<String> getUsername(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies()!=null? request.getCookies():new Cookie[0];
        return Arrays.stream(cookies)
                .filter(c->"username".equals(c.getName()))
                //convertimos la cookie a tipo String
                .map(Cookie::getName)
                .findAny();
    }
}
