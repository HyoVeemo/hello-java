package hello.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class HelloLombok {
    private final String name;
    private final int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok("A",123);
        helloLombok.getAge();
        helloLombok.toString();

    }
}
