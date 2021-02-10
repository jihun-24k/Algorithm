import sys
import heapq
input = sys.stdin.readline

n, k = map(int, input().split())

# 보석 정보를 힙에 입력
jewels = []
for _ in range(n):
    weight, value = map(int, input().split())
    heapq.heappush(jewels, [-value, weight])

# 가방이 담을 무게 입력
bags = []
for _ in range(k):
    weight = int(input())
    bags.append(weight)

# 가방을 용량 순으로 정렬
bags.sort()

# 용량이 작은 가방 순으로 제일 큰 보석을 담는다.
result = 0
for jewel in jewels:



    
    for bag in bags:
        if jewels[0][1] < bag:
            result -= jewels[0][0]
            heapq.heappop(jewels) 
            bags.pop(bags.index(bag))

print(result)