package reports.generator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/view")
public class TestController {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, ModelMap model) {
        model.addAttribute("name", name);
        System.out.println("GRETTINGS, "+ name +"................!");
        String sql = "SELECT * FROM client_aloc";

        List total = jdbcTemplate.queryForList(sql);

        for(Object l: total){
            System.out.println(l);

        }
        return "welcome";
    }


   /* @RequestMapping("/welcome")
    public String greeting() {
        return "welcome";
    }*/
}