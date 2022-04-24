/**
 * 单向链表
 */
public class NodeList {
    private Node first;//第一个节点
    private int nElem;//链表中节点数量

    public NodeList(){
        first = null;
        nElem = 0;
    }


    //添加头结点
    public void insertFirst(int value){
        Node newLink = new Node(value);
        newLink.next = first;//newLink-->old first
        first = newLink;//first-->newLink
        nElem ++;
    }

    //删除头节点
    public Node deleteFirst(){
        if(isEmpty()){
            System.out.println("链表为空");
            return null;
        }
        Node temp = first;
        first = first.next;
        nElem --;
        return temp;
    }

    /************************************************************
     ***下面是有序链表的插入***
     ***这样简单排序就可以用链表来实现，复杂度为O(N)
     ***定义一个方法，传入一个数组，
     ***在方法内，遍历数组并调用insert方法就可以将数组中的数据排好序
     ***********************************************************/
    public void insert(int value){
        Node newLink = new Node(value);//要插入的Link节点
        Node previous = null;//前一个link节点
        Node current = first;//因为是有序链表，从第一个开始
        while(current != null && value > current.val){//当前link不是空，插入的数据大于当前link值
            previous = current;//记录当前为前一个link节点
            current = current.next;//当前link向下找
        }
        if(previous == null){//前一个为null证明只有没有插入link节点，直接插入就行
            first = newLink;
        }else {
            previous.next = newLink;//插入这个link在小于value的link下，后边link为当前节点
        }
        newLink.next = current;//当前节点
        nElem ++;//有序链表长度+1
    }

    //查找特定的节点
    public Node find(int value){
        Node current = first;//从第一个开始查找
        while(current.val != value){
            if(current.next == null){//下一个为空
                return null;
            }else{
                current = current.next;//查找下一个节点
            }
        }
        return current;
    }

    //删除特定的节点
    public Node delete(int value){
        Node current = first;
        Node previous = first;//记录上一个Link,因为要删除节点，节点的指向要发生变化
        while(current.val != value){
            if(current.next == null){
                return null;
            }
            previous = current;
            current = current.next;
        }
        if(current == first){//如要要删除的是第一个
            first = first.next;
        }else{
            previous.next = current.next;//删除link的上一个指向为当前link的下一个link
        }
        nElem --;
        return current;
    }

    //查看链表中的数据
    public void displayList(){
        if(isEmpty()){//为空直接返回
            System.out.println("链表为空！");
            return;
        }
        Node current = first;
        while(current != null){
            current.displayNode();//调用link中的方法，打印当前link的值
            current = current.next;
        }
        System.out.println(" ");
    }

    //链表是否为空
    public boolean isEmpty(){
        return (first == null);
    }

    //链表中节点个数
    public int size(){
        return nElem;
    }
}

