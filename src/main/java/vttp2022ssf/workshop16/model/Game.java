package vttp2022ssf.workshop16.model;

public class Game {
    private String gameName;
    private int ageGroup;

    
    public Game(String gameName, int ageGroup) {
        this.gameName = gameName;
        this.ageGroup = ageGroup;
    }


    public String getGameName() {
        return gameName;
    }
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
    public int getAgeGroup() {
        return ageGroup;
    }
    public void setAgeGroup(int ageGroup) {
        this.ageGroup = ageGroup;
    }
    

    

}
