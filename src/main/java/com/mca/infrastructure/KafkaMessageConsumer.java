package com.mca.infrastructure;

import com.google.gson.Gson;
import com.mca.data.repository.GameRepository;
import com.mca.infrastructure.model.VideoGameEntity;
import com.mca.infrastructure.model.VideoGameEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class KafkaMessageConsumer {

    @Value(value = "${topic}")
    private String topicName;

    Gson gson = new Gson();

    @Autowired
    private GameRepository repository;

    @KafkaListener(topics = "topicName")
    public void listen(ConsumerRecord<String, String> record) {
        String message = record.value();
        VideoGameEvent event = gson.fromJson(message, VideoGameEvent.class);
        Optional<VideoGameEntity> videoGame = repository.findById(String.valueOf(event.getStock_id()));
        if (videoGame.isPresent()) {
            VideoGameEntity entity = videoGame.get();
            repository.delete(entity);
            repository.save(entity);
        }
    }
}
