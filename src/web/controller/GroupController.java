package web.controller;

import Entities.SGroup;
import Entities.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static dao.src.SGroupDao.findSGroupAll;
import static dao.src.SGroupDao.findSGroupById;
import static dao.src.StudentDao.findStudentByGroup;

@Controller
@SessionAttributes("group")
@RequestMapping
public class GroupController {

    @RequestMapping(value = "/webapp/find_by_group", method = RequestMethod.GET)
    public ModelAndView Groups(Model model) {
        ModelAndView mv = new ModelAndView();
        List<SGroup> SGroupsList = findSGroupAll();
        SGroup SG = new SGroup();
        model.addAttribute("SGroupList", SGroupsList);
        mv.addObject("group", SG);
        mv.setViewName("find_by_group");
        return mv;
    }

    @RequestMapping(value = "/webapp/find_by_group", method = RequestMethod.POST)
    public ModelAndView FindGroup(@ModelAttribute("group") SGroup SG) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/webapp/group/" + SG.getGroupId());
        return mv;
    }

    @RequestMapping(value = "/webapp/group/{id}", method = RequestMethod.GET)
    public ModelAndView GetGroup(@PathVariable("id") int Id) {
        List<Student> StudentList = findStudentByGroup(findSGroupById(Id).getGroupNumber());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("group");
        mv.addObject("number", findSGroupById(Id).getGroupNumber());
        mv.addObject("Id", Id);
        mv.addObject("StudentList", StudentList);
        return mv;
    }
}
