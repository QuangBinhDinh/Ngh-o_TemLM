package Dictionary;

/**
 *
 * @author Win10
 */
public class Word {
    private String target;
    private String explain;
    public Word(String target, String explain){
        this.target = target; this.explain = explain;
    }
    public void setTarget(String target){
        this.target = target;
    }
    public void setExpalin(String explain){
        this.explain = explain;
    }
    public String getTarget(){
        return target;
    }
    public String getExplain(){
        return explain;
    }
}