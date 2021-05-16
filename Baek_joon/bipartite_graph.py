# 백준 1707번 이분그래프
import sys
from collections import deque
input = sys.stdin.readline

K = int(input())

# 테스트 케이스들 입력
test_case = []
for _ in range(K):
    # v는 정점, e는 간선의 개수
    v, e = map(int,input().split())
    graph = [[]for _ in range(v+1)]
    for i in range(e):
        # 그래프에 넣기
        start, end = map(int,input().split())
        graph[start].append(end)
        graph[end].append(start)
    # 각 그래프들의 방문 리스트 만들기
    test_case.append(graph)

# 그래프 마다 검사
for graph in test_case:
    # 그래프마다의 방문 리스트 초기화
    visited = [0 for _ in range(len(graph))]
    temp = False

    for n in range(1,len(graph)):
        # 예외 처리
        if visited[n] > 0:
            continue
        if temp:
            break  

        # 한 정점부터 빨강으로 칠하면서 시작함
        visited[n] = 1
        queue = deque([n])

        while queue:
            v = queue.popleft()
            before = visited[v]

            for i in graph[v]:
                # 방문한 적이 없다면 색을 칠한다.
                if visited[i] == 0:
                    # 이전 색이 빨강이면 파랑을 칠해줌
                    if before == 1:
                        queue.append(i)
                        visited[i] = 2
                        continue
                    # 이전 색이 파랑이면 빨강을 칠해줌
                    if before == 2:
                        queue.append(i)
                        visited[i] = 1
                        continue
                else:
                    if visited[i] == before:
                        temp = True
                    if visited[i] != before:
                        continue
    if temp:
        print("NO")
    else:
        print("YES")