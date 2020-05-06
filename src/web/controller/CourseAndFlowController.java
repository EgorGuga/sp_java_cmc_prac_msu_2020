package web.controller;

import Entities.Flow;
import Entities.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.controller.util.CourseAndFlow;

import java.util.List;

import static dao.src.FlowDao.findFlowAll;
import static dao.src.StudentDao.findStudentByYOSAndFlow;

@Controller
@SessionAttributes("courseAndFlow")
@RequestMapping
public class CourseAndFlowController {

    @RequestMapping(value = "/webapp/find_by_course_and_flow", method = RequestMethod.GET)
    public ModelAndView Groups(Model model) {
        ModelAndView mv = new ModelAndView();
        List<Flow> FlowList = findFlowAll();
        CourseAndFlow CF = new CourseAndFlow();
        mv.addObject("courseAndFlow", CF);
        mv.setViewName("find_by_course_and_flow");
        return mv;
    }

    @RequestMapping(value = "/webapp/find_by_course_and_flow", method = RequestMethod.POST)
    public ModelAndView FindGroup(@ModelAttribute("courseAndFlow")  CourseAndFlow CF) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/webapp/course/" + CF.getCourse() + "/" + "flow/" + CF.getFlow());
        return mv;
    }

    @RequestMapping(value = "/webapp/course/{course}/flow/{flow}", method = RequestMethod.GET)
    public ModelAndView GetGroup(@PathVariable("course") int c, @PathVariable("flow") int f) {
        List<Student> StudentList = findStudentByYOSAndFlow(c, f);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("flow");
        mv.addObject("course", c);
        mv.addObject("flow", f);
        mv.addObject("StudentList", StudentList);
        return mv;
    }

}

