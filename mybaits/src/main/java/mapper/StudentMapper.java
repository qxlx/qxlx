package mapper;

import entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author qxlx
 * @date 2024/6/10 23:03
 */
@Mapper
public interface StudentMapper {

    List<User> getAll();

}
