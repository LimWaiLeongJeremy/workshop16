package vttp2022ssf.workshop16.service;

import jakarta.json.JsonObject;
import vttp2022ssf.workshop16.model.Game;;

public interface GameRepo {
    public void save(final JsonObject body);

    public Game load(final String gameName);
}
