import sys
input = sys.stdin.readline

N = int(input())
origin_code = list(map(int,input().split()))
correct_code = list(map(int,input().split()))

# 올바른 탭 개수와 현재 코드의 탭 개수의 차이
gaps = []
for i in range(N):
    gaps.append(correct_code[i] - origin_code[i])

# dp 선언
dp = [0] * N
dp[0] = gaps[0]
result = 0
for i in range(1,len(gaps)):

    # 탭차이가 양수
    if gaps[i] >= 0:
        # 전 gap이 양수 일 때
        if gaps[i-1] > 0:
            if gaps[i-1] <= gaps[i]:
                dp[i] = dp[i-1] 
            if gaps[i-1] > gaps[i]:
                dp[i] = dp[i-1] + gaps[i-1]

        # 전 gap이 음수 일 때
        elif gaps[i-1] <= 0:
            dp[i] = dp[i-1] + gaps[i-1]

    # 탭차이가 음수
    if gaps[i] < 0:
        if gaps[i-1] < 0:
            if gaps[i-1] >= gaps[i]:
                dp[i] = dp[i-1] 
            if gaps[i-1] < gaps[i]:
                dp[i] = dp[i-1] + gaps[i-1]

        elif gaps[i-1] >= 0:
            dp[i] = dp[i-1] + gaps[i-1]

print(dp[-1] + abs(gaps[-1]))