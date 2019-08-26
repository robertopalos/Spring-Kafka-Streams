package com.palos.spring.apache.kafka;


import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.esotericsoftware.minlog.Log;

@EnableBinding(KafkaProcessorSink.class)
public class KafkaStreamsSink {
	public static final String INPUT_TOPIC = "input";
	public static final String INPUT_TOPIC1 = "input1";
	public static final int WINDOW_SIZE_MS = 30000;
	@StreamListener
	public void process(@Input(INPUT_TOPIC)KStream<String, String> input,
						@Input(INPUT_TOPIC1)KTable<String, String> input1) {
		input.foreach((key, value) -> Log.error("Message received on stream input. " + key + " => " + value));
		input1.toStream().foreach((key, value) -> Log.error("Message received on table input1. " + key + " => " + value));
		
	}
}
