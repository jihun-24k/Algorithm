# n개의 수를 받는다.
n = int(input())
# n개의 정수로 이루어진 수열
array = []
for i in range(0,n):
    array.append(list(map(int, input().split())))

dp = [0]*n

# 제일 최단거리를 첫번째 요소로 초기화
dp[0] = min(array[0])

for i in range(1,n):
    before = dp[i-1]
    # 만약 해당 최솟값을 가진 색이 2개 이상이라면
    if array[i-1].count(min(array[i-1])) != 1:
        # 다음 색의 모든 비용 중 최솟값으로 초기화
        dp[i] += min(array[i])

    # 이전의 색이 r일 때
    if before == array[i-1][0]:
        dp[i] += min(array[i][1], array[i][2])

    # 이전의 색이 g일 때
    elif before == array[i-1][1]:
        dp[i] += min(array[i][0], array[i][2])

    # 전의 색이 b일 때
    elif before == array[i-1][2]:
        dp[i] += min(array[i][0], array[i][1])

print(sum(dp))