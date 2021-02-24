# 백준 1707번 이분그래프
import sys
input = sys.stdin.readline

K = int(input())

# 테스트 케이스들 입력
test_case = []
visited_case = []
for _ in range(K):
    v, e = map(int,input().split())
    for _ in range(v):
        graph = [[]for _ in range(v+1)]
        start, end = map(int,input().split())
        graph[start].append(end)
        graph[end].append(start)
    visited = [False]*(K+1)
    test_case.append(graph)
    visited_case.append(visited)

