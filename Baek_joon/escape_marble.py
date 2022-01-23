# 백준 13460번 구슬 탈출
import sys
input = sys.stdin.readline
from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs():
    global result
    q = deque()

    # 빨간, 파란 구슬 위치를 큐에 넣음
    for n in range(N):
        for m in range(M):
            if board[n][m] == 'R':
                q.append((0, n, m, 'R'))
                visit[n][m] = True
            elif board[n][m] == 'B':
                q.appendleft((0, n, m, 'B'))

    while q:
        d, x, y, z  = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            # 만약 
            
        if result != 0:
            break

N, M = map(int, input().split())
result = 0
board = [list(input()) for _ in range(N)]
visit = [[False for _ in range(M)] for _ in range(N)]

bfs()