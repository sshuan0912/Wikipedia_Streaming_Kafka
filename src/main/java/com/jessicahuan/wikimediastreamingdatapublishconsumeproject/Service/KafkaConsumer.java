package com.jessicahuan.wikimediastreamingdatapublishconsumeproject.Service;

import com.jessicahuan.wikimediastreamingdatapublishconsumeproject.Entity.WikimediaChangedData;
import com.jessicahuan.wikimediastreamingdatapublishconsumeproject.Repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private WikimediaRepository wikimediaRepository;

    public KafkaConsumer(WikimediaRepository wikimediaRepository) {
        this.wikimediaRepository = wikimediaRepository;
    }

    @KafkaListener(topics = "wikimedia_topic", groupId = "myGroup")
    public void consume(String eventMessage){
        LOGGER.info(String.format("Message received -> %s", eventMessage));

        WikimediaChangedData wikimediaChangedData = new WikimediaChangedData();
        wikimediaChangedData.setChangedData(eventMessage);
        wikimediaRepository.save(wikimediaChangedData);
    }


}
