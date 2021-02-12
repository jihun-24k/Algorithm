# 백준 2293번 동전 1

N, K = map(int,input().split())

# 동전의 종류
kinds = []
for _ in range(N):
    kinds.append(int(input()))

dp = [0]*(K+1)
dp[0] = 1

for kind in kinds:
    for i in range(K+1):
        # 만약 동전의 값이 K원 보다 작거나 같으면
        if i >= kind:
            dp[i] += dp[i-kind]
print(dp[K])