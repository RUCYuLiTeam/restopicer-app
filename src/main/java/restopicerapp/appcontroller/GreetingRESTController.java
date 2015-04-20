package restopicerapp.appcontroller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import restopicerapp.appmodelrepository.Greeting;

@RestController
public class GreetingRESTController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/rest/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    @RequestMapping("/rest/great")
    public String great(@RequestParam(value="name", defaultValue="World") String name) {
        return String.format(template, name);
    }
}
