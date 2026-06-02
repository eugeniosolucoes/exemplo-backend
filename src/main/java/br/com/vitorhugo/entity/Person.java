package br.com.vitorhugo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 *
 * @author alexandre
 */
@AllArgsConstructor
@Data
public class Person {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
}