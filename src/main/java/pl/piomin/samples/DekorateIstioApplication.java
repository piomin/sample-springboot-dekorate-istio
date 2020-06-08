package pl.piomin.samples;

import io.dekorate.kubernetes.annotation.Env;
import io.dekorate.kubernetes.annotation.KubernetesApplication;
import io.dekorate.kubernetes.annotation.Label;
import io.dekorate.kubernetes.annotation.Port;
import io.dekorate.option.annotation.GarbageCollector;
import io.dekorate.option.annotation.JvmOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@KubernetesApplication(replicas = 2,
        envVars = { @Env(name = "propertyEnv", value = "Hello from env!"),
                    @Env(name = "propertyFromMap", value = "property1", configmap = "sample-configmap") },
        expose = true,
        ports = @Port(name = "http", containerPort = 8080),
        labels = @Label(key = "version", value = "v1"))
@JvmOptions(server = true, xmx = 256, gc = GarbageCollector.SerialGC)
public class DekorateIstioApplication {

    public static void main(String[] args) {
        SpringApplication.run(DekorateIstioApplication.class, args);
    }

}
