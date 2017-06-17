package sjph.life.web.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author shaohuiguo
 *
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse res) {
        System.out.println("/login-------Work hard, Good luck!");
        return "Login";
    }

    /**
     * @param request
     * @param res
     * @return
     */
    @RequestMapping(value = "/loginSubmit", method = RequestMethod.POST)
    public ModelAndView loginSubmit(HttpServletRequest request, HttpServletResponse res) {
        System.out.println("Work hard, Good luck!");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println("password: " + password);
        if (password.equals("admin")) {
            String message = name;
            return new ModelAndView("Greeting", "name", message);
        }
        else {
            return new ModelAndView("errorpage", "message", "Sorry, username or password error");
        }
    }
}