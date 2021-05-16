S1 = input()
S2 = input()

# 2차원 배열인 dp 테이블 초기화
dp = [[0] * (len(S1)+1) for _ in range(len(S2)+1)]

# 만약 첫번째 글자가 같다면 dp의 시작을 1로 초기화
if S1[0] == S2[0]:
    dp[1][1] = 1

# S1과 S2의 문자열을 하나씩 점차 비교해간다.
for i in range(1,len(S2)+1):
    for j in range(1,len(S1)+1):
        # 만약 해당 열과 행의 문자가 같다면 이전 값에서 +1
        if S2[i-1] == S1[j-1]:
            dp[i][j] = dp[i-1][j-1] + 1
        # 그게 아니라면 이전 행의 값과 이전 열의 값 중
        # 더 높은 값을 현재 dp값으로 초기화 시켜준다.
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])
print(dp[-1][-1])