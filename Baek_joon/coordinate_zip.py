# 백준 18870번 좌표 압축
N = int(input())
coordi = list(map(int, input().split()))
sort_coordi = sorted(list(set(coordi)))

dict = {sort_coordi[i] : i for i in range(len(sort_coordi))} 
for c in coordi:
    print(dict[c], end = ' ')