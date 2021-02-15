import sys
import heapq
input = sys.stdin.readline

N, K = map(int, input().split())

array = list(map(int,input().split()))

plug_count = 0
multi_tap = []
for i in range(K):
    # 현재 코드의 다음 코드의 순서를 계산
    # 만일 없다면 100보다 큰 101값을 넣어줌
    try:
        next_idx = array[i+1:].index(array[i])
    except:
        next_idx = 101
    
    # 멀티탭이 다 안찼다면
    if len(multi_tap) < N:
        heapq.heappush(multi_tap,(-next_idx, array[i]))
        continue
    # 멀티탭 안에 이미 꽂혀있다면
    # 같은 코드가 있다면
    if array[i] == multi_tap[-1][1]:
        del multi_tap[-1]
        heapq.heappush(multi_tap,(-next_idx, array[i]))
        continue
    if array[i] == multi_tap[-2][1]:
        del multi_tap[-2]
        heapq.heappush(multi_tap,(-next_idx, array[i]))
        continue
    heapq.heappop(multi_tap)
    heapq.heappush(multi_tap,(-next_idx, array[i]))
    plug_count += 1
print(plug_count)