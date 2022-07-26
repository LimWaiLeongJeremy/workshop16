package vttp2022ssf.workshop16.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class GameControllor {

    @RestController 
    @RequestMapping(path= "/api", produces= "application/json")
    public class UserRestController {

        @Autowired
        
        @GetMapping (path="/boardgame", produces= "application/json") 
        public String getUser(String userId) {
        }
    }
}
