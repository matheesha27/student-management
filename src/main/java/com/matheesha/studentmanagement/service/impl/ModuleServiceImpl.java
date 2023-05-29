package com.matheesha.studentmanagement.service.impl;

import com.matheesha.studentmanagement.entity.Enrollment;
import com.matheesha.studentmanagement.repository.ModuleRepository;
import com.matheesha.studentmanagement.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;


    public Enrollment addModules(Enrollment enrollment) {
        moduleRepository.save(enrollment);
        return enrollment;
    }

    public List<Map<Integer, String>> getModuleNames(String admission) {
        String moduleCodesStr = moduleRepository.getModuleCodesByAdmission(admission);
        String[] moduleCodesArray = moduleCodesStr.split(",");
        return moduleRepository.getModuleNames(moduleCodesArray);
    }

    public String updateModules(String admission, String codes, boolean action) {
        try{
            if (action) {
                String currentModuleCodes = moduleRepository.getModuleCodesByAdmission(admission);
                currentModuleCodes = currentModuleCodes + "," + codes;
                String[] updatedModuleCodesArray = currentModuleCodes.split(",");
                LinkedHashSet<String> moduleCodesSet = new LinkedHashSet<String>(Arrays.asList(updatedModuleCodesArray));
                String[] sortedModuleCodesArray = moduleCodesSet.toArray(new String[moduleCodesSet.size()]);
                StringBuilder formattedModuleCodes = new StringBuilder();
                for (String str : sortedModuleCodesArray) {
                    formattedModuleCodes.append(str).append(",");
                }
                moduleRepository.save(new Enrollment(admission, formattedModuleCodes.toString().substring(0, formattedModuleCodes.toString().length()-1)));
            } else {
                List<String> currentModuleCodes = new ArrayList<>(Arrays.asList(moduleRepository.getModuleCodesByAdmission(admission).split(",")));
                String[] removeModuleCodesArray = codes.split(",");
                for (String removeStr : removeModuleCodesArray) {
                    currentModuleCodes.remove(removeStr);
                }
                StringBuilder formattedModuleCodes = new StringBuilder();
                for (String str : currentModuleCodes) {
                    formattedModuleCodes.append(str).append(",");
                }
                moduleRepository.save(new Enrollment(admission, formattedModuleCodes.toString().substring(0, formattedModuleCodes.toString().length()-1)));
            }
        } catch (Exception e) {
            throw e;
        }
//        Map<String, String> studentEnrollments = new HashMap<String, String>();
//        studentEnrollments.put("studentDetails", studentService.getStudentDetailsByAdmission(admission).toString());
//        studentEnrollments.put("enrolledModules", moduleRepository.findByAdmissionNumber(admission));
        return "SUCCESS";
    }
}
