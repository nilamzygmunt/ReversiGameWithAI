public class AIPlayer implements Player {
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    private int playerId;

    public AIPlayer(int playerId)
    {
        this.playerId = playerId;
    }
    @Override
    public Position putDisk() {
        return new Position(1,1);
    }
}
