package com.jessicahuan.wikimediastreamingdatapublishconsumeproject;

import com.jessicahuan.wikimediastreamingdatapublishconsumeproject.Service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WikimediaStreamingDataPublishConsumeProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WikimediaStreamingDataPublishConsumeProjectApplication.class, args);
	}

	@Autowired
	private KafkaProducer kafkaProducer;

	@Override
	public void run(String... args) throws Exception{
		kafkaProducer.sendMessage();
	}
}
