class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None
        self.prev = None


    def __str__(self):
        return f"{self.key}"

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
        # 0 left
        if self.head == None:
            return -1
        # 1 left
        if self.head.next == None:
            self.head = None
            self.tail = None
            node.next == None
            return node.key
        self.head = self.head.next
        self.head.prev = None
        node.next == None
        return node.key
    
    def remove_node(self, node: Node):
        left = node.prev
        right = node.next
        if left is not None:
            left.next = right
        if right is not None:
            right.prev = left
        if node is self.head:
            self.head = right
        if node is self.tail:
            self.tail = left
        node.next = None
        node.prev = None

    
    def __str__(self):
        parts = []
        node = self.head
        while node is not None:
            parts.append(str(node))
            node = node.next
        return "[" + " -> ".join(parts) + "]"
        

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
    
    def remove_from_cache(self, key: int) -> None:
        if key in self.key_to_node:
            node = self.key_to_node[key]
            self.ll.remove_node(node)
            self.key_to_node.pop(key, None)
            self.count -= 1
    
    def remove_LRU_key(self) -> int:
        head_node = self.ll.head
        self.remove_from_cache(head_node.key)
        return head_node.key
        
class LFUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.count = 0
        self.min_freq = 0
        self.freq_to_LRU_map = {}
        self.num_to_freq_map = {}
        

    def get(self, key: int) -> int:
        # print("get, ",key)
        if key in self.num_to_freq_map:
            freq = self.num_to_freq_map[key]
            lru = self.freq_to_LRU_map[freq]
            node = lru.key_to_node.get(key)
            if node:
                value = node.val
            else: 
                value = -2 
                # to check for inconsistency in both maps, will never execute normally
            lru.remove_from_cache(key)
            if self.min_freq == freq and lru.count == 0:
                self.min_freq += 1
            freq += 1
            if freq not in self.freq_to_LRU_map:
                self.freq_to_LRU_map[freq] = LRUCache(self.capacity+20)
            lru_next = self.freq_to_LRU_map[freq]
            self.num_to_freq_map[key] = freq
            lru_next.put(key, value)
            # print(" returning : ", value)
            return value
        else:
            # print(" returning : -1, not found")
            return -1


    def put(self, key: int, value: int) -> None:
        # eviction
        if key not in self.num_to_freq_map and self.count == self.capacity:
            lru_min_freq = self.freq_to_LRU_map[self.min_freq]
            key_evicted = lru_min_freq.remove_LRU_key()
            self.num_to_freq_map.pop(key_evicted, None)
            self.count -= 1
        # print("put, ",key, ", val : ",value)
        freq = self.num_to_freq_map.get(key,0)
        if key in self.num_to_freq_map:
            lru = self.freq_to_LRU_map[freq]
            lru.remove_from_cache(key)
            if self.min_freq == freq and lru.count == 0:
                self.min_freq += 1
                self.freq_to_LRU_map.pop(freq, None)
            self.count -= 1
        else:
            self.min_freq = 1
        self.count += 1
        freq += 1
        if freq not in self.freq_to_LRU_map:
            self.freq_to_LRU_map[freq] = LRUCache(self.capacity+20)
        lru_next = self.freq_to_LRU_map[freq]
        self.num_to_freq_map[key] = freq
        lru_next.put(key, value)
        # print(self)

    
    def __str__(self):
        parts = []
        for key in self.freq_to_LRU_map:
            parts.append(f"         > freqs: {key}, count : {self.freq_to_LRU_map.get(key).count}, keys: {self.freq_to_LRU_map.get(key).ll}")
        return "\n".join(parts)+"\n               count: "+str(self.count)

        

        


# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)