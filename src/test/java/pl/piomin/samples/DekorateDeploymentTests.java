package pl.piomin.samples;

import io.dekorate.testing.annotation.Inject;
import io.dekorate.testing.annotation.KubernetesIntegrationTest;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import java.util.List;

@KubernetesIntegrationTest
public class DekorateDeploymentTests {

    @Inject
    KubernetesClient client;

    @Test
    public void deployment() {
        List<Pod> pods = client.pods().inAnyNamespace().list().getItems();
        for (Pod pod: pods) {
            System.out.println(pod.getFullResourceName());
        }
    }
}
