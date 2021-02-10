n = int(input())
array = list(map(int,input().split()))

# array를 뒤집어서 계산
r_array = sorted(array, reversed=True)

dp1 = [1] * n
dp2 = [1] * n

result = 0

# 가장 긴 증가하는 부분 수열 구하기
for i in range(1,n):
    for j in range(0,i):

        # i 번째의 가장 긴 증가하는 부분 수열 구하기
        if array[j] < array[i]:
            dp1[i] = max(dp1[i], dp1[j]+1 )
            
        # i 번째의 가장 긴 감소하는 부분 수열 구하기
        if r_array[j] < r_array[i]:
            dp2[i] = max(dp2[i], dp2[j]+1)

dp2.reverse()
for i in range(0,n):
    result = max(result, dp1[i]+dp2[i])
print(result)