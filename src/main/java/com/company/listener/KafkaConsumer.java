package com.company.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.company.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {

	private ObjectMapper objectMapper;

	private User user;

	// @KafkaListener(topics = "test", groupId = "group_id")
	/*
	 * @KafkaListener(topicPartitions = @TopicPartition(topic = "test",
	 * partitionOffsets = {
	 * 
	 * @PartitionOffset(partition = "0", initialOffset = "0"),
	 * 
	 * @PartitionOffset(partition = "1", initialOffset = "0") })) public void
	 * consume(@Payload String
	 * message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
	 * log.info("Consumed message: " + message + " from partition: " +
	 * partition); }
	 * 
	 * @KafkaListener(topics = "Kafka_Example_json", groupId = "group_json",
	 * containerFactory = "userKafkaListenerFactory") public void
	 * consumeJson(@Payload User user,
	 * 
	 * @Header(name = KafkaHeaders.MESSAGE_KEY) String messageKey,
	 * 
	 * @Header(name = KafkaHeaders.RECEIVED) String recieved,
	 * 
	 * @Header(name = KafkaHeaders.TOPIC) String topic,
	 * 
	 * @Header(name = KafkaHeaders.PARTITION_ID) String partitionId,
	 * 
	 * @Header(name = KafkaHeaders.OFFSET) String offSet,
	 * 
	 * @Header(name = KafkaHeaders.ACKNOWLEDGMENT) String acknowledgement,
	 * 
	 * @Header(name=KafkaHeaders.RECEIVED_MESSAGE_KEY) String
	 * receivedMessageKey,
	 * 
	 * @Header(name=KafkaHeaders.RECEIVED_PARTITION_ID) String
	 * recievedPartitionId,
	 * 
	 * @Header(name=KafkaHeaders.TIMESTAMP) String timeStamp) {
	 * log.info("Consumed JSON Message: " + user + " MessageKey : " +
	 * messageKey); }
	 */

	@KafkaListener(topics = "Kafka_Json_Test", groupId = "group_json", containerFactory = "userKafkaListenerFactory")
	public void consumeJson(String user) throws Exception {
		log.info("Consuming String Json:  " + user);
		deserializeJsonString(user);

	}

	private void deserializeJsonString(String jsonString) throws Exception {
		objectMapper = new ObjectMapper();
		user = objectMapper.readValue(jsonString, User.class);
		log.info("User Object" + user.toString());
	}
}
