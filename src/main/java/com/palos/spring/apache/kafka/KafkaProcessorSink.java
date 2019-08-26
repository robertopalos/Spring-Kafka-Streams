package com.palos.spring.apache.kafka;

import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.cloud.stream.annotation.Input;

public interface KafkaProcessorSink {
	@Input("input")
	KStream<String, String> input();
	@Input("input1")
	KTable<String, String> input1();
}
