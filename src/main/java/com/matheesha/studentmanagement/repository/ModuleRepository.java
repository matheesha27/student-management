package com.matheesha.studentmanagement.repository;

import com.matheesha.studentmanagement.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ModuleRepository extends JpaRepository<Enrollment, Integer> {

    @Query(value = "SELECT d.modules FROM Enrollments d WHERE d.admission_number = :admission", nativeQuery = true)
    String getModuleCodesByAdmission(@Param("admission") String admission);

    @Query(value = "SELECT d.module_code, d.module_name FROM Modules d WHERE d.module_code IN :moduleCodesArray", nativeQuery = true)
    List<Map<Integer, String>> getModuleNames(@Param("moduleCodesArray") String[] moduleCodesArray);

    @Modifying
    @Query(value = "INSERT INTO d.modules FROM Enrollments d VALUES = :codes WHERE d.admission_number = :admission", nativeQuery = true)
    void updateModuleCodes(@Param("codes") String codes, @Param("admission") String admission);
}
