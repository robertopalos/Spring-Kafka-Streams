package com.palos.spring.apache.kafka;


import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

import com.esotericsoftware.minlog.Log;

@EnableBinding(KafkaProcessorMultipleInputs.class)
public class KafkaStreamsMultipleInputs {
	public static final String INPUT_TOPIC = "input";
	public static final String INPUT_TOPIC1 = "input1";
	public static final String OUTPUT_TOPIC = "output";

	@StreamListener
	@SendTo(OUTPUT_TOPIC)
	public KStream<String, String> process(@Input(INPUT_TOPIC)KStream<String, String> input,
						@Input(INPUT_TOPIC1)KTable<String, String> input1) {
		input.foreach((key, value) -> Log.error("Message received on stream input. " + key + " => " + value));
		input1.toStream().foreach((key, value) -> Log.error("Message received on table input1. " + key + " => " + value));
		return input;
	}
}
