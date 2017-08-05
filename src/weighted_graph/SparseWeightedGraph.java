import java.util.Vector;

public class SparseWeightedGraph<Weight extends Number & Comparable>
        implements WeightedGraph {

    private int n; 
    private int m;
    private boolean directed;
    private Vector<Edge<Weight>>[] g; 

    public SparseWeightedGraph( int n , boolean directed ){
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = (Vector<Edge<Weight>>[])new Vector[n];
        for(int i = 0 ; i < n ; i ++)
            g[i] = new Vector<Edge<Weight>>();
    }

    public int V(){ return n;}
    public int E(){ return m;}

    public void addEdge(Edge e){

        assert e.v() >= 0 && e.v() < n ;
        assert e.w() >= 0 && e.w() < n ;

        g[e.v()].add(new Edge(e));
        if( e.v() != e.w() && !directed )
            g[e.w()].add(new Edge(e.w(), e.v(), e.wt()));

        m ++;
    }

    public boolean hasEdge( int v , int w ){

        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;

        for( int i = 0 ; i < g[v].size() ; i ++ )
            if( g[v].elementAt(i).other(v) == w )
                return true;
        return false;
    }

    public void show(){

        for( int i = 0 ; i < n ; i ++ ){
            System.out.print("vertex " + i + ":\t");
            for( int j = 0 ; j < g[i].size() ; j ++ ){
                Edge e = g[i].elementAt(j);
                System.out.print( "( to:" + e.other(i) + ",wt:" + e.wt() + ")\t");
            }
            System.out.println();
        }
    }

    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}