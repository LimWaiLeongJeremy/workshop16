package vttp2022ssf.workshop16.controllor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp2022ssf.workshop16.model.Game;
import vttp2022ssf.workshop16.service.GameRedis;
    
@RestController 
@RequestMapping(path= "/api", produces = "application/json" )
public class GameControllor {
    private static Logger logger = LoggerFactory.getLogger(GameControllor.class);
    
    @Autowired
    private GameRedis gameSvc;
    private String appName;

    @PostMapping(path="/boardgame", consumes="application/json")
    public ResponseEntity<String> saveGame(@RequestBody String payload) {
        JsonObject body;
        URI location;

        try (InputStream is = new ByteArrayInputStream(payload.getBytes())) {
            JsonReader reader = Json.createReader(is);
            body = reader.readObject();
            gameSvc.save(body);
            location = new URI("http://localhost:8080/api/boardgame");
            logger.info(body.toString());
            return ResponseEntity.created(location).body("hello");
        } catch (Exception e) {
            body = Json.createObjectBuilder().add("error", e.getMessage()).build();
            return ResponseEntity.internalServerError().body(body.toString());
        }
    }

            
    @GetMapping (path = "/borsdgame/{gameName}")
    public ResponseEntity<String> getgameDetail(@PathVariable(name = "gameName") String gameName) {
            Game game = gameSvc.load(gameName);
        return ResponseEntity.ok(game.toString());
    }

        



//         @GetMapping (path="/boardgame") 
//         public ResponseEntity<String> getGame {
//             final JsonObject resp = Json.createObject() .add(“name”, user.getName())
// ...
// .build()
            
}

