# 백준 9375번 패션왕 신해빈
import sys
input = sys.stdin.readline

def combination(arr, r):
    for i in range(len(arr)):
        if r == 1:
            yield [arr[i]]
        else:
            for next in range(arr[i + 1:], r - 1):
                yield [arr[i]] + next

T = int(input())
result = []

for _ in range(T):
    n = int(input())
    clothes = []

    if n == 0:
        result.append(0)
        continue

    for i in range(n):
        c = list(input().split())
        clothes.append(c[-1])
    
    set_clothes = set(clothes)
    nums = []
    for s in set_clothes:
        nums.append(clothes.count(s))

for r in result:
    print(r)