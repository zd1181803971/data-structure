package com.dzu.linkedlist;


/**
 * @author by ZhaoDong
 * @Classname SingleLinkedList
 * @Description 单向链表
 * @Date 2021/10/1 16:01
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "test1", "teat");
        HeroNode node2 = new HeroNode(2, "test2", "teat");
        HeroNode node3 = new HeroNode(3, "test3", "teat");
        HeroNode node4 = new HeroNode(4, "test4", "teat");
        HeroNode node5 = new HeroNode(4, "666", "666");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node2);
        System.out.println("有序添加");
        singleLinkedList.show();
//        singleLinkedList.update(node5);
//        System.out.println("更新");
//        singleLinkedList.show();
//        singleLinkedList.del(node1);
//        System.out.println("测试删除");
//        singleLinkedList.show();
//        System.out.println("获取单链表的节点的个数:");
//        System.out.println(getNodeSize(singleLinkedList.getHead()));
//        System.out.println("查找单链表中倒数第k个节点");
//        System.out.println(getLastNodeByIndex(singleLinkedList.getHead(), 1));
//        System.out.println("转换");
        HeroNode head = singleLinkedList.getHead();
//        convertNode(head);
//        singleLinkedList.show();
//        System.out.println("2222222头插");
//        convertNodeByHead(head);
//        singleLinkedList.show();
        System.out.println("逆序打印");
        showNode(head.next);



    }

    public static void showNode(HeroNode node) {
        if (node == null) {
            return;
        }
        showNode(node.next);
        System.out.println(node);
    }

    /**
     * 单链表转换：头插法
     * 1->2->3
     * 3->2->1
     * @param heroNode
     */
    public static void convertNodeByHead(HeroNode heroNode) {
        if (heroNode.next == null || heroNode.next.next == null) {
            return;
        }
        HeroNode tempHead = new HeroNode(0, "", "");
        HeroNode curr = heroNode.next;
        while (true) {
            if (curr == null) {
                break;
            }
            HeroNode next = curr.next;
            curr.next = tempHead.next;
            tempHead.next = curr;
            curr = next;

        }
        heroNode.next = tempHead.next;
    }
    /**
     * 转换节点：迭代反转链表
     * 通过三个变量
     * @param heroNode
     */
    public static void convertNode(HeroNode heroNode) {
        if (heroNode.next == null) {
            return ;
        }
        HeroNode temp = heroNode.next;
        HeroNode beg = null;
        HeroNode mid = temp;
        HeroNode end = temp.next;
        while (true) {
            if (end == null) {
                mid.next = beg;
                break;
            }
            mid.next = beg;
            beg = mid;
            mid = end;
            end = end.next;
        }
        heroNode.next = mid;
    }

    /**
     * 查找单链表中倒数第k个节点
     *
     * @param heroNode 单链表
     * @param index    倒数第几个
     * @return
     */
    public static HeroNode getLastNodeByIndex(HeroNode heroNode, int index) {
        if (heroNode.next == null) {
            return null;
        }
        int size = getNodeSize(heroNode);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode curr = heroNode.next;
        for (int i = 0; i < size - index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    /**
     * 获取单链表的节点的个数（如果是带头节点的，不统计头节点）
     *
     * @param heroNode
     * @return
     */
    public static int getNodeSize(HeroNode heroNode) {
        if (heroNode.next == null) {
            return 0;
        }
        HeroNode temp = heroNode.next;
        int count = 0;
        while (true) {
            if (temp == null) {
                break;
            }
            count++;
            temp = temp.next;
        }
        return count;

    }
}

class SingleLinkedList {
    private static HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 尾插
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        HeroNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = heroNode;
    }

    /**
     * 按照英雄序号no插入
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        if (temp.next == null) {
            add(heroNode);
            return;
        }
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            }
            if (temp.next.no == heroNode.no) {
                System.out.println("已经有了");
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println(heroNode);
            System.out.println("已经有了");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }


    }

    public void update(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                temp.name = heroNode.name;
                temp.nickname = heroNode.nickname;
                System.out.println("更新完成");
                break;
            }
            temp = temp.next;
        }
    }

    public void del(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == heroNode.no) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    public void show() {
        if (head.next == null) {
            System.out.println("空的");
            return;
        }
        HeroNode node = head;
        while (node.next != null) {
            System.out.println(node.next);
            node = node.next;
        }
    }
}

class HeroNode {
    public HeroNode next;
    public int no;
    public String name;
    public String nickname;

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
                '}';
    }
}

