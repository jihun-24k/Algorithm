n , k = map(int,input().split())

array = []
for _ in range(n):
    array.append(int(input()))

# 결과값 초기화
result = 0

for i in range(n-1,-1,-1):
    # 가장 큰 동전의 몫만큼 더함
    result += k // array[i]
    # k는 몫을 나눈 나머지로 초기화
    k %= array[i]

print(result)