n, m = map(int,input().split())

# 동전의 종류
kind = []
for _ in range(n):
    kind.append(int(input()))

dp = [0]*100000

for i in range(2,m+1):
    for j in range(0,n):
        if i > kind[j]:
            dp[i] = dp[i-kind[j]] + 1