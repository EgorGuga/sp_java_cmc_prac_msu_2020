package web.controller;


import Entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.controller.util.ClazzExtra;

import java.sql.Time;
import java.text.ParseException;
import java.util.List;

import static dao.src.ClazzDao.*;
import static dao.src.CourseDao.findCourseAll;
import static dao.src.CourseDao.findCourseById;
import static dao.src.LectureHallDao.findLectureHallAll;
import static dao.src.LectureHallDao.findLectureHallById;
import static dao.src.ProfessorDao.findProfessorAll;
import static dao.src.ProfessorDao.findProfessorById;
import static dao.src.SGroupDao.findSGroupById;
import static dao.src.SJournalDao.findSJournalById;
import static dao.src.SJournalDao.persistSJournal;
import static dao.src.StudentDao.*;
import static dao.src.WJournalDao.findWJournalById;
import static dao.src.WJournalDao.persistWJournal;

@Controller
@SessionAttributes("clazz")
@RequestMapping
public class TimetableEditorController {

    @RequestMapping(value = "/webapp/add_clazz", method = RequestMethod.GET)
    public ModelAndView addStudentClazz(Model model) {
        Clazz C = new Clazz();
        ClazzExtra CE = new ClazzExtra();
        CE.setClazz(C);
        List<LectureHall> LectureHallList = findLectureHallAll();
        List<Course> CourseList = findCourseAll();
        List<Professor> ProfessorList = findProfessorAll();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("add_clazz");
        mv.addObject("clazz", CE);
        mv.addObject("LectureHallList", LectureHallList);
        mv.addObject("CourseList", CourseList);
        mv.addObject("ProfessorList", ProfessorList);
        return mv;
    }

    @RequestMapping(value = "/webapp/add_clazz", method = RequestMethod.POST)
    public ModelAndView addClazz(@ModelAttribute("clazz") ClazzExtra CE) throws ParseException {
        ModelAndView mv = new ModelAndView();

        CE.getClazz().setLectureHallByLectureHallId(findLectureHallById(CE.getLectureHallId()));
        CE.getClazz().setProfessorByProfessorId(findProfessorById(CE.getProfessorId()));
        CE.getClazz().setCourseByCourseId(findCourseById(CE.getCourseId()));
        CE.getClazz().setStartTime(Time.valueOf(CE.getStartHour() + ":" + CE.getStartMinute() + ":00"));
        CE.getClazz().setEndTime(Time.valueOf(CE.getEndHour() + ":" + CE.getEndMinute() + ":00"));

        if (CE.getCourseId() == 0) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Не выбран курс");
            return mv;
        }
        if (CE.getProfessorId() == 0) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Не выбран преподаватель");
            return mv;
        }
        if (CE.getLectureHallId() == 0) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Не выбрана аудитория");
            return mv;
        }
        if (CE.getClazz().getDayOfTheWeek().equals("NONE")) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Не выбран день недели");
            return mv;
        }

        if (CE.getClazz().getStartTime().after(CE.getClazz().getEndTime())) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Время оконачания раньше времени начала");
            return mv;
        }

        if (findWJournalById(CE.getCourseId(), CE.getProfessorId()) == null) {
            WJournal WJ = new WJournal();
            WJ.setProfessorId(CE.getProfessorId());
            WJ.setCourseId(CE.getCourseId());
            WJ.setProfessorByProfessorId(findProfessorById(CE.getProfessorId()));
            WJ.setCourseByCourseId(findCourseById(CE.getCourseId()));
            persistWJournal(WJ);
        }

        persistClazz(CE.getClazz());
        mv.setViewName("redirect:/webapp/success");
        mv.addObject("status", "Занятие добавлено");
        return mv;
    }

    @RequestMapping(value = "/webapp/edit_clazz/{id}", method = RequestMethod.GET)
    public ModelAndView editClazz(@PathVariable("id") long Id) {
        Clazz C = findClazzById(Id);
        ClazzExtra CE = new ClazzExtra();
        CE.setClazz(C);
        List<LectureHall> LectureHallList = findLectureHallAll();
        List<Course> CourseList = findCourseAll();
        List<Professor> ProfessorList = findProfessorAll();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("edit_clazz");
        mv.addObject("clazz", CE);
        mv.addObject("LectureHallList", LectureHallList);
        mv.addObject("CourseList", CourseList);
        mv.addObject("ProfessorList", ProfessorList);
        return mv;
    }

    @RequestMapping(value = "/webapp/edit_clazz", method = RequestMethod.POST)
    public ModelAndView editClazz(@ModelAttribute("clazz") ClazzExtra CE) {
        ModelAndView mv = new ModelAndView();

        CE.getClazz().setLectureHallByLectureHallId(findLectureHallById(CE.getLectureHallId()));
        CE.getClazz().setProfessorByProfessorId(findProfessorById(CE.getProfessorId()));
        CE.getClazz().setCourseByCourseId(findCourseById(CE.getCourseId()));

        if (CE.getClazz().getStartTime().after(CE.getClazz().getEndTime())) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Время оконачания раньше времени начала");
            return mv;
        }

        if (findWJournalById(CE.getCourseId(), CE.getProfessorId()) == null) {
            WJournal WJ = new WJournal();
            WJ.setProfessorId(CE.getProfessorId());
            WJ.setCourseId(CE.getCourseId());
            WJ.setProfessorByProfessorId(findProfessorById(CE.getProfessorId()));
            WJ.setCourseByCourseId(findCourseById(CE.getCourseId()));
            persistWJournal(WJ);
        }

        updateClazz(CE.getClazz());
        mv.setViewName("redirect:/webapp/success");
        mv.addObject("status", "Занятие изменено");
        return mv;
    }

    @RequestMapping(value = "/webapp/delete_clazz/{id}", method = RequestMethod.GET)
    public ModelAndView deleteClazz(@PathVariable("id") long Id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/webapp/timetable");
        deleteClazzById(Id);
        return mv;
    }

    @RequestMapping(value = "/webapp/timetable/student/{studentId}/apply_clazz", method = RequestMethod.GET)
    public ModelAndView applyStudentClazz(Model model, @PathVariable("studentId") long Id) {
        List<Clazz> ClazzList = findClazzAll();
        Clazz clazz = new Clazz();
        for(int i = ClazzList.size() - 1 ; i >= 0; i--) {
            if ((ClazzList.get(i).getCourseByCourseId().getCoverage().equals("Поток")) || (ClazzList.get(i).getCourseByCourseId().getCoverage().equals("Группа"))) {
                ClazzList.remove(i);
            }
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("apply_clazz");
        mv.addObject("ClazzList", ClazzList);
        mv.addObject("clazz", clazz);
        return mv;
    }

    @RequestMapping(value = "/webapp/timetable/student/{studentId}/apply_clazz", method = RequestMethod.POST)
    public ModelAndView applyStudentClazz(@ModelAttribute("clazz") Clazz C, @PathVariable("studentId") long Id) {
        ModelAndView mv = new ModelAndView();
        if (C.getClassId() == 0) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Не выбрано занятие");
            return mv;
        }
        if (findSJournalById(C.getClassId(), Id) == null) {
            SJournal SJ = new SJournal();
            SJ.setClassId(C.getClassId());
            SJ.setClassByClassId(findClazzById(C.getClassId()));
            SJ.setStudentId(Id);
            SJ.setStudentByStudentId(findStudentById(Id));
            persistSJournal(SJ);
            mv.setViewName("redirect:/webapp/success");
            mv.addObject("status", "Занятие добавлено в расписание");
        } else
        {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Занятие уже есть в расписании");
            return mv;
        }
        return mv;
    }

    @RequestMapping(value = "/webapp/timetable/group/{groupId}/apply_clazz", method = RequestMethod.GET)
    public ModelAndView applyGroupClazz(Model model, @PathVariable("groupId") long Id) {
        List<Clazz> ClazzList = findClazzAll();
        Clazz clazz = new Clazz();

        for(int i = ClazzList.size() - 1 ; i >= 0; i--) {
            if ((ClazzList.get(i).getCourseByCourseId().getCoverage().equals("Поток")) || (ClazzList.get(i).getCourseByCourseId().getCoverage().equals("Спец. курс"))) {
                ClazzList.remove(i);
            }
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("apply_clazz");
        mv.addObject("ClazzList", ClazzList);
        mv.addObject("clazz", clazz);
        return mv;
    }

    @RequestMapping(value = "/webapp/timetable/group/{groupId}/apply_clazz", method = RequestMethod.POST)
    public ModelAndView applyFlowClazz(@ModelAttribute("clazz") Clazz C, @PathVariable("groupId") long Id) {
        ModelAndView mv = new ModelAndView();
        if (C.getClassId() == 0) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Не выбрано занятие");
            return mv;
        }
        List<Student> StudentList = findStudentByGroup(findSGroupById(Id).getGroupNumber());
        for (Student student : StudentList) {
            if (findSJournalById(C.getClassId(), student.getStudentId()) == null) {
                SJournal SJ = new SJournal();
                SJ.setClassId(C.getClassId());
                SJ.setClassByClassId(findClazzById(C.getClassId()));
                SJ.setStudentId(student.getStudentId());
                SJ.setStudentByStudentId(student);
                persistSJournal(SJ);
            }
        }
        mv.setViewName("redirect:/webapp/success");
        mv.addObject("status", "Занятие добавлено в расписание");
        return mv;
    }

    @RequestMapping(value = "/webapp/timetable/course/{course}/flow/{flow}/apply_clazz", method = RequestMethod.GET)
    public ModelAndView applyGroupClazz(Model model, @PathVariable("course") int c, @PathVariable("flow") int f) {
        List<Clazz> ClazzList = findClazzAll();
        Clazz clazz = new Clazz();

        for(int i = ClazzList.size() - 1 ; i >= 0; i--) {
            if ((ClazzList.get(i).getCourseByCourseId().getCoverage().equals("Группа")) || (ClazzList.get(i).getCourseByCourseId().getCoverage().equals("Спец. курс")) || (ClazzList.get(i).getCourseByCourseId().getYearOfStudy() != c)) {
                ClazzList.remove(i);
            }

        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("apply_clazz");
        mv.addObject("ClazzList", ClazzList);
        mv.addObject("clazz", clazz);
        return mv;
    }

    @RequestMapping(value = "/webapp/timetable/course/{course}/flow/{flow}/apply_clazz", method = RequestMethod.POST)
    public ModelAndView applyFlowClazz(@ModelAttribute("clazz") Clazz C, @PathVariable("course") int c, @PathVariable("flow") int f) {
        ModelAndView mv = new ModelAndView();
        if (C.getClassId() == 0) {
            mv.setViewName("redirect:/webapp/failure");
            mv.addObject("error", "Не выбрано занятие");
            return mv;
        }
        List<Student> StudentList = findStudentByYOSAndFlow(c, f);
        for (Student student : StudentList) {
            if (findSJournalById(C.getClassId(), student.getStudentId()) == null) {
                SJournal SJ = new SJournal();
                SJ.setClassId(C.getClassId());
                SJ.setClassByClassId(findClazzById(C.getClassId()));
                SJ.setStudentId(student.getStudentId());
                SJ.setStudentByStudentId(student);
                persistSJournal(SJ);
            }
        }
        mv.setViewName("redirect:/webapp/success");
        mv.addObject("status", "Занятие добавлено в расписание");
        return mv;
    }
}
