import sys
import heapq
input = sys.stdin.readline

n, k = map(int, input().split())

array = list(map(int,input().split()))

# 멀티텝을 써야하는 횟수를 우선순위로 설정
use = []
for i in array:
    use.append([array.count(i),i])

result = 0
multi_tap = use[0:n]
# prior은 우선순위, thing은 전기용품 종류
for prior, thing in use[n:k]:
    if [prior,thing] in multi_tap:
        heapq.heappush(multi_tap, [prior-1, thing])
    else:
        heapq.heappop(multi_tap)
        heapq.heappush(multi_tap, [prior, thing])
        result += 1
print(result)