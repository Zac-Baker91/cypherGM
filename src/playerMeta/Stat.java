package playerMeta;

//Stats are the basic player values if reduced to 0 player suffers negative effects, even death
//each has a Max, Pool, and Edge. Pool is your capacity and edge is your skill level.
public class Stat {
    private int currentPool;
    private int edge;
    private int maxPool;
    public Stat(){
        currentPool = -1;
        maxPool = -1;
        edge = -1;
    }
    public Stat(int p,int e){
        currentPool = p;
        maxPool = p;
        edge = e;
    }

    @Override
    public String toString() {
        return "currentPool: " + currentPool +
                ", edge: " + edge +
                ", maxPool: " + maxPool;
    }

    public int getCurrentPool() {
        return currentPool;
    }

    public void modCurrentPool(int currentPool) {
        this.currentPool = this.currentPool+currentPool;
    }

    public int getEdge() {
        return edge;
    }

    public void setEdge(int edge) {
        this.edge = edge;
    }

    public int getMaxPool() {
        return maxPool;
    }

    public void modMaxPool(int maxPool) {
        this.maxPool = this.maxPool + maxPool;
        this.currentPool = this.currentPool+maxPool;
    }

    public void modEdge(int mod){
        this.edge = this.edge + mod;
    }
}

