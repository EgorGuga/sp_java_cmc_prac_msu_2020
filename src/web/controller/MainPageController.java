package web.controller;

import Entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static dao.src.ClazzDao.findClazzAll;
import static dao.src.CourseDao.findCourseAll;
import static dao.src.LectureHallDao.findLectureHallAll;
import static dao.src.ProfessorDao.findProfessorAll;
import static dao.src.StudentDao.findStudentAll;

@Controller
public class MainPageController {

    @RequestMapping(value = "/webapp", method = RequestMethod.GET)
    public ModelAndView MainPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main");
        return mv;
    }

    @RequestMapping(value = "/webapp/courses", method = RequestMethod.GET)
    public ModelAndView Courses() {
        List<Course> CourseList = findCourseAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("courses");
        mv.addObject("CourseList", CourseList);
        return mv;
    }

    @RequestMapping(value = "/webapp/lecture_halls", method = RequestMethod.GET)
    public ModelAndView LectureHalls() {
        List<LectureHall> LectureHallList = findLectureHallAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("lecture_halls");
        mv.addObject("LectureHallList", LectureHallList);
        return mv;
    }

    @RequestMapping(value = "/webapp/professors", method = RequestMethod.GET)
    public ModelAndView AllProfessors() {
        List<Professor> ProfessorList = findProfessorAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("professors");
        mv.addObject("ProfessorList", ProfessorList);
        return mv;
    }

    @RequestMapping(value = "/webapp/students", method = RequestMethod.GET)
    public ModelAndView Students(Model model) {
        List<Student> StudentList = findStudentAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("students");
        mv.addObject("StudentList", StudentList);
        return mv;
    }

    @RequestMapping(value = "/webapp/timetable", method = RequestMethod.GET)
    public ModelAndView Timetable() {
        List<Clazz> ClazzList = findClazzAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("timetable");
        mv.addObject("ClazzList", ClazzList);
        return mv;
    }

    @RequestMapping(value = "/webapp/success", method = RequestMethod.GET)
    public ModelAndView Success(@RequestParam("status") String message) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        mv.addObject("message", message);
        return mv;
    }

    @RequestMapping(value = "/webapp/failure", method = RequestMethod.GET)
    public ModelAndView Failuure(@RequestParam("error") String message) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("failure");
        mv.addObject("message", message);
        return mv;
    }
}