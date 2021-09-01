# 백준 13460번 구슬 탈출
import sys
input = sys.stdin.readline
from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs():
    global result
    q = deque()

    for n in range(N):
        for m in range(M):
            if board[n][m] == 'R':
                q.append((0, n, m, 'R'))
                visit[n][m] = True
            elif board[n][m] == 'B':
                q.appendleft((0, n, m, 'B'))

    while q:
        # d는 걸린 분, xy는 위치, z는 물 또는 고슴도치
        d, x, y, z  = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue

            # 만약 고슴도치가 동굴을 무사히 갔으면
            if board[nx][ny] == 'D' and z == 'S':
                result = d + 1
                break
            
            if board[nx][ny] == '.':
                if z == '*':
                    board[nx][ny] = '*'
                    q.append((d + 1, nx, ny , z))
                elif not visit[nx][ny]:
                    visit[nx][ny] = True
                    q.append((d + 1, nx, ny, z))
        if result != 0:
            break

N, M = map(int, input().split())
result = 0
board = [list(input()) for _ in range(N)]
visit = [[False for _ in range(M)] for _ in range(N)]

bfs()