import sys
import heapq
input = sys.stdin.readline

n = int(input())

array = []
for _ in range(n):
    deadline, cup_ramen = map(int,input().split())
    array.append((deadline, cup_ramen))

# 데드라인 순으로 정렬
array.sort()

# 데드라인이 작고 컵라면이 많은 것을 우선으로 함
# 힙 리스트를 하나 선언
h = []
for deadline, cup_ramen in array:
    heapq.heappush(h, cup_ramen)
    # 만일 데드라인이 현재 heap보다 작으면
    # 데드라인을 넘긴 것으로 pop을 해준다.
    if deadline < len(h):
        heapq.heappop(h)

print(sum(h))