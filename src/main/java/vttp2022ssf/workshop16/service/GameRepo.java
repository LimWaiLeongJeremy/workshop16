package vttp2022ssf.workshop16.service;

import vttp2022ssf.workshop16.model.Game;;

public interface GameRepo {
    public void save(final Game ctc);

    public Game find(final String contactId);
}
