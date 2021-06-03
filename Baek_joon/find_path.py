# 백준 11403번 경로 찾기
import sys
input = sys.stdin.readline
INF = int(10e9)

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]

for k in range(N):
    for i in range(N):
        for j in range(N):
            graph[i][j] = graph[i][j] | (graph[i][k] & graph[k][j])

for row in graph:
    print(*row)