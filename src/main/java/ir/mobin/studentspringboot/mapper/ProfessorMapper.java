package ir.mobin.studentspringboot.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProfessorMapper {
    private final ModelMapper modelMapper;

}
