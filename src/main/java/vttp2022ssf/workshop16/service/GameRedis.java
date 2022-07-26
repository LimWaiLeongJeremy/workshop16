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

import vttp2022ssf.workshop16.model.Game;;

@Service
public class GameRedis implements GameRepo {
    private static final Logger logger = LoggerFactory.getLogger(GameRedis.class);

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public void save(final JsonObject body) {
        redisTemplate.opsForHash().put("Games", "gameName", body.toString());
        redisTemplate.opsForHash().put("Games", "ageGroup", body.toString());
        // logger.info((String) redisTemplate.opsForHash().get("Games", "gameName"));
        // logger.info((String) redisTemplate.opsForHash().get("Games", "ageGroup"));
    }

    @Override
    public Game load(final String gameName) {
        Game getDB;
        getDB = (Game) redisTemplate.opsForHash().get("Games", "gameName"); 
        getDB = (Game) redisTemplate.opsForHash().get("Games", "ageGroup");
        logger.info(">>> " + getDB.getGameName());
        logger.info(">>> " + getDB.getAgeGroup());
        return getDB;
    }
}
