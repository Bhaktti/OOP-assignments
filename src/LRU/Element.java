package LRU;

/**
 * Created by bhakti on 12/1/17.
 */
public interface Element extends Comparable
{
    /**
     * @return
     */
    public Comparable getKey();
    /**
     * @return
     */
    public Object getValue();
}
