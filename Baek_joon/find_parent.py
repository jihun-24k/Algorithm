# 백준 11725번 트리의 부모찾기 (실2)
from collections import deque
def bfs(start):
    queue = deque([start])
    visited[start] = start

    while queue:
        v = queue.popleft()
        for num in graph[v]:
            if visited[num] == 0:
                visited[num] = v
                queue.append(num)

N = int(input())
visited = [0] * (N + 1)
graph = [[] for _ in range(N + 1)]

for _ in range(N-1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

bfs(1)
for result in visited[2:]:
    print (result)