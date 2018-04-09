package com.junior.bd_lr2;

import android.util.Log;

public class StuffTree {

    private StuffTree left;
    private StuffTree right;
    private Stuff stuff;

    public StuffTree(Stuff stuff) {
        this.stuff = stuff;
    }

    public void insert( StuffTree aTree) {
        if ( aTree.stuff.getIntStuff() < stuff.getIntStuff() )
            if ( left != null ) left.insert( aTree );
            else left = aTree;
        else
        if ( right != null ) right.insert( aTree );
        else right = aTree;
    }

    public boolean find( StuffTree aTree) {
        if(aTree.stuff.getIntStuff() == stuff.getIntStuff() && aTree.stuff == stuff){
            return true;
        }
        if ( aTree.stuff.getIntStuff() < stuff.getIntStuff() ) {
            return left != null && left.find(aTree);
        }
        else {
            return right != null && right.find(aTree);
        }
    }

    public void traverse(TreeVisitor visitor) {
        if ( left != null)
            left.traverse( visitor );

        visitor.visit(this);

        if ( right != null )
            right.traverse( visitor );
    }

    interface TreeVisitor {
        public void visit(StuffTree node);
    }

    static class KeyPrinter  implements TreeVisitor {
        public void visit(StuffTree node) {
            Log.d("SORT TREE NEW STUFF", node.stuff.toString());
        }
    }

}


