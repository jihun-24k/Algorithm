# 백준 2579번 계단 오르기 (실버3)
N = int(input())
stair = [0] + [int(input()) for _ in range(N)]

dp = [0] * (N + 1)
dp[1] = stair[1]

if (N >= 2):
    dp[2] = dp[1] + stair[2]
    for i in range(3, N + 1):
        dp[i] = max(dp[i-2], dp[i-3] + stair[i-1]) + stair[i]
print(dp[-1])