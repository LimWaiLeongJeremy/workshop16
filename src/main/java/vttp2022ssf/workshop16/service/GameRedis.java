package vttp2022ssf.workshop16.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

// import sg.edu.nus.iss.Workshop14.model.Contact;

@Service
public class GameRedis implements GameRepo {
    private static final Logger logger = LoggerFactory.getLogger(GameRedis.class);

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public void save(final Contact ct) {
        
        String jsonString;
        try (InputStream is = new ByteArrayInputStream(jsonString.getBytes())) {
            JsonReader reader = Json.createReader(is);
            JsonObject data = reader.readObject();
        } 
        logger.info.data.toString;
        redisTemplate.opsForHash().put("c0", "gameName", “”); 
        redisTemplate.opsForHash().put("c0", "ageGroup", 100);
        // redisTemplate.opsForValue().set(ctc.getId(), ctc);
    }

    @Override
    public Contact findById(final String contactId) {
        Contact result = (Contact) redisTemplate.opsForValue().get(contactId);
        logger.info(">>> " + result.getEmail());
        return result;
    }
}
