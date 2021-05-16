# 백준 9465번 스티커
import sys
input = sys.stdin.readline

T = int(input())
test_case = []
for _ in range(T):
    case = []
    N = int(input())
    for _ in range(2):
        # 1부터 스티커의 인덱스 시작
        case.append([0]+list(map(int,input().split())))
    test_case.append(case)

# 한 케이스씩 검사
for case in test_case:
    # 스티커만큼의 이차원 dp를 초기화
    width = len(case[0])
    dp = [[0 for _ in range(width)] for _ in range(2)]

    dp[0][1] = case[0][1]
    dp[1][1] = case[1][1]

    # 현재 스티커를 선택했다고 생각하고 계산한다.
    for n in range(2, width):
        dp[0][n] = max(dp[1][n-2], dp[1][n-1]) + case[0][n]
        dp[1][n] = max(dp[0][n-2], dp[0][n-1]) + case[1][n]
    print(max(dp[0][-1], dp[1][-1]))
