# 백준 11049번 행렬 곱셈 순서
import sys
input = sys.stdin.readline
# 무한 값을 정의
INF = sys.maxsize

N = int(input())
array = []
for i in range(N):
    r, c = map(int,input().split())
    if i == 0:
        array.append(r)
    array.append(c)

# dp 테이블 선언
dp = [[0 for _ in range(N+1)] for _ in range(N+1)]

# 행렬의 연산 수만큼 반복
for n in range(1, N+1):
    # 대각선의 칸 수 만큼 반복
    for i in range(1, N+1-n):
        j = i + n
        dp[i][j] = INF

        for k in range(i,j):
            multi = array[i-1]*array[k]*array[j]
            dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j] + multi)
print(dp[1][-1])