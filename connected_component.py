# 백준 11724번 연결요소의 개수

import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int,input().split())

# u, v로 그래프를 입력받는다.
graph = [[] for _ in range(N+1)]
for _ in range(M):
    u, v = map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)

# 방문을 체크하기 위한 리스트
visited = [False] * (N+1)
result = 0

def bfs (graph, start, visited):
    queue = deque([start])    
    visited[start] = True

    while queue:
        start = queue.popleft()
        for i in graph[start]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

# bfs로 검사해서 해당 원소가 방문이 안됐으면
# 연결 요소 값을 1 더해준다.
for i in range(1, N+1):
    if visited[i] == False:
        result += 1
    bfs(graph, i, visited)
print(result)
