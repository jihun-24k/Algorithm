n, m = map(int,input().split())

dp = [0]*(n+1)

dp[n] = m
for i in range(n, 3 , -1):

    for j in range(1, dp[i]):
        # dp[n] = dp[n-1] + dp[n-2]을 만족

        dp[i-1] = dp[i]- j
        dp[i-2] = j
        
        if 2*j > dp[i-1]:
            break
        
print(dp[3]-dp[2])
print(dp[2])
