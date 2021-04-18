package mysql.outfit;


import java.io.Serializable;
 
public class ExerciseC implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    private int id;
    private String nameEx;
    private int weight;
     
    public ExerciseC(){ }
    public ExerciseC(String nameEx, int weight){
         
        this.nameEx = nameEx;
        this.weight = weight;
    }
    public ExerciseC(int id, String nameEx, int weight){
         
        this.id = id;
        this.nameEx = nameEx;
        this.weight = weight;
    }
     
    public int getId() {
        return id;
    }
     
    public String getName() {
        return nameEx;
    }
 
    public void setName(String nameEx) {
        this.nameEx = nameEx;
    }
 
    public int getWeight() {
        return weight;
    }
 
    public void setWeight(int weight) {
        this.weight = weight;
    }
}

