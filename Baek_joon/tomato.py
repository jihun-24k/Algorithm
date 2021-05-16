# 백준 7576번 토마토
import sys
from collections import deque
input = sys.stdin.readline

# M은 가로, N은 세로 칸 수
M, N = map(int, input().split())

# 1: 익은 토마토, 0: 안익은 토마토, -1: 토마토가 없음
queue = deque()
box = []

for n in range(N):
    box.append(list(map(int,input().split())))
    for m in range(M):
        if box[n][m] == 1:
            queue.append((n,m, 0))

# 방향 설정
dx = [1,-1,0,0]
dy = [0,0,1,-1]
# 걸린 날
day = 0

while queue:
    # x는 세로, y는 가로, d는 걸린 날
    x, y, d = queue.popleft()
    # 걸린 날을 초기화
    day = d

    # 위, 아래, 오른쪽, 왼쪽 순으로 탐색
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        # 범위 밖일 때
        if nx < 0 or nx >= N or ny < 0 or ny >= M:
            continue
        # 토마토가 없는 칸이거나 이미 익은 칸이면
        if box[nx][ny] == -1:
            continue
        if box[nx][ny] == 1:
            continue
        # 안익은 토마토가 있다면
        if box[nx][ny] == 0:
            queue.append((nx,ny,d+1))
            box[nx][ny] = 1

for result in box:
    if 0 in result:
        day = -1
print(day)