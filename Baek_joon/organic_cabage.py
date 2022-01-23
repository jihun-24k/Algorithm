# 백준 1012번 유기농 배추 (실버 2)
import sys
input = sys.stdin.readline
sys.setrecursionlimit(1000000)

dx = [-1, 0 , 1 , 0]
dy = [0, 1 , 0 , -1]

# x는 가로, y는 세로
def dfs(x, y):
    farm[y][x] = 0
    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y
        if nx < 0 or ny < 0 or nx >= M or ny >= N:
            continue
        if farm[ny][nx] == 1:
            dfs(nx, ny)
    return
    

results = []
T = int(input())
for _ in range(T):
    M, N, K = map(int, input().split())
    farm = [[0 for _ in range(M)] for _ in range(N)]
    result = 0

    for _ in range(K):
        x, y = map(int, input().split())
        farm[y][x] = 1

    for y in range(N):
        for x in range(M):
            if farm[y][x] == 1:
                result += 1
                dfs(x, y)
    
    results.append(result)

for r in results:
    print(r)