class Leaderboard {

    private Map<Integer, Player> playerMap;
    private TreeSet<Player> players;

    public Leaderboard() {
        this.playerMap = new HashMap<>();
        this.players = new TreeSet<>((a,b)->(b.sum!=a.sum?b.sum-a.sum:b.highest!=a.highest?b.highest-a.highest:b.playerId-a.playerId));
    }
    
    public void addScore(int playerId, int score) {
        this.playerMap.putIfAbsent(playerId, new Player(playerId));
        Player player = this.playerMap.get(playerId);
        this.players.remove(player);
        player.addScore(score);
        this.players.add(player);
    }
    
    public int top(int K) {
        // System.out.println("top "+K+" --------------------------");
        // System.out.println("players : "+this.players);
        int count = 0;
        int sum = 0;
        Iterator<Player> it = this.players.iterator();
        while(K>0)
        {
            if (!it.hasNext())
            {
                return sum;
            }
            Player curr = it.next();
            if (curr.highest==0)
            {
                return sum;
            }
            sum += curr.sum;
            K--;
        }
        return sum;
    }
    
    public void reset(int playerId) {
        Player player = this.playerMap.get(playerId);
        this.players.remove(player);
        player.reset();
        this.players.add(player);
    }
}

class Player
{
    int playerId;
    int highest;
    int sum;

    Player(int playerId)
    {
        this.playerId = playerId;
        this.highest = 0;
        this.sum = 0;
    }

    void addScore(int score)
    {
        this.highest = Math.max(this.highest, score);
        this.sum += score;
    }

    void reset()
    {
        this.highest = 0;
        this.sum = 0;
    }

    @Override
    public String toString()
    {
        return "["+this.playerId+", max : "+this.highest+", total : "+this.sum+"], \n";
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */