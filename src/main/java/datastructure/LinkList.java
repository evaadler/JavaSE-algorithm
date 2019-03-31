package datastructure;

public class LinkList {


    public Node getElem(Node l, int i){


        int j = 0;


        while (l!=null && j<i){
            l = l.next;
            j++;
        }

        return l;
    }
}
