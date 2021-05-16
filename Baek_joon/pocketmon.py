# 백준 1620번 나는야 포켓몬 마스터 이다솜
import sys
input = sys.stdin.readline

N, M = map(int,input().split())
isalpha = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'

name = []
for i in range(N):
    name.append(input()[:-1])

result = []
for _ in range(M):
    q = input()[:-1]
    # 만약 문자열이면
    if q[0] in isalpha:
        result.append(name.index(q)+1)
    else:
        q = int(q)
        result.append(name[q-1])    

for i in range(M):
    print(result[i])