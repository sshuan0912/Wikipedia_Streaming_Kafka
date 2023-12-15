Wikipedia information can be edited by anyone in the world. The purpose is to retrieve updated Wikipedia data and store it in MySQL for further analysis. 
Since it's real-time streaming data, this application employs an event-driven architecture using Apache Kafka for event triggering and message broker. 
When a new edit is made, the producer publishes this new message to a topic, and then the consumer consumes this information, storing it in the database.
