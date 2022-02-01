# 백준 16928번 뱀과 사다리 (실버 1)
from collections import deque

dp = [-1] * 101
dp[1] = 0
graph = [*range(101)]
queue = deque([1])

N, M = map(int, input().split())
for _ in range(N + M):
    x, y = map(int, input().split())
    graph[x] = y

while queue:
    now = queue.popleft()
    for i in range(1,7):
        next = now + i
        if next > 100:
            break
        next = graph[next]
        if(dp[next] == -1 or dp[next] > dp[now] + 1):
            dp[next] = dp[now] + 1
            queue.append(next)

print(dp[-1])