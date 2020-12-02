# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        # base case,if the LL is empty or have just one node
        if not head or not head.next or k ==0:
            return head

        # Now, in order to solve this question, we have 3 steps to perform,
        # 1. Find the tail of current Linked List and attach it to head, that way we get a circular LL
        # 2. We have to take k+1 nodes  from current LL tail and break there, giving us new tail and new head
        # 3. Now since, we cant traverse backward in SLL, we have to start from beginning and traverse,
        # total_length of LL - k to get new tail and new head
        # 4. In case of, rotations more than length of LL, we just mod it with total length, for example, if LL
        # length is 10 and we rotate it by 12, after 10th rotation, we get the same LL, so in fact, we are
        # doing just 2 rotations and that would be k%length (12%10)


        old_tail = head
        count = 1
        while old_tail.next:
            old_tail = old_tail.next
            count += 1
        # new k
        k = k % count
        if k ==0:
            return head

        old_tail.next = head

        break_at = 1
        ptr = head
        while break_at != count - k:
            ptr = ptr.next
            break_at +=1
        head = ptr.next
        ptr.next = None
        return head
        
