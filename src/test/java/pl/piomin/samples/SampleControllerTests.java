package pl.piomin.samples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
properties = {
        "propertyFromMap=map", "propertyEnv=env"
})
public class SampleControllerTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void sample() {
        String response = restTemplate.getForObject("/sample/properties", String.class);
        Assertions.assertNotNull(response);
    }
}
