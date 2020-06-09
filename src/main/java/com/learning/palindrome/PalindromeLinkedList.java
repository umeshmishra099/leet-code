package com.learning.palindrome;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList
{
  public static void main(String[] args)
  {
    ListNode listNode = new ListNode(-129, new ListNode(-129));
    System.out.println(isPalindrome(listNode));
  }

  public static boolean isPalindrome(ListNode head)
  {
    if (head != null){
      List<Integer> values = new ArrayList<Integer>();
      getListFromSingleLinkedList(head, values);
      for (int i = 0; i < values.size() / 2; i++)
      {
        if (!values.get(i).equals(values.get(values.size() - 1 - i)))
        {
          return false;
        }
      }
      return true;
    }
   return true;
  }

  private static void getListFromSingleLinkedList(ListNode node, List<Integer> values)
  {
    final ListNode nextNode = node.next;
    values.add(node.val);
    if (nextNode != null)
    {
      getListFromSingleLinkedList(nextNode, values);
    }
  }
}
