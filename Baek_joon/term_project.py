# 백준 9466번 텀 프로젝트
import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

T = int(input())
test_case = []
for _ in range(T):
    t = int(input())
    test_case.append([0]+list(map(int,input().split())))

def find_team(x, result):
    visited[x] = True
    cycle.append(x)
    num = case[x]

    # 종료 조건
    if visited[num]:
        if num in cycle:
            result += cycle[cycle.index(num):]
        return
    else:
        find_team(num, result)

# 테스트 케이스마다 반복
for case in test_case:
    visited = [True] + [False for _ in range(len(case)-1)]
    result = []

    # 케이스들의 노드들을 확인
    for idx in range(1,len(case)):
        if not visited[idx]:
            cycle = []
            find_team(idx, result)
    print(len(case) - len(result) - 1)