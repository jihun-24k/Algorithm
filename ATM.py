n = int(input())

array = sorted(list(map(int, input().split())))
result = 0

for i in range(0,n):
    for j in range(0,i+1):
        result += array[j]
print(result)