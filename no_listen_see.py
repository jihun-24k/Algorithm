# 백준 1764번 듣보잡
import sys
input = sys.stdin.readline

N, M = map(int,input().split())

name1 = set()
for _ in range(N):
    name1.add(input()[:-1])

name2 = set()
for _ in range(M):
    name2.add(input()[:-1])

result = sorted(list(name1 & name2))
print(len(result))

for i in result:
    print(i)