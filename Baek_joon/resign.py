import sys

n = int(sys.stdin.readline())
array = []

for i in range(0,n):
    array.append(list(map(int, sys.stdin.readline().split())))

# dp 테이블 초기화
dp = [0]*(n+1)

# i 번째 일부터의 최대 값을 계산
for i in range(n-1 , -1 ,-1):
    # 퇴사일을 넘지 않는다면
    if array[i][0] + i < n+1:
        dp[i] = array[i][1]
        for j in range(i, i + array[i][0]):
            if j == i:
                dp[i] = dp[i + array[i][0]] + array[i][1]
            dp[i] = max(dp[i],dp[j+1])
print(max(dp))