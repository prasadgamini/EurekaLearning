package edu.aa.fly.lab4clientsentence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class SentenceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/sentence")
    public String getSentence() {
        return getWordWithRibbon("LAB-4-CLIENT-SUBJECT") + " "
                + getWordWithRibbon("LAB-4-CLIENT-VERB") + " "
                + getWordWithRibbon("LAB-4-CLIENT-ARTICLE") + " "
                + getWordWithRibbon("LAB-4-CLIENT-ADJECTIVE") + " "
                + getWordWithRibbon("LAB-4-CLIENT-NOUN") + ".";
    }

    public String getWord(String service) {
        List<ServiceInstance> list = discoveryClient.getInstances(service);
        if (list != null && list.size() > 0) {
            URI uri = list.get(0).getUri();
            if (uri != null) {
                return (new RestTemplate()).getForObject(uri, String.class);
            }
        }
        return null;
    }

    public String getWordWithRibbon(String service) {
        ServiceInstance serviceInstance = loadBalancerClient.choose(service);

        /**
         * Making calls using serviceIntance is not a good approach...
         * We need some declarative approach.
         * For that we need Feign. For now this is learning Ribbon.
         */
        URI uri = serviceInstance.getUri();
        if (uri != null) {
            return (new RestTemplate()).getForObject(uri, String.class);
        }
        return null;
    }
}
