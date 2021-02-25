# 백준 1707번 이분그래프
import sys
from collections import deque
input = sys.stdin.readline

K = int(input())

# 시작점을 위한 리스트
where_start = deque()
# 테스트 케이스들 입력
test_case = []
for _ in range(K):
    v, e = map(int,input().split())
    graph = [[]for _ in range(v+1)]
    for i in range(e):
        # 그래프에 넣기
        start, end = map(int,input().split())
        if i == 0:
            where_start.append(start)
        graph[start].append(end)
        graph[end].append(start)
    # 각 그래프들의 방문 리스트 만들기
    test_case.append(graph)

# 그래프 마다 검사
for graph in test_case:
    # 방문 리스트
    visited = [False]*len(graph)

    # 마지막 정점부터 빨강으로 칠하면서 시작함
    temp = False
    first = where_start.popleft()
    visited[first] = "red"
    queue = deque([first])

    while queue:
        v = queue.popleft()
        before = visited[v]

        for i in graph[v]:
            if not visited[i]:
                # 이전 색이 빨강이면 파랑을 칠해줌
                if before == "red":
                    queue.append(i)
                    visited[i] = "blue"
                    continue
                # 이전 색이 파랑이면 빨강을 칠해줌
                if before == "blue":
                    queue.append(i)
                    visited[i] = "red"
                    continue
            else:
                if visited[i] == before:
                    temp = True
                if visited[i] != before:
                    continue
    if temp == True:
        print("NO")
    elif temp == False:
        print("YES")
