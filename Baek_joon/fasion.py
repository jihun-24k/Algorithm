# 백준 9375번 패션왕 신해빈
import sys
input = sys.stdin.readline

T = int(input())
result = []

for _ in range(T):
    n = int(input())

    if not n:
        result.append(0)
        continue

    clothes = {}
    for _ in range(n):
        name , type = map(str, input().split())

        if type in clothes.keys():
            clothes[type] += 1
        else:
            clothes[type] = 1
        
        answer = 1
        for key in clothes.keys():
            answer *= clothes[key] + 1
    result.append(answer - 1)

for r in result:
    print(r)