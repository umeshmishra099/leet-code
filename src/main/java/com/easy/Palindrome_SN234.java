package com.easy;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * Output: false
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * Output: true
 */
public class Palindrome_SN234
{
  public static void main(String[] args)
  {
    ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
    System.out.println(isPalindrome(listNode));
  }

  private static boolean isPalindrome(ListNode head)
  {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null)
    {
      slow = slow.next;
      fast = fast.next.next;
    }

    fast = head;
    slow = reverse(slow);
    while (slow != null)
    {
      if (slow.val != fast.val)
      {
        return false;
      }
      slow = slow.next;
      fast = fast.next;
    }
    return true;
  }

  private static ListNode reverse(ListNode node)
  {
    ListNode prev = null;
    ListNode current = node;
    ListNode next = null;
    while (current != null)
    {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    node = prev;
    return node;
  }

  static class ListNode
  {
    int val;
    ListNode next;

    ListNode()
    {
    }

    ListNode(int val)
    {
      this.val = val;
    }

    ListNode(int val, ListNode next)
    {
      this.val = val;
      this.next = next;
    }
  }

}
