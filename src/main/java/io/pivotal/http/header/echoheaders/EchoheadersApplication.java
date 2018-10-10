package io.pivotal.http.header.echoheaders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class EchoheadersApplication {

	public static void main(String[] args) {
		SpringApplication.run(EchoheadersApplication.class, args);
	}

    @RequestMapping("/")
    public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders(@RequestHeader HttpHeaders headers) {

	    StringBuilder body = new StringBuilder("Headers in request: \n\n");

        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            body.append(entry.getKey()).append(" : ").append(entry.getValue()).append('\n');
        }

        return ResponseEntity.ok()
                .headers(headers)
                .body(body.toString());
    }
}
