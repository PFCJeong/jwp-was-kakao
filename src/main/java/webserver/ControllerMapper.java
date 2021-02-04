package webserver;

import controller.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import webserver.http.HttpRequest;

import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ControllerMapper {
    private List<Controller> list = new ArrayList<>();

    public ControllerMapper() {
        initControllers();
    }

    private void initControllers() {
        addController(new StaticController());
        addController(new TemplateController());
        addController(new FaviconController());
        addController(new UserCreateController());
        addController(new UserListController());
        addController(new UserLoginController());
    }

    public void addController(Controller controller) {
        list.add(controller);
    }

    public Optional<Controller> findController(HttpRequest request) {
        return list.stream()
                .filter(it -> it.canHandle(request))
                .findFirst();
    }
}
