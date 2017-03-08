package com.gurkan.web;

import com.gurkan.entity.Department;
import com.gurkan.entity.Task;
import com.gurkan.entity.TaskDetail;
import com.gurkan.entity.User;
import com.gurkan.security.auth.JwtAuthenticationToken;
import com.gurkan.service.DatabaseDepartmentService;
import com.gurkan.service.DatabaseTaskDetailService;
import com.gurkan.service.DatabaseTaskService;
import com.gurkan.service.DatabaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gurkan.security.model.UserContext;

import java.util.Date;


@RestController
@RequestMapping("/api/v1")
public class AdminController {

    @Autowired
    public DatabaseUserService databaseUserService;

    @Autowired
    public DatabaseDepartmentService databaseDepartmentService;

    @Autowired
    public DatabaseTaskService databaseTaskService;

    @Autowired
    public DatabaseTaskDetailService databaseTaskDetailService;

    // --------------------------------------------------------------//

    /*
    *   description : Get Token Principal
    *   method      : GET
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/me", method=RequestMethod.GET)
    @ResponseBody
    public UserContext get(JwtAuthenticationToken token) {
        return (UserContext) token.getPrincipal();
    }



    // --------------------------------------------------------------//

    /*
    *   description : Create User
    *   method      : POST
    *   required    : String username
    *                 String password
    *   optional    : Integer price
    *                 Integer weeklyWorkingHours
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/user", method=RequestMethod.POST)
    @ResponseBody
    public User createUser(String username, String password, Integer price, Integer weeklyWorkingHours) {
        price = (price == null) ? 0 : price;
        weeklyWorkingHours = (weeklyWorkingHours == null) ? 0 : weeklyWorkingHours;
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        password = bCryptPasswordEncoder.encode(password);
        User user = new User(username, password, price, weeklyWorkingHours);
        return databaseUserService.getUserRepository().save(user);
    }

    /*
    *   description : Update User
    *   method      : PUT
    *   required    : String username
    *   optional    : String password
    *                 Integer price
    *                 Integer weeklyWorkingHours
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/user", method=RequestMethod.PUT)
    @ResponseBody
    public User updateUser(String username, String password, Integer price, Integer weeklyWorkingHours) {
        User user = getUser(username);
        if (user == null)
            return user;
        price = (price == null) ? user.getPrice() : price;
        weeklyWorkingHours = (weeklyWorkingHours == null) ? user.getWeeklyWorkingHours() : weeklyWorkingHours;
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        password = (password == null) ? user.getPassword() : bCryptPasswordEncoder.encode(password);

        user.setPrice(price);
        user.setWeeklyWorkingHours(weeklyWorkingHours);

        return databaseUserService.getUserRepository().save(user);
    }

    /*
    *   description : Get User
    *   method      : GET
    *   required    : String username
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/user", method=RequestMethod.GET)
    @ResponseBody
    public User getUser(String username) {
        return databaseUserService.getUserRepository().findByUsername(username).orElse(new User());
    }


    /*
    *   description : Delete User
    *   method      : DELETE
    *   required    : String username
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/user", method=RequestMethod.DELETE)
    @ResponseBody
    public User deleteUser(String username) {
        User user =  databaseUserService.getUserRepository().findByUsername(username).orElse(new User());
        if (user.getId() != null)
            databaseUserService.getUserRepository().delete(user);
        return user;
    }


    // --------------------------------------------------------------//

    /*
    *   description : Get Department
    *   method      : GET
    *   required    : String name
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/department", method=RequestMethod.GET)
    @ResponseBody
    public Department getDepartment(String name) {
        return databaseDepartmentService.findByName(name).orElse(new Department());
    }

    /*
    *   description : Delete Department
    *   method      : DELETE
    *   required    : String name
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/department", method=RequestMethod.DELETE)
    @ResponseBody
    public Department deleteDepartment(String name) {
        Department department = databaseDepartmentService.findByName(name).orElse(new Department());
        if (department != null)
            databaseDepartmentService.delete(department);
        return department;
    }

    /*
    *   description : Create Department
    *   method      : POST
    *   required    : String name
    *                 int    startDay
    *                 int    endDay
    *                 int    startHour
    *                 int    endHour
    *                 int    startMinute
    *                 int    endMinute
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/department", method=RequestMethod.POST)
    @ResponseBody
    public Department createDepartment(String name, Integer startDay, Integer endDay, Integer startHour, Integer endHour, Integer startMinute, Integer endMinute) {

        if (name != null && startDay != null && endDay != null && startHour != null && endHour != null && startMinute != null && endMinute != null)
            return databaseDepartmentService.save(new Department(name, startHour, endHour, startMinute, endMinute, startDay, endDay));
        return new Department();
    }

    /*
    *   description : Update Department
    *   method      : PUT
    *   required    : String name
    *   optional    : int    startDay
    *                 int    endDay
    *                 int    startHour
    *                 int    endHour
    *                 int    startMinute
    *                 int    endMinute
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/department", method=RequestMethod.PUT)
    @ResponseBody
    public Department updateDepartment(String name, Integer startDay, Integer endDay, Integer startHour, Integer endHour, Integer startMinute, Integer endMinute) {
        Department department = databaseDepartmentService.findByName(name).orElse(new Department());
        if (department == null)
            return department;

        if (startDay != null)  department.setStartDays(startDay);
        if (endDay != null )   department.setEndDays(endDay);
        if (startHour != null) department.setStartHour(startHour);
        if (endHour != null)   department.setEndHour(endHour);
        if (startMinute != null) department.setStartMinute(startMinute);
        if (endMinute != null)  department.setEndMinute(endMinute);

        return department;
    }


    // --------------------------------------------------------------//

    /*
    *   description : Get Task
    *   method      : GET
    *   required    : String name
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/task", method=RequestMethod.GET)
    @ResponseBody
    public Task getTask(String name) {
        return databaseTaskService.findByName(name).orElse(new Task());
    }

    /*
    *   description : Create Task
    *   method      : POST
    *   required    : String  name
    *                 String  description
    *                 date    startDate
    *                 date    endDate
    *
    *   optional    : boolean isComplete, default:false
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/task", method=RequestMethod.POST)
    @ResponseBody
    public Task createTask(String name, String description, Boolean isComplate, Date startDate, Date endDate) {

        if (name != null && description != null && startDate != null && endDate != null) {
            Boolean isComp = isComplate == true;
            return databaseTaskService.save(new Task(name, description, isComp, startDate, endDate ));
        }
        return new Task();
    }

    /*
    *   description : Update Task
    *   method      : PUT
    *   required    : String  name
    *
    *   optional    : String  description
    *                 date    startDate
    *                 date    endDate
    *                 boolean isComplete
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/task", method=RequestMethod.PUT)
    @ResponseBody
    public Task updateTask(String name, String description, Boolean isComplate, Date startDate, Date endDate) {

        Task task = databaseTaskService.findByName(name).orElse(new Task());
        if (task == null)
            return task;

        if (description != null)  task.setDescription(description);
        if (isComplate != null )   task.setComplete(isComplate);
        if (startDate != null) task.setStartDate(startDate);
        if (endDate != null)   task.setEndDate(endDate);

        return task;
    }

    /*
    *   description : Delete Task
    *   method      : DELETE
    *   required    : String name
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/task", method=RequestMethod.DELETE)
    @ResponseBody
    public Task deleteTask(String name) {
        Task task = databaseTaskService.findByName(name).orElse(new Task());
        if (task != null)
            databaseTaskService.delete(task);
        return task;
    }

    // --------------------------------------------------------------//

    /*
    *   description : Get Task Detail
    *   method      : GET
    *   required    : Long id
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/task-detail", method=RequestMethod.GET)
    @ResponseBody
    public TaskDetail getTaskDetail(Long id) {
        return databaseTaskDetailService.findOne(id);
    }


    /*
    *   description : Delete Task Detail
    *   method      : DELETE
    *   required    : Long id
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/task-detail", method=RequestMethod.DELETE)
    @ResponseBody
    public TaskDetail deleteTaskDetail(Long id) {
        TaskDetail taskDetail =  databaseTaskDetailService.findOne(id);
        if (taskDetail != null)
            databaseTaskDetailService.delete(taskDetail);
        return taskDetail;
    }

    /*
    *   description : Create Task Detail
    *   method      : POST
    *   required    : Long id
    *                 String message
    *                 Date date
    *
    *   optional    : int time
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/task-detail", method=RequestMethod.POST)
    @ResponseBody
    public TaskDetail createTaskDetail(Long id, String message, Date date, Integer time) {

        if (id != null && message != null && date != null) {
            time = (time == null) ? 0 : time;
            return databaseTaskDetailService.save(new TaskDetail(message, date, time));
        }
        return new TaskDetail();
    }

    /*
    *   description : Create Task Detail
    *   method      : POST
    *   required    : Long id
    *
    *   optional    : String message
    *                 Date date
    *                 int time
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/task-detail", method=RequestMethod.PUT)
    @ResponseBody
    public TaskDetail updateTaskDetail(Long id, String message, Date date, Integer time) {

        TaskDetail taskDetail = databaseTaskDetailService.findOne(id);

        if (taskDetail == null)
            return taskDetail;

        if (message != null)  taskDetail.setMessage(message);
        if (date != null )   taskDetail.setDate(date);
        if (time != null) taskDetail.setTime(time);

        return taskDetail;
    }

    // --------------------------------------------------------------//

}
