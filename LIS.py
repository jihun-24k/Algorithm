n = int(input())
array = list(map(int,input().split()))

dp = [1] * n

# LIS 알고리즘
# i번째까지의 긴 수열 길이를 초기화 시켜줌
for i in range(1,n):
    for j in range(0, i):
        if array[j] < array[i]:
            dp[i] = max(dp[i], dp[j]+1 )

# dp의 가장 최대값
print(max(dp))