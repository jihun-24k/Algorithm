# 백준 1541번 잃어버린 괄호
arr = input().split('-')

result = 0
for first in arr[0].split('+'):
    result += int(first)

for nums in arr[1:]:
    for num in nums.split('+'):
        result -= int(num)
print(result)