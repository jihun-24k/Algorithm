# 백준 9252번 LCS 2
import sys
from collections import deque

S1 = input()
S2 = input()

# 문자열 이차원 dp도 생성
dp = [[0] * (len(S1)+1) for _ in range(len(S2)+1)]
dp2 = [[''] * (len(S1)+1) for _ in range(len(S2)+1)]

if S1[0] == S2[0]:
    dp[1][1] = 1
    dp2[1][1] = S1[0]

for i in range(1,len(S2)+1):
    for j in range(1,len(S1)+1):

        if S2[i-1] == S1[j-1]:
            dp[i][j] = dp[i-1][j-1] + 1
            dp2[i][j] = dp2[i-1][j-1] + S2[i-1]
        # 그게 아니라면 이전 행의 값과 이전 열의 값 중
        # 더 높은 값을 현재 dp값으로 초기화 시켜준다.
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])
            # 문자열을 초기화 시켜줌
            if dp[i][j] == dp[i-1][j]:
                dp2[i][j] = dp2[i-1][j]
            else:
                dp2[i][j] = dp2[i][j-1]
print(dp[-1][-1])
print(dp2[-1][-1])
