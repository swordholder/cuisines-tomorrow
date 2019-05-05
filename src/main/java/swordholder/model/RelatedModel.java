package swordholder.model;

import java.util.ArrayList;

public class RelatedModel {

    private AbstractModel parent;
    private ArrayList<AbstractModel> children;

    public RelatedModel(AbstractModel parent, AbstractModel child){
        this.parent = parent;
        this.children = new ArrayList<>();
        this.children.add(child);
    }

    public AbstractModel getParent(){
        return this.parent;
    }

    public ArrayList<? extends AbstractModel> getChildren(){
        return this.children;
    }

    public void addChild(AbstractModel child){
        this.children.add(child);
    }


}
