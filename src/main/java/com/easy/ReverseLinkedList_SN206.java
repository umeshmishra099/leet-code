package com.easy;

/**
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList_SN206
{
  public static void main(String[] args)
  {

  }

  public ListNode reverseList(ListNode head)
  {
    ListNode newHead = null;
    while (head != null)
    {
      ListNode next = head.next;
      head.next = newHead;
      newHead = head;
      head = next;
    }
    return newHead;
  }

  static class ListNode
  {
    public int val;
    public ListNode next;

    public ListNode()
    {
    }

    public ListNode(int val)
    {
      this.val = val;
    }

    public ListNode(int val, ListNode next)
    {
      this.val = val;
      this.next = next;
    }
  }
}
