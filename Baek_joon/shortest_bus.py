# 백준 1916번 최소비용 구하기
import heapq
import sys
input = sys.stdin.readline

V = int(input())
E = int(input())
INF = int(1e9)
uvw = [[] for _ in range(V + 1)]
visited = [False] * (V + 1)
distance = [INF] * (V + 1)
for _ in range(E):
    u, v, w = map(int, input().split())
    uvw[u].append([v, w])
s, e = map(int, input().split())

def dijkstra(start):
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
			
dijkstra(s)
print(distance[e])