package swordholder.comparator;

import swordholder.model.RelatedModel;

public class RelatedModelComparator {

    public static int compareByParentId(RelatedModel first, RelatedModel other) {
        return first.getParent().getId().compareTo(other.getParent().getId());
    }

    public static int compareByChildCount(RelatedModel first, RelatedModel other){
        return Integer.compare(other.getChildren().size(),first.getChildren().size());
    }
}
