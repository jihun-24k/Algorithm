# n개의 수를 받는다.
n = int(input())
# n개의 정수로 이루어진 수열
array = list(map(int, input().split()))

dp = array
result = max(array)

for i in range(1,n):
    if dp[i-1] > 0 and dp[i] + dp[i-1] >0:
        dp[i] = dp[i] + dp[i-1]
    result = max(result, dp[i])
print(result)
