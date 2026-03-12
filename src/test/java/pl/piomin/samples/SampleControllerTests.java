package pl.piomin.samples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
properties = {
        "propertyFromMap=map", "propertyEnv=env"
})
@AutoConfigureTestRestTemplate
public class SampleControllerTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void sample() {
        String response = restTemplate.getForObject("/sample/properties", String.class);
        Assertions.assertNotNull(response);
    }
}
