# 백준 11651번 좌표 정렬하기2
N = int(input())
arr = []
for i in range(N):
    x, y = map(int, input().split())
    arr.append((x,y))

arr.sort(key = lambda x: (x[1],x[0]))
for a in arr:
    x, y = a
    print(x, y)