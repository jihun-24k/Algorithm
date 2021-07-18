# 백준 3056번 탈출
from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs():
    global result
    q = deque()

    for r in range(R):
        for c in range(C):
            if forest[r][c] == 'S':
                q.append((0, r, c, 'S'))
                visit[r][c] = True
            elif forest[r][c] == '*':
                q.appendleft((0, r, c, '*'))

    while q:
        # d는 걸린 분, xy는 위치, z는 물 또는 고슴도치
        d, x, y, z  = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= R or ny < 0 or ny >= C:
                continue

            # 만약 고슴도치가 동굴을 무사히 갔으면
            if forest[nx][ny] == 'D' and z == 'S':
                result = d + 1
                break
            
            if forest[nx][ny] == '.':
                if z == '*':
                    forest[nx][ny] = '*'
                    q.append((d + 1, nx, ny , z))
                elif not visit[nx][ny]:
                    visit[nx][ny] = True
                    q.append((d + 1, nx, ny, z))
        if result != 0:
            break

R, C = map(int, input().split())
result = 0
forest = [list(input()) for _ in range(R)]
visit = [[False for _ in range(C)] for _ in range(R)]

bfs()
if result == 0:
    print('KAKTUS')
else:
    print(result)