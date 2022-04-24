//class Solution {
//    public NodeList sortList(NodeList head) {
//        if (head == null)
//            return head;
//        int size = 0;
//        NodeList p = head;
//        while (p != null) {// 待排序节点个数
//            p = p.next;
//            size++;
//        }
//        return this.sort(head, 0, size - 1);
//    }
//
//    private ListNode sort(ListNode head, int l, int r) {
//        if (l == r) {// 只有一个节点的时候返回
//            return head;
//        }
//        int mid = ((r - l) >> 1) + l;// 分割点
//        ListNode p = head;// p是分割点前的节点
//        int move = mid - l;
//        while (move > 0) {// 移动到分割点前
//            p = p.next;
//            move--;
//        }
//        ListNode next = p.next;// 第二个链表的头
//        p.next = null;// 链表一分为二
//        // 二分排序，将各自排序的结果用merge合并
//        return this.merge(this.sort(head, l, mid), this.sort(next, mid + 1, r));
//    }
//
//    private ListNode merge(ListNode head, ListNode p) {
//        ListNode p1 = new ListNode();// 走针，随着节点增加，向后移动
//        ListNode p2 = p1;// 头针，拿住头，才能返回
//        while (head != null && p != null) {// 将head和p中小的节点接到结果上
//            if (head.val < p.val) {
//                p1.next = head;
//                head = head.next;// 接的节点走，不接的节点不走
//            } else {
//                p1.next = p;
//                p = p.next;
//            }
//            p1 = p1.next;// 每接一个节点向后走一步
//        }
//        while (head != null) {// 长处来的一定是排好序，且比较大的节点，head和p满足其一
//            p1.next = head;
//            head = head.next;
//            p1 = p1.next;
//        }
//        while (p != null) {// 长处来的一定是排好序，且比较大的节点，head和p满足其一
//            p1.next = p;
//            p = p.next;
//            p1 = p1.next;
//        }
//        return p2.next;
//    }
//}