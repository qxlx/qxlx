package generate;

import generate.Employees;

public interface EmployeesDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Employees record);

    int insertSelective(Employees record);

    Employees selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employees record);

    int updateByPrimaryKey(Employees record);
}