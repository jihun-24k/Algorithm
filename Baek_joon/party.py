# 백준 1238번 파티
import heapq
import sys
input = sys.stdin.readline

V, E, X = map(int,input().split())
INF = int(1e9)
uvw = [[] for _ in range(V + 1)]
visited = [False] * (V + 1)
distance = [INF] * (V + 1)
result = 0
for _ in range(E):
    u, v, w = map(int, input().split())
    uvw[u].append([v, w])

def dijkstra(start, distance):
    q = []
    heapq.heappush(q,(0,start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in uvw[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost,i[0]))
			
dijkstra(X, distance)
for i in range(1, V + 1):
    v = [False] * (V + 1)
    d = [INF] * (V + 1)
    dijkstra(i, d)
    result = max(result, distance[i] + d[X])

print(result)