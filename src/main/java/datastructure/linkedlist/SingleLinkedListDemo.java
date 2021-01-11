package datastructure.linkedlist;

/**
 * SingleLinkedListDemo
 *
 * @author Alicia
 * @description
 * @date 2020/7/16
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {

    }

}

class SingleLinkedList {
    /**
     *   先初始化一个头节点，头节点不要动，不存放具体的数据
     */
    private HeroNode head = new HeroNode(0,"","");

    /**
     *  添加节点到单向链表
     // 思路，当不考虑编号顺序时
     // 1. 找到当前链表的最后节点
     // 2. 将最后这个节点的next 指向新的节点
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        // 因为head节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode temp = head;
        // 遍历链表，找到最后
        while (true) {
            // 找到链表的最后
            if (temp.next == null) {
                break;
            }
            // 如果没有找到最后，将temp后移
            temp = temp.next;
        }
        // 当退出while循环时，temp就指向了链表的最后
        temp.next = heroNode;
    }
}

class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;



    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + next +
                '}';
    }
}
