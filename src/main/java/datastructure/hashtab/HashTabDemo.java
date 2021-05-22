package datastructure.hashtab;

import java.util.Scanner;

/**
 * HashTabDemo
 *
 * @author Alicia
 * @description
 * @date 2021/3/30
 */
public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    // 创建雇员
                    Emp emp= new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
        //this.next = next;
    }
}

// 创建Hashtable，管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTab(int size) {
        // 指定多少条链表
        empLinkedListArray = new EmpLinkedList[size];
        //记得初始化数组里每个链表
        for (int i=0; i<size; i++){
            empLinkedListArray[i] = new EmpLinkedList();
        }
        this.size = size;

    }

    // 添加雇员
    public void add(Emp emp){
        // 根据员工id，得到该员工应当添加到哪条链表
        int empLinkedListNO = hashFun(emp.id);
        // 将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNO].add(emp);
    }



    // 遍历hash表
    public void list(){
        for (int i=0; i<size; i++){
            empLinkedListArray[i].list();
        }
    }

    public void findEmpById(int id){
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].findByEmpId(id);
        if (emp!=null){
            System.out.printf("在第%d条链表中找到雇员%d\n",(empLinkedListNO+1),id);
        }else {
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }

    public void delete(int id){
        int empLinkedListNo = hashFun(id);
        empLinkedListArray[empLinkedListNo].delete(id);
    }

    // 编写散列函数，简单：取模
    public int hashFun(int id){
        return id % size;
    }
}

//创建链表
class EmpLinkedList{
    private Emp head;

    /**
     * 1. 假定添加雇员，id自增长，即id的分配从小到大
     *
     * @param emp
     */
    public void add(Emp emp){
        // 如果是添加第一个雇员
        if (head == null){
            head = emp;
            return;
        }
        // 如果不是第一个雇员，使用辅助的指针，帮助定位到最后
        Emp curEmp = head;
        while (true){
            if (curEmp.next == null){ //说明到链表最后了
                break;
            }
            curEmp = curEmp.next; //  后移
        }
        // 退出直接将emp加入链表
        curEmp.next = emp;
    }

    public Emp findByEmpId(int id){
        // 判断链表哦是否为空
        if (head == null){
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.id == id){
                break;
            }
            if (curEmp.next == null){ // 遍历到了链表结尾还没找到
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

    public void delete(int id){
        if (head == null){
            System.out.println("链表为空，不用删除");
            return;
        }
        Emp curEmp = head;
        while (curEmp.next != null){
            if (curEmp.id == id){
                curEmp.next = curEmp.next.next;
            }
        }
    }

    //遍历
    public void list(){
        if (head == null){ // 说明链表为空
            System.out.println("当前链表为空");
            return;
        }
        System.out.println("当前链表的信息为");
        Emp curEmp = head;
        while (true){
            System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null ){//说明到链表最后了
                break;
            }
            curEmp = curEmp.next; // cur 指向下一个
        }
        System.out.println();
    }
}
