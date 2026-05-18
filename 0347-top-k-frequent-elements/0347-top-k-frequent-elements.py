class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = {}
        for x in nums:
            if x not in freq:
                freq[x] = 0
            freq[x] += 1
        # print(freq)
        heap = []
        heapq.heapify(heap)
        for key in freq:
            heapq.heappush(heap, (freq[key], key))
            if len(heap) > k:
                heapq.heappop(heap)
        # print(heap)
        return [tup[1] for tup in heap]
        