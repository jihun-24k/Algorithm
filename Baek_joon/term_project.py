# 백준 9466번 텀 프로젝트
import sys
input = sys.stdin.readline

T = int(input())
test_case = []
for _ in range(T):
    t = int(input())
    test_case.append([0]+list(map(int,input().split())))

# 테스트 케이스마다 반복
for case in test_case:
    visited = [False for _ in range(len(case))]
    result = 0

    # 케이스들의 노드들을 확인
    for idx in range(1,len(case)):
        # 이미 방문한 노드라면 넘어간다
        if visited[idx]:
            continue

        stack = []
        stack.append(idx)
        before = case[idx]

        while stack:
            
            # 다음 
            if before == case[case[x]]:
                stack.append(case[x])

    print(result)

