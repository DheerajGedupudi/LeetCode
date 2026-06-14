class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None
        self.prev = None

class LL:
    def __init__(self):
        self.head = None
        self.tail = None

    def add_to_right(self, node: Node):
        if self.tail is None:
            self.head = node
            self.tail = node
            return
        self.tail.next = node
        node.prev = self.tail
        self.tail = node

    def remove_at_left(self) -> int:
        node = self.head
        self.head = self.head.next
        self.head.prev = None
        return node.key
    
    def remove_node(self, node: Node):
        left = node.prev
        right = node.next
        if left is not None:
            left.next = node.next
        if right is not None:
            right.prev = node.prev
        if node is self.head:
            self.head = self.head.next
        if node is self.tail:
            self.tail = self.tail.prev
        node.next = None
        node.prev = None
        

class LRUCache:
    
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.count = 0
        self.ll = LL()
        self.key_to_node = {}
        

    def get(self, key: int) -> int:
        if key not in self.key_to_node:
            return -1
        else:
            node = self.key_to_node[key]
            self.ll.remove_node(node)
        self.ll.add_to_right(node)
        return node.val

    def put(self, key: int, value: int) -> None:
        if key in self.key_to_node:
            node = self.key_to_node[key]
            self.ll.remove_node(node)
        else:
            self.count += 1
        node = Node(key, value)
        self.ll.add_to_right(node)
        self.key_to_node[key] = node
        if self.count > self.capacity:
            to_remove = self.ll.remove_at_left()
            self.key_to_node.pop(to_remove, None)
            self.count -= 1
        
        


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)