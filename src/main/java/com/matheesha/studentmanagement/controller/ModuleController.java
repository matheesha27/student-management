package com.matheesha.studentmanagement.controller;

import com.matheesha.studentmanagement.entity.Enrollment;
import com.matheesha.studentmanagement.entity.UserInfo;
import com.matheesha.studentmanagement.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @PostMapping("/add")
    public Enrollment registerStudent(@RequestParam(name = "admission") String admission,
                                      @RequestParam(name = "codes") String codes) {
        Enrollment enrollment = new Enrollment();
        enrollment.setAdmissionNumber(admission);
        enrollment.setModules(codes);
        return moduleService.addModules(enrollment);
    }

    @GetMapping("/list")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Map<Integer, String>> getModuleNames(@RequestParam(name = "admission") String admission) {
        return moduleService.getModuleNames(admission);
    }

    @GetMapping("/update")
    public String updateModules(@RequestParam(name = "admission") String admission,
                                @RequestParam(name = "codes") String codes,
                                @RequestParam(name = "action") boolean action) {
        return moduleService.updateModules(admission, codes, action);
    }

}
