package com.mergesortedlist;

public class MergeSortedList
{
  public static void main(String[] args)
  {
    ListNode listNode = mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))), new ListNode(1, new ListNode(3, new ListNode(4))));
    while (listNode != null)
    {
      System.out.println(listNode.val);
      listNode = listNode.next;
    }
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
  {
    ListNode firstNode = new ListNode(-1);
    ListNode mergedList = firstNode;
    while (l1 != null && l2 != null)
    {
      if (l1.val <= l2.val)
      {
        mergedList.next = l1;
        l1 = l1.next;
      }
      else
      {
        mergedList.next = l2;
        l2 = l2.next;
      }
      mergedList = mergedList.next;
    }

    if (l1 != null)
    {
      mergedList.next = l1;
    }

    if (l2 != null)
    {
      mergedList.next = l2;
    }
    return firstNode.next;
  }
}
