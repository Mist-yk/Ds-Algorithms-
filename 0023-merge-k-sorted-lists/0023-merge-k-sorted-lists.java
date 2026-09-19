/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.val,b.val)
        );
        for(int i =0; i <lists.length; i++){
            if(lists[i] != null){
                pq.add(lists[i]);
            }
        }
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            temp.next = node;
            temp = temp.next;
            if(node.next != null){
                pq.offer(node.next);
            }

        }
        return result.next;


    }
}