package com.dzu.linkedlist;

/**
 * @author by ZhaoDong
 * @Classname DoubleLinkedListDemo
 * @Description 双向链表
 * @Date 2021/10/3 13:49
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 node1 = new HeroNode2(1, "test1", "teat");
        HeroNode2 node2 = new HeroNode2(2, "test2", "teat");
        HeroNode2 node3 = new HeroNode2(3, "test3", "teat");
        HeroNode2 node4 = new HeroNode2(4, "test4", "teat");
        DoubleLinkedList linked = new DoubleLinkedList();
        linked.addByNo(node3);
        linked.addByNo(node2);
        linked.addByNo(node4);
        linked.addByNo(node1);
        linked.show();
        System.out.println("删除一个");
        linked.delete(node3);
        linked.show();
    }
}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    /**
     * 尾插
     *
     * @param heroNode2
     */
    public void add(HeroNode2 heroNode2) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode2;
        heroNode2.pre = temp;
    }

    /**
     * 按照英雄编号顺序插入
     *
     * @param heroNode
     */
    public void addByNo(HeroNode2 heroNode) {
        if (head.next == null) {
            add(heroNode);
            return;
        }
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (heroNode.no <= temp.next.no) {
                heroNode.pre = temp;
                heroNode.next = temp.next;
                temp.next.pre = heroNode;
                temp.next = heroNode;
                return;
            }
            temp = temp.next;
        }
        add(heroNode);
    }

    /**
     * del By no
     *
     * @param heroNode2
     */
    public void delete(HeroNode2 heroNode2) {
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                return;
            }
            if (temp.no == heroNode2.no) {
                temp.pre.next = temp.next;
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
            }
            temp = temp.next;
        }
    }


    public void show() {
        if (head.next == null) {
            System.out.println("空的");
            return;
        }
        HeroNode2 node = head;
        while (node.next != null) {
            System.out.println(node.next);
            node = node.next;
        }
    }
}


class HeroNode2 {
    public HeroNode2 next;
    public HeroNode2 pre;
    public int no;
    public String name;
    public String nickname;

    public HeroNode2(int no, String name, String nickname) {
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
