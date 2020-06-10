package com.learning.palindrome;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 */
public class PalindromeLinkedList
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

}
