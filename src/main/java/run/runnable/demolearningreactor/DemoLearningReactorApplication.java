package run.runnable.demolearningreactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Controller
@SpringBootApplication
public class DemoLearningReactorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoLearningReactorApplication.class, args);
    }

    @RequestMapping("/{delay}")
    @ResponseBody
    public Mono<String> hello(@PathVariable Integer delay){
        return Mono.just(delay)
                .delayElement(Duration.ofMillis(delay))
                .thenReturn(Math.random()+"");
    }

}
