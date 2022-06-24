package com.lowes.bankingapp.fundtransfer;


import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.lowes.bankingapp.fundtransfer.model.FundTransfer;

//@Configuration
public class FundTransferConfig {
	
	  @Value("${spring.kafka.bootstrap-servers}")
	  private String bootstrapServers;

	  @Bean
	  public Map<String, Object> producerConfigs() {
	    Map<String, Object> props = new HashMap<>();
	    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
	    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

	    return props;
	  }

	  @Bean
	  public ProducerFactory<String, FundTransfer> producerFactory() {
	    return new DefaultKafkaProducerFactory<>(producerConfigs());
	  }

	  @Bean
	  public KafkaTemplate<String, FundTransfer> kafkaTemplate() {
	    return new KafkaTemplate<>(producerFactory());
	  }
	  
}
