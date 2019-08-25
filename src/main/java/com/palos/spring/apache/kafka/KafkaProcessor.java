package com.palos.spring.apache.kafka;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;

public interface KafkaProcessor {
	@Input("input")
	KStream<String, String> input();
	@Output("output-1")
	KStream<String, String> output1();
	
}
