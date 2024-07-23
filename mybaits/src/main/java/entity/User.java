package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qxlx
 * @date 2024/6/10 23:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    int id;
    String name;
    Integer age;

}
