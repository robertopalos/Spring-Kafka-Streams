package com.palos.spring.apache.kafka;


import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

import com.esotericsoftware.minlog.Log;

@EnableBinding(KafkaProcessor.class)
public class KafkaStreams {
	public static final String INPUT_TOPIC = "input";
	public static final String OUTPUT_TOPIC = "output-1";
	public static final int WINDOW_SIZE_MS = 30000;
	@StreamListener(INPUT_TOPIC)
	@SendTo({OUTPUT_TOPIC})
	public KStream<String, String> process(KStream<String, String> input) {
		Log.error("message received");
		input.foreach((key, value) -> Log.error(key + " => " + value));
		return input;
	}
}
