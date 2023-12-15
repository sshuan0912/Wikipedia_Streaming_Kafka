package com.jessicahuan.wikimediastreamingdatapublishconsumeproject.Service;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException {
        String topic = "wikimedia_topic";

        BackgroundEventHandler eventHandler = new WikimediaHandler(kafkaTemplate, topic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";

        EventSource.Builder esBuilder = new EventSource.Builder(URI.create(url));
        BackgroundEventSource.Builder eventSource = new BackgroundEventSource.Builder(eventHandler, esBuilder);
        BackgroundEventSource source = eventSource.build();
        source.start();

        TimeUnit.MINUTES.sleep(10);

    }
}
