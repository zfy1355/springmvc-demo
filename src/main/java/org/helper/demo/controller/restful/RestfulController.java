package org.helper.demo.controller.restful;

import org.helper.demo.entity.User;
import org.helper.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller()
@RequestMapping("/restful")
public class RestfulController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/list", method= RequestMethod.GET)
    @ResponseBody
    public List<User> getUserList() {
       return userService.getUserList();
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    @ResponseBody
    public Long createUser(@ModelAttribute User user) {
        return userService.createUser(user);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    @ResponseBody
    public User updateUser(@PathVariable Long id, @ModelAttribute User user) {
         return userService.updateUser(id,user);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public User deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
