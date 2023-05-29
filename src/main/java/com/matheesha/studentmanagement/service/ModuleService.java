package com.matheesha.studentmanagement.service;

import com.matheesha.studentmanagement.entity.Enrollment;

import java.util.List;
import java.util.Map;

public interface ModuleService {

    Enrollment addModules(Enrollment enrollment);

    List<Map<Integer, String>> getModuleNames(String admission);

    String updateModules(String admission, String codes, boolean action);
}
