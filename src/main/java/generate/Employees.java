package generate;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * employees
 * @author 
 */
@Data
public class Employees implements Serializable {
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 职位
     */
    private String position;

    /**
     * 入职时间
     */
    private Date hireTime;

    private static final long serialVersionUID = 1L;
}