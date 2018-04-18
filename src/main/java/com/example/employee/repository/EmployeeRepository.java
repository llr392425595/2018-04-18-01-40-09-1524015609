package com.example.employee.repository;

import com.example.employee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  //1.查询名字是*的第一个employee
  Employee findFirstByName(String name);

  //2.找出Employee表中第一个姓名包含`*`字符并且薪资大于*的雇员个人信息
  Employee findFirstByNameLikeAndSalaryIsGreaterThan(String character,Integer salary);

  //3.找出一个薪资最高且公司ID是*的雇员以及该雇员的姓名
  @Query("SELECT E1 FROM Employee E1 WHERE E1.companyId = ?1 AND E1.salary = (SELECT MAX(E2.salary) from Employee E2 WHERE E2.companyId = ?1)")
  Employee findMostSalaryInCompany(int companyId);

  //4.实现对Employee的分页查询，每页两个数据
  Page<Employee> findAll(Pageable pageable);

  //5.查找**的所在的公司的公司名称
  @Query("SELECT c.companyName from Employee e LEFT JOIN Company c ON e.companyId = c.id WHERE e.name = ?1")
  String findCompanyNameByName(String name);

  //6.将*的名字改成*,输出这次修改影响的行数
  @Modifying
  @Query("update Employee e set e.name=?2 WHERE e.name = ?1 ")
  int replaceName(String name1, String name2);

  //7.删除姓名是*的employee
  @Query(value = "delete from employee where name=?1 ", nativeQuery = true)
  @Modifying
  void deleteEmployeeByName(String name);




}
