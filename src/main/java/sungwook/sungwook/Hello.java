package sungwook.sungwook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Hello {

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String World(){
        return "world.html";
    }
}
