# 백준 2606번 바이러스
import sys
from collections import deque
input= sys.stdin.readline

V = int(input())
E = int(input())

graph = [[] for _ in range(V+1)]
for _ in range(E):
    start, end = map(int,input().split())
    graph[start].append(end)
    graph[end].append(start)

result = 0
visited = [False]*(V+1)

def bfs(start):
    # 1번 컴퓨터가 웜바이러스에 걸린다.
    queue = deque([start])
    visited[start] = True
    global result

    while queue:
        v = queue.popleft()

        for i in graph[v]:
            # 큐에 들어갈 때마다 컴퓨터 개수 +1
            if not visited[i]:
                queue.append(i)
                result += 1
                visited[i] = True
bfs(1)
print(result)