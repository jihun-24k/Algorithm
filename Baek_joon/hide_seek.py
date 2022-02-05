# 백준 1697번 숨바꼭질 (실버 1)
from collections import deque

def bfs():
    queue = deque([N])
    visited[N] = True

    while queue:
        now = queue.popleft()
        if now == M:
            print(time[now])
            return 
        for i in (2 * now, now + 1, now - 1):
            if visited[i] == False and i <= 100000:
                queue.append(i)
                time[i] = time[now] + 1
                visited[i] = True

N, M = map(int, input().split())
time  = [0] * 100001
visited = [False] * 100001
bfs()