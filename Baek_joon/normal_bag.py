# 백준 12865번 평범한 배낭 (골5)
N, K = map(int, input().split())
things = [[0, 0]]
dp = [[0] * (K+1) for _ in range(N+1)]

for _ in range(N):
    W, V = map(int, input().split())
    things.append([W,V])

for n in range(1, N+1):
    for k in range(1, K+1):
        w, v = things[n]

        if k < w:
            dp[n][k] = dp[n-1][k]
        else:
            dp[n][k] = max(dp[n-1][k], dp[n-1][k-w]+v)

print(dp[N][K])
