# 백준 9466번 텀 프로젝트
import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

T = int(input())
ans = []

def find_team(x, result):
    visited[x] = True
    cycle.append(x)
    num = graph[x]

    # 종료 조건
    if visited[num]:
        if num in cycle:
            result += cycle[cycle.index(num):]
        return
    else:
        find_team(num, result)

# 테스트 케이스마다 반복
for _ in range(T):
    V = int(input())
    visited = [False for _ in range(V + 1)]
    graph = [0]+list(map(int,input().split()))
    result = []

    # 케이스들의 노드들을 확인
    for idx in range(1,V + 1):
        if not visited[idx]:
            cycle = []
            find_team(idx, result)
    ans.append(V- len(result))

for a in ans:
    print(a)