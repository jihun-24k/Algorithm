# 백준 10942번 팰린드롬?

import sys
input = sys.stdin.readline

N = int(input())
array = [0] + list(map(int, input().split()))

M = int(input())

questions = []
for _ in range(M):
    questions.append(list(map(int, input().split())))

dp= [[0 for _ in range(N+1)] for _ in range(N+1)]

# 펠린드롬 길이가 1과 2일 때
dp[0][0] = 1
for i in range(1,N+1):
    dp[i][i] = 1
    # 만약 이전 값과 같다면 펠린드롬
    if array[i] == array[i-1]:
        dp[i][i-1] = 1

for i in range(1, N+1):
    for start in range(1,N-i+1):
        # 만약 뒤의 두 수가 같고 이전의 dp가 펠린드롬이라면
        if (array[start] == array[start+i]
        and dp[start+1][start+i-1]):
            dp[start][start+i] = 1

for start, end in questions:
    print(dp[start][end])