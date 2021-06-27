# 백준 9375번 패션왕 신해빈
# 옷을 입을때도 있지만 그 종류의 옷을 아예 안입을 때도 있음
# 이러한 예외를 잘 생각해야함
# 그래서 조합으로 풀어야하나 봄
import sys
input = sys.stdin.readline

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
    res = 1
    for s in set_clothes:
        res = res * clothes.count(s)

    if len(set_clothes) == 1:
        result.append(len(clothes))
    else:
        result.append(len(clothes) + res)

for r in result:
    print(r)