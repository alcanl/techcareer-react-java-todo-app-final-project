package com.alcanl.app.runner;

import com.alcanl.app.business.dto.ToDoInfoDTO;
import com.alcanl.app.business.services.impl.ToDoInfoServiceImpl;
import com.alcanl.app.data.type.ToDoProcessType;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ToDoSampleRunner implements ApplicationRunner {
    private final ToDoInfoServiceImpl m_todoInfoService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        var test = new ToDoInfoDTO();
        test.setContent("TEST");
        test.setToDoProcessType(ToDoProcessType.ACTIVE);
        m_todoInfoService.create(test);
    }
}
