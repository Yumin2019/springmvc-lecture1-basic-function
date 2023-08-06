package hello.springmvc.basic;

import lombok.Data;

// getter, setter, tostring 등 자동으로 만든다.
@Data
public class HelloData {
    private String username;
    private int age;
}
